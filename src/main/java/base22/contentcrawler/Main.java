package base22.contentcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {

	private ContentDAO dao;

	public Main() throws IOException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/contentcrawler");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dao = new JdbcContentDAO(dataSource);
	}
	
	public static void main(String[] args) throws IOException {
		Main mainCLI = new Main();
		mainCLI.run();
		
	}

	public void run() throws IOException {
//		 String url1 =
//		 "http://base22.com/wps/portal/base22/blog/blog/designing-for-content-management-systems";
//		 String url2 =
//		 "http://www.tmco-usa.com/products/";
//		 
//		URL one = new URL(url1);
//		
//		Extraction ex = new Extraction();
//		
//		Content content = ex.getPageContent(one);
//		
//		String title = content.getTitle();
//		String body = content.getBody();
//		System.out.println(title);
//		System.out.println(body);
		
		///test above
		
		FileInput in = new FileInput();
		List<String> urlList = in.input("urls.txt");

		Integer size = urlList.size();
		System.out.println(size);

		Extraction ex = new Extraction();

		// List<Content> contentList = new ArrayList<Content>();
	
		for (int i = 0; i < urlList.size(); i++) {
			String name = urlList.get(i);
			System.out.println(name);
			 URL href = new URL(name);
			 System.out.println(href);
//
//			// handle Exception
//			try {
//				href = new URL(url);
//			} catch (MalformedURLException e) {
//			    System.out.println("The URL is not valid.");
//			    System.out.println(e.getMessage());
//			}
//
//			// print
//			if (url != null) {
//			    System.out.println(url.toString());
//			}
			
			Content content = ex.getPageContent(href);
			dao.save(content);
			// contentList.add(content);
		}

		dao.output(size);
	}


}
