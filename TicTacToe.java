package Level2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		Random random=new Random();
		boolean firstPlayer = random.nextBoolean();
		Scanner sc = new Scanner(System.in);
		int num=0, countX=0,countO=0;
		char[][] board = new char[3][3];
		initializeBoard(board);
		
		boolean gameOver=false;
		
		System.out.println("------    Game Begin    ------");
		System.out.println("++++++---   RULES   ---++++++");
		System.out.println("On the thrid invalid you lose.");
		System.out.println("To make your move enter a single digit numbers");
		System.out.println("The no. will replace O or X \n");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(++num +"   ");
			}
			System.out.println();
		}
		System.out.println();
	    
		while(!gameOver) {
			if(firstPlayer) {
				System.out.println("Player O make your move");
				  int move = getValidMove(sc, 1, 9);
				  
				  if(fillO(move,board)) {
					  firstPlayer=!firstPlayer;
					  countO++;
					  if(countO>2) {
						  System.out.println("=== O Loses ===");
						  break;
					  }
				  }
				  if(checkWin(board)) {
					  System.out.println("------   O WINS   ------");
					  break;
				  }
				  display(board);
			}else {
				System.out.println("Player X make your move");
				  int move = getValidMove(sc, 1, 9);
				  if(fillX(move,board)) {
					  firstPlayer=!firstPlayer;
					  countX++;
					  if(countX>2) {
						  System.out.println("=== X Loses ===");
						  break;
					  }
				  }
				  if(checkWin(board)) {
					  System.out.println("------   X WINS   ------");
					  break;
				  }
				  display(board);
			}
			  if (firstPlayer) {
	                firstPlayer =!firstPlayer; // Switch turns
	            } else {
	                firstPlayer =!firstPlayer; // Switch turns
	            }
			  if (isDraw(board)) {
	                System.out.println("It's a draw!");
	                break;
	            }
	        
		}
		sc.close();
				
	}

	private static int getValidMove(Scanner sc, int min, int max) {
		int move = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Enter your move (between " + min + " and " + max + "): ");
                move = sc.nextInt();
                if (move >= min && move <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid move. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume newline left-over
            }
        }

        return move;
	}

	private static boolean fillX(int move, char[][] board) {
	     int row = (move - 1) / 3;
	        int col = (move - 1) % 3;
	        if (board[row][col] == ' ') {
	            board[row][col] = 'X';
	        } else {
	            System.out.println("Invalid choice ");
	            return true;
	        }
	        return false;
	}

	private static boolean fillO(int move, char[][] board) {
		 int row = (move - 1) / 3;
	        int col = (move - 1) % 3;
	        if (board[row][col] == ' ') {
	            board[row][col] = 'O';
	        } else {
	            System.out.println("Invalid choice ");
	            return true;
	        }
		return false;
	}

	private static void display(char[][] board) {
		  for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	}

	private static boolean isDraw(char[][] board) {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
	}

	private static boolean checkWin(char[][] board) {
		return (checkRow(board) || checkCol(board) || checkDia(board) );
	}

	private static boolean checkDia(char[][] board) {
		
		return ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) &&
	               (board[1][1]!= ' ');
	}

	private static boolean checkCol(char[][] board) {
		  for (int i = 0; i < 3; i++) {
	            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i]!= ' ') {
	                return true;
	            }
	        }
		return false;
	}

	private static boolean checkRow(char[][] board) {
		 for (int i = 0; i < 3; i++) {
	            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0]!= ' ') {
	                return true;
	            }
	        }
		return false;
	}

	private static void initializeBoard(char[][] board) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=' ';
			}
		}
	}
}
