package main;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	public void mouseClicked(MouseEvent e) {
		Point point = e.getPoint();
	}
	
}
