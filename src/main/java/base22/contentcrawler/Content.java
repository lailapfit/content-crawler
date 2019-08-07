package base22.contentcrawler;

import java.util.List;

public class Content {
	
	private String linkText;
	private String linkHref;
	private String title;
	private String body;
	private List<String> linkTextList;
	private List<String> linkHrefList;
	
	public Content(List<String> linkTextList, List<String> linkHrefList, String title, String body) {
		this.linkTextList = linkTextList;
		this.linkHrefList = linkHrefList;
		this.title = title;
		this.body = body;
	}

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

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getLinkHref() {
		return linkHref;
	}

	public void setLinkHref(String linkHref) {
		this.linkHref = linkHref;
	}

	public List<String> getLinkTextList() {
		return linkTextList;
	}

	public void setLinkTextList(List<String> linkTextList) {
		this.linkTextList = linkTextList;
	}

	public List<String> getLinkHrefList() {
		return linkHrefList;
	}

	public void setLinkHrefList(List<String> linkHrefList) {
		this.linkHrefList = linkHrefList;
	}

	
	

}
