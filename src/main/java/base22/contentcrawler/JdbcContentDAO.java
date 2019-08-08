package base22.contentcrawler;

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

	@Override
	public void save(Content content) {
		String sqlAddContent = "INSERT INTO content (url, title, body, links) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddContent, content.getHref(), content.getTitle(), content.getBody(), content.getFormatedLinks());
	}

	@Override
	public List<Content> getAllContents(Integer listSize) {
		List<Content> contentList = new ArrayList<Content>();
		String sqlSearchAllContents = "SELECT * FROM content ORDER BY id DESC LIMIT ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchAllContents, listSize);
		while(results.next()) {
			contentList.add(mapToRowContent(results));
		}
		return contentList;
	}
	
	private Content mapToRowContent(SqlRowSet row) {
		Content content = new Content();
		
		content.setHref(row.getString("url"));
		content.setTitle(row.getString("title"));
		content.setBody(row.getString("body"));
		content.setFormatedLinks(row.getString("links"));
		return content;	
	}

	@Override
	public void output(Integer size) {
		String sqlExportToCsv = "\\copy (SELECT * FROM content ORDER BY id DESC LIMIT " + size + " ) 'output.csv' with csv";
		jdbcTemplate.update(sqlExportToCsv, size);		
	}

	
	
}
