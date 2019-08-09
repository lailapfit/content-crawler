package base22.contentcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {

	private ContentDAO dao;

	public Main() throws IOException {
		BasicDataSource dataSource = new BasicDataSource();
		//the database I am currently using
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

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the file name to start the Content Crawler >>> ");
		String user = in.nextLine();
		String outputFileName = "output.csv";
		FileInput fileInput = new FileInput();
		List<String> urlList = fileInput.input(user);

		Integer size = urlList.size();

		// System.out.println(size); used for testing

		Extraction ex = new Extraction();

		for (int i = 0; i < urlList.size(); i++) {
			String name = urlList.get(i);

			URL href = null;

			// handle Exception
			try {
				href = new URL(name);
			} catch (MalformedURLException e) {
				System.out.println("The URL is not valid.");
				System.out.println(e.getMessage());
			}

			// print urls
			if (href != null) {
				System.out.println(href.toString());
			}

			Content content = ex.getPageContent(href);

			dao.save(content);
		}
		dao.output(size, outputFileName);
		
		System.out.println("Your file " + outputFileName + " is ready in /Users/[your name]");
	}

}
