package base22.contentcrawler.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import base22.contentcrawler.FileInput;

public class FileInputOutputTest {
	
	private FileInput io = new FileInput();

	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void inputTest() throws FileNotFoundException {
		List<String> urlListTest = io.input("test.txt");	
		Integer urlListSizeTest = urlListTest.size();		
		Integer sizeResult = 3;
		String firstUrlResult = "https://pinchofyum.com/";
		String firstUrlActual = urlListTest.get(1).toString();
		
		assertEquals(sizeResult, urlListSizeTest);
		assertEquals(firstUrlResult, firstUrlActual);
		
	}

}
