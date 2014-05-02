package com.dancusher.ticTacToe;

public class ConsoleTicTacToe {

	public static void main(String[] args) {
		TicTacToeEngine engine = new TicTacToeEngine();
		Player miniMax = new MiniMaxPlayer();
		Player random = new RandomPlayer();
		Player alphaBeta = new AlphaBetaPlayer();
		Player alphaBeta2 = new AlphaBetaPlayer();
		Player dynamicProgramming = new DynamicProgrammingPlayer();
		boolean miniMaxVsRandom = false;
		boolean randomVsMiniMax = false;
		boolean alphaBetaVsRandom = true;
		boolean randomVsAlphaBeta = true;
		boolean alphaBetaVsAlphaBeta = false;
		boolean dynamicProgrammingVsRandom = true;
		boolean randomVsDynamicProgramming = true;
		
		int numGamesToPlay = 1000;
		int miniMaxWins = 0;
		int randomWins = 0;
		int alphaBetaWins = 0;
		int alphaBeta1Wins = 0;
		int alphaBeta2Wins = 0;
		int dynamicProgrammingWins = 0;
		int draws = 0;
		long startTime;
		long endTime;
		if(miniMaxVsRandom) {
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(miniMax, random,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==1) {
					miniMaxWins++;
				} else if(winStatus==2) {
					randomWins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nMiniMax goes first VS Random:\nMiniMax wins: %d\nRandom wins: %d\nDraws: %d\n", miniMaxWins, randomWins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
		
		if(randomVsMiniMax) {
			miniMaxWins = 0;
			randomWins = 0;
			draws = 0;
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(random, miniMax,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==2) {
					miniMaxWins++;
				} else if(winStatus==1) {
					randomWins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nMiniMax goes second VS Random:\nMiniMax wins: %d\nRandom wins: %d\nDraws: %d\n", miniMaxWins, randomWins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
		
		if(alphaBetaVsRandom) {
			alphaBetaWins = 0;
			randomWins = 0;
			draws = 0;
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(alphaBeta, random,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==1) {
					alphaBetaWins++;
				} else if(winStatus==2) {
					randomWins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nAlphaBeta goes first VS Random:\nAlphaBeta wins: %d\nRandom wins: %d\nDraws: %d\n", alphaBetaWins, randomWins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
		
		if(randomVsAlphaBeta) {
			alphaBetaWins = 0;
			randomWins = 0;
			draws = 0;
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(random, alphaBeta,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==2) {
					alphaBetaWins++;
				} else if(winStatus==1) {
					randomWins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nAlphaBeta goes second VS Random:\nAlphaBeta wins: %d\nRandom wins: %d\nDraws: %d\n", alphaBetaWins, randomWins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
		
		if(alphaBetaVsAlphaBeta) {
			alphaBeta1Wins = 0;
			alphaBeta2Wins = 0;
			draws = 0;
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(alphaBeta, alphaBeta2,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==1) {
					alphaBeta1Wins++;
				} else if(winStatus==2) {
					alphaBeta2Wins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nAlphaBeta VS AlphaBeta:\nAlphaBeta1 wins: %d\nAlphaBeta2 wins: %d\nDraws: %d\n", alphaBeta1Wins, alphaBeta2Wins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
		
		if(dynamicProgrammingVsRandom) {
			dynamicProgrammingWins = 0;
			randomWins = 0;
			draws = 0;
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(dynamicProgramming, random,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==1) {
					dynamicProgrammingWins++;
				} else if(winStatus==2) {
					randomWins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nDynamicProgramming goes first VS Random:\nDynamicProgramming wins: %d\nRandom wins: %d\nDraws: %d\n", dynamicProgrammingWins, randomWins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
		
		if(randomVsDynamicProgramming) {
			dynamicProgrammingWins = 0;
			randomWins = 0;
			draws = 0;
			startTime = System.currentTimeMillis();
			for(int i=0;i<(numGamesToPlay);i++) {
				if(((double)i/numGamesToPlay)*100 % 10 == 0) {
					System.out.print(((double)i/numGamesToPlay)*100 + "% ... ");
				}
				int winStatus = engine.playGame(random, dynamicProgramming,true);
				if(winStatus==-1) {
					draws++;
				} else if(winStatus==2) {
					dynamicProgrammingWins++;
				} else if(winStatus==1) {
					randomWins++;
				}
			}
			endTime = System.currentTimeMillis();
			System.out.format("\nDynamicProgramming goes second VS Random:\nDynamicProgramming wins: %d\nRandom wins: %d\nDraws: %d\n", dynamicProgrammingWins, randomWins, draws);
			System.out.println("Total runtime: " + (endTime - startTime) + '\n');
		}
	}
}
