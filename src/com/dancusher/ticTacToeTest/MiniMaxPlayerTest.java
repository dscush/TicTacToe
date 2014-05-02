package com.dancusher.ticTacToeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.dancusher.ticTacToe.MiniMaxPlayer;

public class MiniMaxPlayerTest extends MiniMaxPlayer{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testMakeMove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIsValidMoveSuccess() {
		boolean testPass = true;
		int board = 11111111;
		int topBoard = 0;
		int bottomBoard = 11111111;
		for(int i=0;i<9;i++) {
			System.out.println(board);
			testPass = testPass && isValidMove(board,i);
			topBoard += Math.pow(10, 8-i);
			bottomBoard -= Math.pow(10, 7-i);
			board = topBoard + bottomBoard;
		}
		assertTrue("All valid moves must be evaluated as valid.", testPass);
	}
	
	@Test
	public void test_makeMove() {
		assertEquals("Obvious win must return value of 1",(float)0.5, _makeMove(120021000,true),0);
	}

}
