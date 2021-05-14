import java.util.Scanner;

// Hannah Wenger

public class CricketsAndGrasshoppers {
	//Prompts for game initialization
	public static String setUpPrompts(int counter) {
		String[] userPrompts = {"That was not a valid number! Please try again.","Please enter the number of pieces for each player (1-10): ", "Please enter the number of spaces in the middle (1-9):"};
		String prompt = userPrompts[counter];
		return prompt;
	}
	
	public static String gamePlayPrompts(int move, boolean canMove, String player) {
		
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
		int length = piecesPerPlayer + spacesInMiddle;
		int[] newGame = new int[length + 1];
		for(int i = 0; i < newGame.length; i++) {
			if(i < spacesInMiddle ) {
				newGame[i] = 1;
			} else if(i >= piecesPerPlayer && i < (piecesPerPlayer - spacesInMiddle)) {
				newGame[i] = 0;
			} else {
				newGame[i] = 2;
			}
		}
		int i =0;
		while(i < length) {System.out.print(newGame[i]); i++;}
		return newGame;
	}
	
	public static String boardToString(int[] board) {
		String gameBoard = "";
		String newMove = "";
		for(int i = 0; i < board.length; i++) {
			if(board[i] == 1) {
				newMove = "CC ";
			} else if(board[i] == 2) {
				newMove = "GG ";
			} else {
				newMove = ".. ";
			}
			gameBoard = gameBoard + newMove;
		}
		System.out.println(gameBoard);
		return gameBoard;
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
		//Find total pieces
		int playerPieces = player1 + player2;
		//Create Board
		int board[] = createBoard(playerPieces, middleSpaces);
		String boardStatus = boardToString(board);
		
		
		//
	}
}

