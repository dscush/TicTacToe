package com.dancusher.ticTacToe;

public class QuickTestTicTacToe {

	public static void main(String[] args) {
		TicTacToeEngine engine = new TicTacToeEngine();
		Player player1 = new DynamicProgrammingPlayer();
		Player player2 = new RandomPlayer();
		int numGamesToPlay = 100;
		int player1Wins = 0;
		int player2Wins = 0;
		int draws = 0;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<(numGamesToPlay);i++) {
			if(((double)i/numGamesToPlay)*100 % 10 == 0) {
				System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
			}
			int winStatus = engine.playGame(player1, player2,true);
			if(winStatus==-1) {
				draws++;
			} else if(winStatus==1) {
				player1Wins++;
			} else if(winStatus==2) {
				player2Wins++;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.format("\nPlayer1 goes first VS Player2:\nPlayer1 wins: %d\nPlayer2 wins: %d\nDraws: %d\n", player1Wins, player2Wins, draws);
		System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		player1Wins = 0;
		player2Wins = 0;
		draws = 0;
		startTime = System.currentTimeMillis();
		for(int i=0;i<(numGamesToPlay);i++) {
			if(((double)i/numGamesToPlay)*100 % 10 == 0) {
				System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
			}
			int winStatus = engine.playGame(player2, player1,true);
			if(winStatus==-1) {
				draws++;
			} else if(winStatus==2) {
				player1Wins++;
			} else if(winStatus==1) {
				player2Wins++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.format("\nPlayer1 goes second VS Player2:\nPlayer1 wins: %d\nPlayer2 wins: %d\nDraws: %d\n", player1Wins, player2Wins, draws);
		System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		
	}

}
