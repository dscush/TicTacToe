package com.dancusher.ticTacToe;

public class MiniMaxPlayer extends AbstractAI {

	public MiniMaxPlayer() {
		super();
	}
	
	public int makeMove(int board) {
		if(board==0) {
			return 0;
		}
		int bestMove = -1;
		float bestResult = -1;
		for(int i=0;i<9;i++) {
			if(isValidMove(board, i)) {
				int newBoard = (int) (board + Math.pow(10, 8-i) * playerNumber);
				float result = _makeMove(newBoard, false);
				if(result > bestResult) {
					bestResult = result;
					bestMove = i;
				}
			}
		}
		return bestMove;	
	}
	
	protected float _makeMove(int board, boolean maxPlayer) {
		float bestResult;
		int winStatus = TicTacToeEngine.checkForWin(board);
		if(winStatus==-1) { //draw
//System.out.println("Draw!");
			bestResult = (float) 0.5;
		} else if(winStatus==playerNumber) { //win
//System.out.println("Max Wins!");
			bestResult = 1;
		} else if(winStatus!=0) { //loss
//System.out.println("Max Loses!");
			bestResult = 0;
		} else { //game not over
			if(maxPlayer) {
				bestResult = -1;
				for(int move=0;move<9;move++) { //check each possible move
					if(isValidMove(board, move)) { //if move is valid...
//System.out.println("Max plays " + move);
						int newBoard = (int) (board + Math.pow(10, 8-move) * playerNumber); //make move on new board
//TicTacToeEngine.printBoard(newBoard);
						float result = _makeMove(newBoard, !maxPlayer); //recurse on new board
						if(result > bestResult) {
							bestResult = result;
						}
					}
				}
			} else {
				bestResult = 2;
				for(int move=0;move<9;move++) { //check each possible move
					if(isValidMove(board, move)) { //if move is valid...
//System.out.println("Min plays " + move);
						int newBoard = (int) (board + Math.pow(10, 8-move) * ((playerNumber%2) + 1)); //make move on new board
//TicTacToeEngine.printBoard(newBoard);
						float result = _makeMove(newBoard, !maxPlayer); //recurse on new board
						if(result < bestResult) {
							bestResult = result;
						}
					}
				}
			}
		}
		return bestResult;
	}
}

