import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Scanner;

public class DuplicateRemover {
	
	Set<String> uniqueWords;
	//set unique words as a string
 	
	void remove(String dataFile) {
		Scanner input = null;
		
		try {
			uniqueWords = new LinkedHashSet<>(); //a place to keep strings from the file
			input = new Scanner(new File(dataFile));
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] words = line.split(" ");
				
				for(int i = 0; i < words.length; i++) {
					String str = words[i].toLowerCase(); //to make sure upper case does not create two of the same word in different cases
					uniqueWords.add(str);
				}
			}
		}
		
		// make sure that there is no problem running the file, and let user know there is if there is one
		catch(Exception e) {
			System.out.println("Unable to open file: " +dataFile);
		}
		if(input != null)
			input.close();
	}
	
	void write(String outputFile) {
		FileWriter output = null;
		try {
			output = new FileWriter(outputFile); //use to open the file
			for(String s : uniqueWords)
				output.write(s + "\n"); //do new line to separate the words into their own lines
			output.close(); //make sure to close the file
		}
		//make sure there is no problem in writing file and if there is let user know
		catch(Exception e) {
			System.out.println("Unable to write file: " +outputFile);
		}
	}
}