package base22.contentcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		String url1 = 
				"https://base22.com/blog/modern-web-development-which-javascript-framework-is-right-for-my-organization/";
		String url2 = 
				"http://www.tmco-usa.com/products/";
		
		List<String> urlList = new ArrayList<String>();
		urlList.add(url1);
		urlList.add(url2);
		
		Extraction ex = new Extraction();
		
		ex.getPageContent(urlList);
	}

}
