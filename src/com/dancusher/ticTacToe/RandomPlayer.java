package com.dancusher.ticTacToe;

import java.util.Random;

public class RandomPlayer extends AbstractAI implements Player {
	
	public RandomPlayer(){
		super();
	}
	
	public void startNewGame(boolean isFirst) {
		this.isFirst = isFirst;
		if (isFirst) {
			playerNumber = 1;
		} else {
			playerNumber = 2;
		}
	}
	
	public int makeMove(int board) {
		Random rnd = new Random();
		int move;
		do {
			move = rnd.nextInt(9);
		} while(!isValidMove(board,playerNumber,move));
		return move;	
	}
	
	protected boolean isValidMove(int testBoard, int player, int move) {
		testBoard += Math.pow(10, 8-move) * player;
		for (int i=0;i<9;i++) {
			if (TicTacToeEngine.getSpace(testBoard, i) < 0 || TicTacToeEngine.getSpace(testBoard, i) > 2) {
				return false;
			}
		}
		return true;
	}
	
}

