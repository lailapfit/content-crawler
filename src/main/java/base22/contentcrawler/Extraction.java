package base22.contentcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extraction {
	
	public Content getPageContent(List<String> urls) throws IOException {
		List<String> urlLists = new ArrayList<String>();
		List<String> urlHrefLists = new ArrayList<String>();
		String title = "";
		String body = "";
		String urlText = "";
		String href = "";
		
		for(String url: urls) {
			Document document = Jsoup.connect(url).get();
			title = document.select("title").text();
			body = document.select("body").text();
			Elements links = document.select("a[href]");
			
			
			for(Element link: links) {
				urlText = link.text();
				urlLists.add(urlText);
				href = link.attr("abs:href");
				urlHrefLists.add(href);
			}
		}
		
		Content content = new Content(urlLists, urlHrefLists, title, body);
		
		return content;	
	}
}
