import java.util.Scanner;

// Hannah Wenger

public class CricketsAndGrasshoppers {
	//Prompts for game initialization
	public static String setUpPrompts(int counter) {
		String[] userPrompts = {"That was not a valid number! Please try again.\n","Please enter the number of pieces for each player (1-10): ", "\nPlease enter the number of spaces in the middle (1-9): "};
		String prompt = userPrompts[counter];
		return prompt;
	}
	
	//Prompts for game play
	public static String movePrompts(int counter, int boardSize) {
		String[] userPrompts = {"\nCrickets, please enter your move (1-" + boardSize + "): ", "\nGrasshoppers, please enter your move (1-" + boardSize + "): " , "That space does not contain a piece you can move! Please try again.\n"};
		String prompt = userPrompts[counter];
		return prompt;
	}
	
	//Scanner and Prompt reader method
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
	
	//Create initial board
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
		return newGame;
	}
	
	//Turn board into a string
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
	
	//Check for possible moves (win)
	public static boolean canMove(int[] board, int player) {
		for(int i = 0; i < board.length; i++) {
			if(player == 1) {
				if(i + 1 < board.length && board[i] == 1 && board[i + 1] == 0) {
					return true;
				} else if(i + 2 < board.length && (board[i] == 1 && board[i+ 1] == 2) && board[i + 2] == 0) {
					return true;
				}
			} else if (player == 2) {
				if(i - 1 >= 0 && board[i] == 2 && board[i - 1] == 0) {
					return true;
				} else if(i - 2 >= 0 && (board[i] == 2 && board[i - 1] == 1) && board[i - 2] == 0) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}
	
	//Check if move is valid
	public static boolean move(int[] board, int player, int position) {
		position = position - 1;
		if((position >= 0 && position < board.length) && board[position] == player) {
			if(player == 1) {
				if(position + 1 < board.length && board[position + 1] == 0) {
					board = boardMove(board, position, player);
					return true;
				} else if(position + 2 < board.length && board[position + 1] == 2 && board[position + 2] == 0) {
					board = boardMove(board, position, player);
					return true;
				} else {
					return false;
				}
			}
			if(player == 2) {
				if(position - 1 >= 0 && board[position - 1] == 0) {
					board = boardMove(board, position, player);
					return true;
				} else if(position - 2 >= 0 && board[position - 2] == 0 && board[position - 1] == 1) {
					board = boardMove(board, position, player);
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return false;
	}
	
	//Return new board in game play
	public static int[] boardMove(int[] board, int position, int player) {
		
		if(player == 1) {
			if(board[position + 1] == 0) {
				board[position + 1] = 1;
				board[position] = 0;
			} else { 
				board[position + 2] = 1;
				board[position] = 0;
			}
			
		} else {
			
			if(board[position - 1] == 0) {
				board[position - 1] = 2;
				board[position] = 0;
			} else {
				board[position - 2] = 2;
				board[position] = 0;
			}
		}
		
		return board;
	}
	
	public static void main(String[] args) {
	
	//INITIALIZE GAME
		
		//Index for prompts method
		int index = 1;
		
		//Initialize Scanner
		Scanner userPrompt = new Scanner(System.in);
		
		//Grab player pieces count
		int max = 10;
		int piecesPerPlayer = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		index++;
		
		//Grab spaces in the middle
		max = 9;
		int middleSpaces = promptNumberReadLine(userPrompt, setUpPrompts(index), max);
		int boardSize = middleSpaces + (piecesPerPlayer * 2);
		
		//Create Board and moves loop
		max = boardSize;
		int board[] = createBoard(piecesPerPlayer,  middleSpaces);
		String boardString = boardToString(board);
		System.out.println("\n" + boardString);
	
	//GAME PLAY LOOP
		
		do {
			
		//CRICKET MOVES
			
			//Variable for cricket moves prompt
			int cricketMove = 0; 
			//Variable to confirm valid move
			boolean isPossibleCricket = false; 
			
			//Loop until valid move entered
			while(!isPossibleCricket) {
				cricketMove = promptNumberReadLine(userPrompt, movePrompts(0, boardSize), max);
				isPossibleCricket = move(board, 1, cricketMove);
			}
			//Set new board
			//if(isPossibleCricket) {
				//board = boardMove(board, cricketMove, 1); 
				boardString = boardToString(board);
			//}
			//Check if Grasshopper can move
			boolean isCricketWin = canMove(board, 2);
			if(!isCricketWin) {
				System.out.println("Crickets Win!\n");
				break;
			} else {
				System.out.println("\n" + boardString);
			}

		
		//GRASSHOPPER MOVES
		
			//Variable for grasshopper moves prompt
			int grasshopperMove = 0;
			//Variable to confirm valid move
			boolean isPossibleGrasshopper = false;
			
			//Loop until valid move entered
			while(!isPossibleGrasshopper) {
				grasshopperMove = promptNumberReadLine(userPrompt, movePrompts(1, boardSize), max);
				isPossibleGrasshopper = move(board, 2, grasshopperMove);
			}
			//Set new board
			//if(isPossibleGrasshopper) {
				//board = boardMove(board, grasshopperMove, 2);
				boardString = boardToString(board);
			//}
			//Check if cricket can move
			boolean isGrasshopperWin = canMove(board, 1);
				if(!isGrasshopperWin) {
					System.out.println("Grasshoppers Win!");
						break;
				} else {
					System.out.println("\n" + boardString);
				}
				
		} while(true);
		
	}
	
}

