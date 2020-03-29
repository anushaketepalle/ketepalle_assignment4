public class Application {

	public static void main(String[] args) {
		String dataFile = "problem2.txt";
	    String outputFile = "unique_word_counts.txt";

	    DuplicateCounter dc = new DuplicateCounter();
	    dc.count(dataFile);
	    dc.write(outputFile);
	    
	    System.out.println("Program has successfully run, check unique_word_counts.txt file.");
	}

}
