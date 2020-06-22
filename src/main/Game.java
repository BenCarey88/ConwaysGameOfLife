package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -6908316181518512737L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		Handler handler = new Handler();
		this.addMouseListener(new MouseInput());
		new Window(WIDTH, HEIGHT, "Conway's Game of Life", this);
	}
	
	synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double tps = 60.0; //ticks per second
		double nspt = 1000000000 / tps; //nanosecs per tick
		double delta = 0; //diff in time in units of ticks
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / nspt;
			lastTime = now;
			while(delta >= 1){
				//delta >=1 means 1 tick has passed
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				//every 1s print number of frames to give fps
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.green);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
}
