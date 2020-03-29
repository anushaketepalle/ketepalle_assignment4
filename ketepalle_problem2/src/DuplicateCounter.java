import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	private Map<String, Integer> wordCounter;
	
	public DuplicateCounter() {
		wordCounter = new HashMap<String, Integer>();
	}
	
	void count(String dataFile) {
		Scanner fileReader;
		try {
			fileReader = new Scanner(new File(dataFile));
			
			while(fileReader.hasNext()) {
				String word = fileReader.nextLine().trim();
				Integer count = wordCounter.get(word);
				
				if(count == null)
					count = 1;
				else
					count = count + 1;
				wordCounter.put(word, count);
				}
			}
		catch (FileNotFoundException e) {
			System.out.println("Unable to open file: " +dataFile);
			return;
		}
		fileReader.close();
	}
	
	void write(String outputFile) {
		try {
			PrintWriter filePrinter = new PrintWriter(new File(outputFile));
			
			for(String k : wordCounter.keySet()) {
				filePrinter.println(k + " " + wordCounter.get(k));				
			}
			filePrinter.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Unable to write file: " +outputFile);
		}
	}
}