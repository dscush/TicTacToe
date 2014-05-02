package com.dancusher.ticTacToe;

public class BruteSearchPlayer extends AbstractAI implements Player {

	public BruteSearchPlayer() {
		super();
	}
	
	public int makeMove(int board) {
		int bestMove = -1;
		float bestResult = -1;
		for(int i=0;i<9;i++) {
			if(isValidMove(board, i)) {
				int newBoard = board += Math.pow(10, 8-i) * playerNumber;
				float result = _makeMove(newBoard, ((playerNumber%2) + 1));
				if(result > bestResult) {
					bestResult = result;
					bestMove = i;
				}
			}
		}
		return bestMove;	
	}

	public void startNewGame(boolean isFirst) {
		// TODO : to implement	
	}
	
	private float _makeMove(int board, int player) {
		float bestResult = 1;
		int winStatus = TicTacToeEngine.checkForWin(board);
		if(winStatus==-1) { //draw
			bestResult = (float) 1;
		} else if(winStatus==playerNumber) { //win
			bestResult = 2;
		} else if(winStatus!=0) { //loss
			bestResult = (float) 0.5;
		} else { //game not over
			for(int i=0;i<9;i++) { //check each possible move
				if(isValidMove(board, i)) { //if move is valid...
					int playerMultiplier;
					if(player==playerNumber) {
						playerMultiplier = 10;
					} else {
						playerMultiplier = -2;
					}
					int newBoard = board += Math.pow(10, 8-i) * player; //make move on new board
					float result = _makeMove(newBoard, ((player%2) + 1)); //recurse on new board
					bestResult *= Math.pow(result,playerMultiplier);
//					if(result > bestResult) {
//						bestResult = result;
//					}
				}
			}
		}
		return bestResult;
	}
}

