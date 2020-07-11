package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Grid {

	public int numCols;
	public int numRows;
	private int width;
	private int height;
	private int squareSize;
	private int gridSize;
	private int spacing;
	private List<Square> grid;
	
	public Grid(int _numCols, int _numRows, int _squareSize, int _spacing) {
		numCols = _numCols;
		numRows = _numRows;
		gridSize = _numRows * _numCols;
		squareSize = _squareSize;
		spacing = _spacing;
		width = (squareSize + spacing) * numCols;
		height = (squareSize + spacing) * numRows;
		grid = new ArrayList<Square>();
		setUpGrid();
	}
	
	private void setUpGrid() {
		//fill grid with square objects
		int gridSize = numRows * numCols;
		for (int i=0; i<gridSize; i++) {
			Square square = createSquare(getRow(i), getCol(i));
			grid.add(square);
		}
	}
	
	private Square createSquare(int col, int row) {
		//create square for given row and coumn
		int x_min = (squareSize + spacing) * col + spacing;
		int y_min = (squareSize + spacing) * row + spacing;
		return new Square(x_min, y_min, squareSize);
	}
	
	private int getIndex(int col, int row) {
		//get grid index for row and column
		return row * numCols + col;
	}

	private int getRow(int index) {
		//get row for given grid index
		return index / numCols;
	}
	
	private int getCol(int index) {
		//get column for given grid index
		return index % numCols;
	}
	
	public Square getSquare(int col, int row) {
		//get square at given row and column
		return grid.get(getIndex(col, row));
	}
	
	public void setSquare(int col, int row, Square square) {
		//set square at given row and column
		grid.set(getIndex(col, row), square);
	}
	
	public void render(Graphics graphics) {
		//render grid
		for (int i=0; i<gridSize; i++) {
			grid.get(i).render(graphics);
		}
	}

}
