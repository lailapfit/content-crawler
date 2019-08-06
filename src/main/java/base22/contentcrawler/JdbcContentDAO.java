package base22.contentcrawler;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcContentDAO implements ContentDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcContentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Content content) {
		
	}

}
