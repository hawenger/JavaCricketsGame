import java.util.Scanner;

// Hannah Wenger

public class CricketsAndGrasshoppers {
	//Prompts for game initialization
	public static String setUpPrompts(int counter) {
		String[] userPrompts = {"That was not a valid number! Please try again.","Please enter the number of pieces for each player (1-10): ", "Please enter the number of spaces in the middle (1-9):5"};
		String prompt = userPrompts[counter];
		return prompt;
	}
	//Requirement 1 of 6
	public static int promptNumberReadLine(Scanner s, String prompt, int max) {
		String error = setUpPrompts(0);
		while(true) {
		System.out.print(prompt);
		if(s.hasNextInt()) {
			int number = s.nextInt();
			if(number >= 1 && number <= max) {
				s.nextLine();
				return number;
			} else {
				s.nextLine();
				System.out.print(error);
			}

		} else {
			s.nextLine();
			System.out.println(error);
		}
		
		}
		
	}
	
	public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle) {
		int[] newGame;
		for(int i = 0; i < piecesPerPlayer; i++) {
			
		}
	}
	
	public static String boardToString(int[] board) {
		String gameBoard = board;
		
	}
	
	public static boolean canMove(int[] board, int player) {
		if() {
			
			return true;
		} else {
			return false;
		}
	}
	public static boolean move(int[] board, int player, int position) {
		
	}
	
	public static void main(String[] args) {
		//Index for prompts Method
		int index = 1;
		//Initialize Scanner
		Scanner userPrompt = new Scanner(System.in);
		
		//Grab Step 1/6 prompt
		//String prompt = prompts();
		
		//Grab player pieces count
		int max = 10; // Max # pieces to pass to method
		int player1 = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		int player2 = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		index++;
		//Grab spaces in the middle
		max = 9;
		int middleSpaces = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		
		//
	}
}

