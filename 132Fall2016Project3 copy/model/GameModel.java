package model;


/**
 * This class represents the logic of a game where a
 * board is updated on each step of the game animation.
 * The board can also be updated by selecting a board cell.
 * 
 * @author Dept of Computer Science, UMCP
 */


public abstract class GameModel {
	protected BoardCell[][] board; //why is this protected?
	private int maxRows; //should these be protected?
	private int maxCols;


	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * @param maxRows
	 * @param maxCols
	 */
	public GameModel(int maxRows, int maxCols) { //setting up the constructor!
		board = new BoardCell[maxRows][maxCols];
		this.maxRows = maxRows;
		this.maxCols = maxCols;

		for (int x = 0; x < maxRows; x++) {
			for (int y = 0; y < maxCols; y++){
				board[x][y] = BoardCell.EMPTY;
			}
		}
	}


	public int getMaxRows() {
		return this.maxRows;
	}


	public int getMaxCols() {
		return this.maxCols;
	}


	public BoardCell[][] getBoard() {
		return this.board;
	}


	public void setBoardCell(int rowIndex, int colIndex, BoardCell boardCell) {
		board[rowIndex][colIndex] = boardCell;
	}


	public BoardCell getBoardCell(int rowIndex, int colIndex) {
		return board[rowIndex][colIndex];
	}

	/** Provides a string representation of the board 
	 * We have implemented this method for you.
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Board(Rows: " + board.length + ", Cols: " + board[0].length + ")\n");
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++)
				buffer.append(board[row][col].getName());
			buffer.append("\n");
		}
		return buffer.toString();
	}

	public abstract boolean isGameOver();

	public abstract int getScore();

	
	/**
	 * Advances the animation one step. 
	 */
	public abstract void nextAnimationStep();

	/**
	 * Adjust the board state according to the current board
	 * state and the selected cell.
	 * @param rowIndex 
	 * @param colIndex
	 */
	public abstract void processCell(int rowIndex, int colIndex);
}