package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Square {
	
	private int size;
	private int x_min;
	private int y_min;
	private boolean on = false;

	public Square(int _x_min, int _y_min, int _size) {
		x_min = _x_min;
		y_min = _y_min;
		size = _size;
	}
	
	public boolean intersect(Point point) {
		// check if point intersects square
		return (
			point.getX() > x_min &&
			point.getX() < x_min + size &&
			point.getY() > y_min &&
			point.getY() < y_min + size
		);
	}
	
	public void toggle() {
		on = !on;
	}
	
	public void render(Graphics graphics) {
		if (on) {
			graphics.setColor(Color.black);
		}
		else {
			graphics.setColor(Color.white);
		}
		graphics.fillRect(x_min, y_min, size, size);
		graphics.setColor(Color.black);
		graphics.drawRect(x_min, y_min, size, size);
	}
}
