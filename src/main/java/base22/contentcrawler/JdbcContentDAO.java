package base22.contentcrawler;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcContentDAO implements ContentDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcContentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//saving each Content into the database
	@Override
	public void save(Content content) {
		String sqlAddContent = "INSERT INTO content (url, title, body, links) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddContent, content.getInputUrl(), content.getTitle(), content.getBody(),
				content.getFormatedLinks());
	}

	@Override
	public List<Content> getAllContents(Integer listSize) {
		List<Content> contentList = new ArrayList<Content>();
		String sqlSearchAllContents = "SELECT * FROM content ORDER BY id DESC LIMIT ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchAllContents, listSize);
		while (results.next()) {
			contentList.add(mapToRowContent(results));
		}
		return contentList;
	}
	
	//output method to provide the csv file
	@Override
	public void output(Integer size, String fileName) {

		Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), fileName);
		String sqlOutput = "COPY (SELECT * FROM content ORDER BY id DESC LIMIT " + size + ") TO '" + path
				+ "' DELIMITER ',' CSV HEADER";

		jdbcTemplate.update(sqlOutput);

	}
	
	//helper method to map out the contents needed in the database
	private Content mapToRowContent(SqlRowSet row) {
		Content content = new Content();

		content.setInputUrl(row.getString("url"));
		content.setTitle(row.getString("title"));
		content.setBody(row.getString("body"));
		content.setFormatedLinks(row.getString("links"));
		return content;
	}

}
