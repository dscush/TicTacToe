package com.dancusher.ticTacToe;

import java.util.HashMap;

public class DynamicProgrammingPlayer extends AlphaBetaPlayer {
	HashMap<Integer,Integer> knownMoves = new HashMap<Integer,Integer>();
	
	public DynamicProgrammingPlayer() {
		super();
	}
	
	public int makeMove(int board) {
		int move;
		if(knownMoves.containsKey(board)) {
			return knownMoves.get(board);
		} else {
			move = super.makeMove(board);
			knownMoves.put(board, move);
		}
		return move;
	}
	
}
