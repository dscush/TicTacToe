package com.dancusher.ticTacToe;

public class AlphaBetaPlayer extends AbstractAI {

	public AlphaBetaPlayer() {
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
				float result = _makeMove(newBoard, -2, 2, false);
				if(result > bestResult) {
					bestResult = result;
					bestMove = i;
				}
			}
		}
		return bestMove;	
	}
	
	protected int _makeMove(int board, int alpha, int beta, boolean maxPlayer) {
		int winStatus = TicTacToeEngine.checkForWin(board);
		if(winStatus==-1) { //draw
			return 0;
		} else if(winStatus==playerNumber) { //win
			return 1;
		} else if(winStatus!=0) { //loss
			return -1;
		} else { //game not over
			if(maxPlayer) {
				for(int move=0;move<9;move++) { //check each possible move
					if(isValidMove(board, move)) { //if move is valid...
						int newBoard = (int) (board + Math.pow(10, 8-move) * playerNumber); //make move on new board
						int result = _makeMove(newBoard, alpha, beta, !maxPlayer); //recurse on new board
						if(result > alpha) {
							alpha = result;
						}
						if(beta < alpha) {
							break;
						}
					}
				}
				return alpha;
			} else {
				for(int move=0;move<9;move++) { //check each possible move
					if(isValidMove(board, move)) { //if move is valid...
						int newBoard = (int) (board + Math.pow(10, 8-move) * ((playerNumber%2) + 1)); //make move on new board
						int result = _makeMove(newBoard, alpha, beta, !maxPlayer); //recurse on new board
						if(result < beta) {
							beta = result;
						}
						if(beta < alpha) {
							break;
						}
					}
				}
				return beta;
			}
		}
	}
}

