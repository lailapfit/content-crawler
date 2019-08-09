package base22.contentcrawler;

import java.util.List;

public interface ContentDAO {

	public void save(Content content);

	public List<Content> getAllContents(Integer listSize);

	public void output(Integer size, String fileName);

}
