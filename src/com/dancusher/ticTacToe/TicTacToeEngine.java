//uses singleton pattern
package com.dancusher.ticTacToe;

public class TicTacToeEngine {
	private static TicTacToeEngine instance = null;

	private int board;
	private Player player1;
	private Player player2;
	private static boolean suppressOutput;
	
	protected TicTacToeEngine(){
		super();
	}
	
	public static TicTacToeEngine getInstance() {
		if(instance==null) {
			instance = new TicTacToeEngine();
		}
		return instance;
	}
	
	private static void println(String outPut) {
		print(outPut + '\n');
	}
	
	private static void print(String outPut) {
		if(!suppressOutput) {
			System.out.print(outPut);
		}
	}
	
	public static int getSpace(int board, int space) {
		switch (space) {
		case 0:	return (board / 100000000)%10;
		case 1:	return (board / 10000000)%10;
		case 2:	return (board / 1000000)%10;
		case 3:	return (board / 100000)%10;
		case 4:	return (board / 10000)%10;
		case 5:	return (board / 1000)%10;
		case 6:	return (board / 100)%10;
		case 7:	return (board / 10)%10;
		case 8:	return (board / 1)%10;
		default: return -1;
		}
	}
	
	public static int checkForWin(int board) {
		//returns 1 for player1 win, 2 for player2 win, -1 for draw, 0 for game not over
		if (
				//check horizontals
					board % 1000 == 111 ||
					(board / 1000) % 1000 == 111 ||
					(board / 1000000) == 111 ||
				//check verticals
					(getSpace(board,0) == getSpace(board,3) && getSpace(board,3) == getSpace(board,6) && getSpace(board,0) == 1) ||
					(getSpace(board,1) == getSpace(board,4) && getSpace(board,4) == getSpace(board,7) && getSpace(board,1) == 1) ||
					(getSpace(board,2) == getSpace(board,5) && getSpace(board,5) == getSpace(board,8) && getSpace(board,2) == 1) ||
				//check diagonals
					(getSpace(board,0) == getSpace(board,4) && getSpace(board,4) == getSpace(board,8) && getSpace(board,0) == 1) ||
					(getSpace(board,2) == getSpace(board,4) && getSpace(board,4) == getSpace(board,6) && getSpace(board,2) == 1)
				) {
				return 1;
		} else if (
				//check horizontals
					board % 1000 == 222 ||
					(board / 1000) % 1000 == 222 ||
					(board / 1000000) == 222 ||
				//check verticals
					(getSpace(board,0) == getSpace(board,3) && getSpace(board,3) == getSpace(board,6) && getSpace(board,0) == 2) ||
					(getSpace(board,1) == getSpace(board,4) && getSpace(board,4) == getSpace(board,7) && getSpace(board,1) == 2) ||
					(getSpace(board,2) == getSpace(board,5) && getSpace(board,5) == getSpace(board,8) && getSpace(board,2) == 2) ||
				//check diagonals
					(getSpace(board,0) == getSpace(board,4) && getSpace(board,4) == getSpace(board,8) && getSpace(board,0) == 2) ||
					(getSpace(board,2) == getSpace(board,4) && getSpace(board,4) == getSpace(board,6) && getSpace(board,2) == 2)
				) {
				return 2;
			}
		for(int i=0;i<9;i++){
			if((int)(board/(Math.pow(10, i))%10)==0) {
				return 0;
			}
		}
		return -1;	
	}
	
	public int playGame (Player player1, Player player2, boolean suppressOutput) {
		this.player1 = player1;
		this.player2 = player2;
		this.suppressOutput = suppressOutput;
		player1.startNewGame(true);
		player2.startNewGame(false);
		board = 0;
		int turn = 1;
		while(true) {
			printBoard(board);
			if (turn % 2 == 1) {
				while (!processMove(1, player1.makeMove(board)));
			} else {
				while(!processMove(2, player2.makeMove(board)));
			}
			int winStatus = checkForWin(board);
			if (winStatus == -1) {
				printBoard(board);
				println("No one wins.  Game over.");
				return winStatus;
			} else if (winStatus != 0) {
				printBoard(board);
				println("Player " + winStatus + " wins!  Game Over.");
				return winStatus;
			}
			turn++;
		}
	}
	
	private boolean processMove(int player, int move) {
		println("Player" + player + " plays at " + move);
		int moveSpace = ((int) (board/Math.pow(10, 8-move))) % 10;
		if(moveSpace==0) {
			board += Math.pow(10, 8-move) * player;
			return true;
		}
		println("That is an invalid move.");
		return false;
	}
	
	public static void printBoard(int board) {
		int[] boardToPrint = new int[9];
		for(int i=0;i<9;i++) {
			boardToPrint[8-i] = board % 10;
			board = board / 10;
		}
		String strToPrint = boardToPrint[0] +  " " + boardToPrint[1] +  " " + boardToPrint[2]
				+  "\n" + boardToPrint[3] +  " " + boardToPrint[4] +  " " + boardToPrint[5]
				+  "\n" + boardToPrint[6] +  " " + boardToPrint[7] +  " " + boardToPrint[8];
		println(strToPrint);
	}
	
}

