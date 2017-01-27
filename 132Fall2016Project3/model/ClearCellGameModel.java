package model;

import java.util.Random;

/**
 * This class extends GameModel and implements the logic of the clear cell game. 
 * We define an empty cell as BoardCell.EMPTY. An empty row is defined as one where 
 * every cell corresponds to BoardCell.EMPTY.
 * 
 * @author Dept of Computer Science, UMCP
 */


//comment everything so your understand the logic


public class ClearCellGameModel extends GameModel {

	private int score;
	private Random random;


	/* Feel free to add any instance variables you may need */

	/**
	 * Defines a board with empty cells.  It relies on the
	 * super class constructor to define the board.
	 * @param maxRows
	 * @param maxCols
	 * @param random
	 */
	public ClearCellGameModel(int maxRows, int maxCols, Random random) {
		super(maxRows, maxCols); //calls the super class method for maximum rows and cols
		this.random = random;
	}


	/**
	 * The game is over when the last board row (row with index board.length -1)
	 * is different from empty row.
	 */
	public boolean isGameOver() {
		return !(isRowEmpty(board.length - 1));

		//return isEmpty(grid[grid.length - 1]);
	}


	public int getScore() {
		return score; //gets score instance variable
	}


	/**
	 * This method will attempt to insert a row of random BoardCell objects
	 * if the last board row (row with index board.length -1) corresponds to
	 * the empty row;  Otherwise no operation will take place.
	 */
	public void nextAnimationStep() {
		if (!(this.isGameOver())) {

			for (int row = getMaxRows() - 1; row > 0; row--) {
				board[row] = board[row - 1];
			}

			board[0] = new BoardCell[getMaxCols()];

			for(int col = 0; col < getMaxCols(); col++){
				setBoardCell(0, col, BoardCell.getNonEmptyRandomBoardCell(random));
			}
		}
	}


	/**
	 * This method will turn to BoardCell.EMPTY any cells immediately surrounding the
	 * cell at position [rowIndex][colIndex] if and only if those surrounding 
	 * cells have the same color as the selected cell.  The selected cell will
	 * also be turned into a BoardCell.EMPTY.  If after processing the surrounding
	 * cells any rows in the board are empty then those rows will collapse, moving non-empty
	 * rows upward. If [rowIndex][colIndex] corresponds to an empty cell no 
	 * action will take place. 
	 * @throws IllegalArgumentException with message "Invalid row index" for invalid row
	 * or "Invalid column index" for invalid column.  We check for row validity first.
	 */
	public void processCell(int rowIndex, int colIndex) { //check out of bounds <0


		if(rowIndex < 0 || rowIndex >= getMaxRows())throw new IllegalArgumentException("Invalid row index");
		if(colIndex < 0 || colIndex >= getMaxCols())throw new IllegalArgumentException("Invalid column index");

		BoardCell color = board[rowIndex][colIndex]; //the actual square in question like (2,3) on the board


		if (color == BoardCell.EMPTY) return; //if you get an empty coordinate do nothing

		for (int y = rowIndex - 1; y <= rowIndex + 1; y++) { //goes by col then each row
			for (int x = colIndex - 1; x <= colIndex + 1; x++) {
				//if (y == colIndex && x == rowIndex) continue;

				if (inBounds(y,x) && color == board[y][x]) { //checks color and checks if in bounds
					this.setBoardCell(y, x, BoardCell.EMPTY); //if so set that associate square to EMPTY
					score++;
				}
			}
		}



		BoardCell[][] tempBoard = new BoardCell[getMaxRows()][getMaxCols()]; //board shallow copy


		//creates a tempBoard shallow copy of the original board and sets them all the EMPTY
		for (int row = 0; row < getMaxRows(); row++) {
			for (int col = 0; col < getMaxCols(); col++) {
				tempBoard[row][col] = BoardCell.EMPTY;
			}	
		}


		//checks if it is empty at that exact spot, if it is increment
		int j = 0; 
		for (int i = 0; i < getMaxRows(); i++) { //gets the number of non-empty rows and counts them
			if (!isRowEmpty(i)) { //checks empty or not
				tempBoard[j++] = board[i]; //so it adds all the non-empty rows to the tempBoad
			}
		}
		board = tempBoard; //after iteration is complete set the original board to become tempbord

	}


	private boolean inBounds(int x, int y) {
		return x >= 0 && x < getMaxRows() && y >= 0 && y < getMaxCols();
	}


	// returns true if the entire row is empty
	// if wanted to check the  last row you just pass it the last row
	private boolean isRowEmpty(int row) { //helper method
		for (int col = 0; col < this.getMaxCols(); col++) {
			if (board[row][col] != BoardCell.EMPTY) {
				return false;
			}
		}
		return true;
	}


}