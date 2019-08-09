package base22.contentcrawler.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		Content contentTest = new Content();
		contentTest.setInputUrl("testing.gov");
		contentTest.setTitle("Test");
		contentTest.setBody("testing body here");
		contentTest.setFormatedLinks("[testlink][testlinktest]");
		dao.save(contentTest);
		
	}

	@Test
	public void getAllContentsTest() {
		List<Content> contentListTest = dao.getAllContents(1);
		Integer sizeResultTest = 1;
		Integer result = contentListTest.size();		
		
		assertEquals(sizeResultTest, result);
	}

}
