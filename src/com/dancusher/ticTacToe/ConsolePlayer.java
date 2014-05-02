package com.dancusher.ticTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePlayer implements Player {
	private boolean isFirst;
	private int playerNumber;
	private BufferedReader reader;

	public ConsolePlayer() {
		super();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public int makeMove(int board) {
		TicTacToeEngine.printBoard(board);
		System.out.println("Ok Player " + playerNumber + ", choose a move: ");
		int move = -1;
		boolean validInput = false;
		while(!validInput) {
			try {
				String input = reader.readLine();
				move = Integer.parseInt(input);
				if (move < 1 || move > 9) {
					System.out.println("Invalid input.");
				} else {
					validInput = true;
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid input exception.");
			}
/*			try {
				move = Character.getNumericValue(reader.read());
				System.out.println(move);
				System.out.println(move < 0);
				System.out.println(move > 8);
				if (move < 0 || move > 8) {
					System.out.println("Invalid input.");
				} else {
					validInput = true;
				}
			} catch (IOException ioe) {
				System.out.println("Invalid input exception");
				
			}
*/			
		}
		return move-1;	
	}

	@Override
	public void startNewGame(boolean isFirst) {
		// TODO Auto-generated method stub
		
	}
	
}

