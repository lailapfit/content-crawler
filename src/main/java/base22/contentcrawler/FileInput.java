package base22.contentcrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {
	
	//gathering list of urls from the input file
	public List<String> input(String inputFile) throws FileNotFoundException {
		List<String> urlList = new ArrayList<String>();
		File incomingFile = new File(inputFile);

		@SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(incomingFile);

		while (fileScanner.hasNextLine()) {
			String url = fileScanner.nextLine();
			urlList.add(url);
		}

		return urlList;

	}

}
