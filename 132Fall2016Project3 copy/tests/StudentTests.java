package tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import model.BoardCell;
import model.ClearCellGameModel;
import model.GameModel;

public class StudentTests {

	@Test
	public void testGoodFaithAttempt() {
		StringBuffer resultBuffer = new StringBuffer();
		int rows=9, cols=12;
		GameModel model = new ClearCellGameModel(rows, cols, new Random(1L));
		resultBuffer.append("Initial board\n");
		BoardCell[][] board = model.getBoard();
		

		for (int row=0; row<board.length; row++) {
			for (int col=0; col<board[row].length; col++)
				resultBuffer.append(board[row][col].getName());
			resultBuffer.append("\n");
		}
		
		model.nextAnimationStep();
		resultBuffer.append("Board after animation step\n" + model);
		resultBuffer.append("MaxRows: " + model.getMaxRows());
		resultBuffer.append("\nMaxCols: " + model.getMaxCols() + "\n");
		
		assertTrue(TestingSupport.correctResults("pubGoodFaithAttempt.txt", resultBuffer.toString()));
	}

}
