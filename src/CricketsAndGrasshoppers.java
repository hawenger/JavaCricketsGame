import java.util.Scanner;

// Hannah Wenger

public class CricketsAndGrasshoppers {
	//Prompts for game initialization
	public static String setUpPrompts(int counter) {
		String[] userPrompts = {"That was not a valid number! Please try again.","Please enter the number of pieces for each player (1-10): ", "Please enter the number of spaces in the middle (1-9):"};
		String prompt = userPrompts[counter];
		return prompt;
	}
	
	public static String movePrompts(int counter, int boardSize) {
		String[] userPrompts = {"Crickets, please enter your move (1-" + boardSize + "):", "Grasshoppers, please enter your move (1-" + boardSize + "):" , "That space does not contain a piece you can move! Please try again."};
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
		int[] newGame = new int[(piecesPerPlayer * 2) + spacesInMiddle];
		
		for(int i = 0; i < newGame.length; i++) {
			if(i < piecesPerPlayer) {
				newGame[i] = 1;
			} else if( i >= piecesPerPlayer + spacesInMiddle) {
				newGame[i] = 2;
			} else {
				newGame[i] = 0;
			}
		}
		//int i =0;
		//while(i < newGame.length) {System.out.print(newGame[i]); i++;}
		return newGame;
	}
	
	public static String boardToString(int[] board) {
		String gameBoard = "";
		String newMove = "";
		for(int i = 0; i < board.length; i++) {
			if(board[i] == 1) {
				newMove = "C";
			} else if(board[i] == 2) {
				newMove = "G";
			} else {
				newMove = ".";
			}
			gameBoard = gameBoard + newMove;
		}
		//System.out.println(gameBoard);
		return gameBoard;
	}
	

	
	public static boolean canMove(int[] board, int player) {
		for(int i = 0; i < board.length; i++) {
			if(player == 1) {
				if(board[i] == player && board[i + 1] == 0) {
					return true;
				} else if(board[i] == player && board[i+ 1] == 2 && board[i + 2] == 0) {
					return true;
				}
			} else {
				if(board[i] == player && board[i - 1] == 0) {
					return true;
				} else if(board[i] == player && board[i - 1] == 1 && board[i - 2] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean move(int[] board, int player, int position) {
		int index = 0;
		position = position - 1;
		if(board[position] == player) {
			if(player == 1) {
				if(board[position + 1] == 0) {
					return true;
				} else if(board[position + 1] == 2 && board[position + 2] == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				if(board[position - 1] == 0) {
					return true;
				} else if(board[position - 1] == 1 && board[position - 2] == 0) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
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
		int piecesPerPlayer = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		index++;
		//Grab spaces in the middle
		max = 9;
		int middleSpaces = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		
		int boardSize = middleSpaces + piecesPerPlayer;
		
		//Create Board and moves loop
		max = 5;
		while(true) {
		int board[] = createBoard(piecesPerPlayer,  middleSpaces);
		//String boardStatus = boardToString(board);
		String boardString = boardToString(board);
		//Print string to screen before each move
		System.out.println(boardString);
		
		//CRCIKET MOVES
		
		//Check if crickets can move
		boolean isGrasshopperWin = canMove(board, 1);
		if(!isGrasshopperWin) {
			System.out.println("Grasshoppers Win!");
			break;
		}
		System.out.println(isGrasshopperWin);
		int cricketMove = promptNumberReadLine(userPrompt, movePrompts(0, boardSize), max);
		boolean isPossibleCricket = move(board, 1, cricketMove);
		if(isPossibleCricket) {
			//int board[] = 
		}
		System.out.println(isPossibleCricket);
		
		//GRASSHOPPER MOVES
		boolean isCricketWin = canMove(board, 2);
		if(!isCricketWin) {
			System.out.println("Crickets Win!");
			break;
		}
		System.out.println(isCricketWin);
		int grasshopperMove = promptNumberReadLine(userPrompt, movePrompts(1, boardSize), max);
		boolean isPossibleGrasshopper = move(board, 2, grasshopperMove);
		System.out.println(isPossibleGrasshopper);
		
		
		}
		
	}
	
}

