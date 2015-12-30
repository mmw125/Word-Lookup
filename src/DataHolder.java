import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHolder {
	private ArrayList<String> strings;
	
	public DataHolder() throws IOException {
		strings = new ArrayList<String>();
		Scanner scanner = new Scanner(new File("US.dic"));
		while(scanner.hasNextLine()) {
			strings.add(scanner.nextLine());			
		}
		scanner.close();
	}
	
	public ArrayList<String> databaseLookup(String lookup) {
		ArrayList<String> returnVal = new ArrayList<String>();
		for(String str : strings) {
			if(str.length() == lookup.length()) {
				boolean works = true;
				for(int i = 0; i < lookup.length(); i++) {
					if(lookup.charAt(i) != '*' && lookup.charAt(i) != str.charAt(i)) {
						works = false;
					}
				}
				if(works) {
					returnVal.add(str);
				}
			} else if(str.length() > lookup.length()) {
				return returnVal;
			}
		}
		return returnVal;
	}
}
