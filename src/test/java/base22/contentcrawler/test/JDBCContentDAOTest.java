package base22.contentcrawler.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import base22.contentcrawler.Content;
import base22.contentcrawler.JdbcContentDAO;

public class JDBCContentDAOTest extends DAOIntegrationTest {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JdbcContentDAO dao = new JdbcContentDAO(this.getDataSource());

	@Before
	public void setUp() throws Exception {
//		Content contentTest = new Content();
//		
//		dao.save(content);
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
