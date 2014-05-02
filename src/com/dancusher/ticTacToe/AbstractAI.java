package com.dancusher.ticTacToe;

public abstract class AbstractAI implements Player {
	protected boolean isFirst;
	protected int playerNumber;
	
	@Override
	public int makeMove(int board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startNewGame(boolean isFirst) {
		this.isFirst = isFirst;
		if (isFirst) {
			playerNumber = 1;
		} else {
			playerNumber = 2;
		}
	}
	
	protected boolean isValidMove(int board, int move) {
		int moveSpace = ((int) (board/Math.pow(10, 8-move))) % 10;
		if(moveSpace==0) {
			return true;
		}
		return false;
	}

}
