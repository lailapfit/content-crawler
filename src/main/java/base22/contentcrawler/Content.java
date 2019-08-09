package base22.contentcrawler;

import java.util.List;

public class Content {
	
	private String hrefText;	//url description tag
	private String href;		//url tag
	private String title;
	private String body;
	private String inputUrl;	//url being scrapped for content
	private String formatedLinks;	//formatted version of url description tag + url tag itself
	private List<String> hrefTextList;
	private List<String> hrefList;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getHrefText() {
		return hrefText;
	}
	public void setHrefText(String hrefText) {
		this.hrefText = hrefText;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<String> getHrefTextList() {
		return hrefTextList;
	}
	public void setHrefTextList(List<String> hrefTextList) {
		this.hrefTextList = hrefTextList;
	}
	public List<String> getHrefList() {
		return hrefList;
	}
	public void setHrefList(List<String> hrefList) {
		this.hrefList = hrefList;
	}
	public String getInputUrl() {
		return inputUrl;
	}
	public void setInputUrl(String inputUrl) {
		this.inputUrl = inputUrl;
	}
	public String getFormatedLinks() {
		return formatedLinks;
	}
	public void setFormatedLinks(String formatedLinks) {
		this.formatedLinks = formatedLinks;
	}


	
	

}
