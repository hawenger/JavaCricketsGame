import java.util.Scanner;

// Hannah Wenger

public class CricketsAndGrasshoppers {
	
	//Requirement 1 of 6
	public static int promptNumberReadLine(Scanner s, String prompt, int max) {
		while(true) {
		System.out.print(prompt);
		if(s.hasNextInt()) {
			int number = s.nextInt();
			if(number >= 1 && number <= max) {
				s.nextLine();
				return number;
			}

		} else {
			s.nextLine();
			System.out.println("That was not a valid number! Please try again.");
		}
		
		}
		
	}
}
