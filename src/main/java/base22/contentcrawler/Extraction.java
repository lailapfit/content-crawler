package base22.contentcrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extraction {

	public Content getPageContent(URL hrf) throws IOException {
		String url = hrf.toString();
		
		List<String> urlTextLists = new ArrayList<String>();
		List<String> urlHrefLists = new ArrayList<String>();

		Document document = Jsoup.connect(url).get();
		String title = document.select("title").text();
		String body = document.select("body").text();
		Elements links = document.select("a[href]");
		String eachLink = url;

		for (Element link : links) {
			String urlText = link.text();
			urlTextLists.add(urlText);
			String href = link.attr("abs:href");
			urlHrefLists.add(href);
		}

		String linksFormatted = formatLinks(urlTextLists, urlHrefLists);

		Content content = new Content();
		content.setTitle(title);
		content.setBody(body);
		content.setInputUrl(eachLink);
		content.setFormatedLinks(linksFormatted);

		return content;
	}

	private String formatLinks(List<String> links, List<String> linkTexts) {
		String format = "";
		for (int i = 0; i < links.size(); i++) {
			format = "[" + links.get(i) + "][" + linkTexts.get(i) + "]";
		}
		return format;
	}
}
