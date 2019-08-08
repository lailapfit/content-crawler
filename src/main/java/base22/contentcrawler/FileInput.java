package base22.contentcrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {
	
	public List<String> input(String inputFile) throws FileNotFoundException {
		List<String> urlList = new ArrayList<String>();
		
	//	@SuppressWarnings("resource")
//		Scanner in = new Scanner(System.in);
//		System.out.println("Please enter the filename to start the Content Crawler >>> ");
//		String user = in.nextLine();
		File incomingFile = new File(inputFile);
		
		@SuppressWarnings("resource")
		Scanner fileScanner =  new Scanner(incomingFile);
		
		while(fileScanner.hasNextLine()) {
			String url = fileScanner.nextLine();
			urlList.add(url);
		}
		
		return urlList;
		
	}
	
	
}
