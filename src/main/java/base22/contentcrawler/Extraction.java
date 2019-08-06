package base22.contentcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extraction {
	
	public void getPageContent(List<String> urls) throws IOException {
		List<String> linkList = new ArrayList<String>();
		
		for(String url: urls) {
			Document document = Jsoup.connect(url).get();
			String title = document.select("title").text();
			Elements body = document.select("body");
			Elements links = document.select("a[href]");
			
			System.out.println(title);
			
//			for(Element link: links) {
//				linkList.add(link);
//			}
		}
	}
}
