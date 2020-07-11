package main;

import java.awt.Point;

public class Handler {

	private Grid grid;
	
	public Handler(Grid grid) {
		this.grid = grid;
	}
	
	public void onMouseClicked(Point point) {
		for(int i=0; i<grid.numCols; i++) {
			for(int j=0; j<grid.numRows; j++) {
				Square square = grid.getSquare(i, j);
				if(square.intersect(point)) {
					square.toggle();
					break;
				}
			}
		}
	}
	
}
