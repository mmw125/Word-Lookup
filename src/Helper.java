import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

	public Helper() {
		
		
		System.out.println("Importing data file");
		DataHolder holder;
		try {
			holder = new DataHolder();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Scanner sc = new Scanner(System.in);
		while(true) {			
			System.out.println("What is the search string?");
			String searchStr = sc.nextLine();
			
			System.out.println();
			ArrayList<String> strings = holder.databaseLookup(searchStr);
			
			for(String str : strings) {
				System.out.println(str);
			}
			System.out.println(strings.size() + " items returned");
		}
	}
	
	public static void main(String[] args) {
		new Helper();
	}

}
