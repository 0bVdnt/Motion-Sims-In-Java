package animation;
import java.util.ArrayList;
import java.util.List;

public class Shape implements Runnable{
	static List<Shape> shapes = new ArrayList<>();
	ShapePanel panel;
    int x, y;           // Current position
    int dx = 2, dy = 2; // Movement delta
    int size = 50;      // Shape size
        
    /**
     * Constructor initializes shape with random starting position
     */
	public Shape(ShapePanel panel) {
		this.panel = panel;
		// Random starting position within panel bounds
		x = (int)(Math.random() * panel.getWidth() - size);
		y = (int)(Math.random() * panel.getHeight() - size);
		dx = (int)(Math.random() * 10);
		dy = (int)(Math.random() * 10);
		shapes.add(this);
	}
	/**
     * Main animation loop that runs in separate thread
     * Updates position and handles boundary collisions
     */
	@Override
	public void run() {
		while(true) {
			// Update position and repaint
			move();
			panel.repaint();	// Request redraw
			try {
				Thread.sleep(10);	// Control animation speed
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		// Check for wall collisions
		if(x + size >= panel.getWidth() || x <= 0)
			dx = -dx;	// Reverse horizontal direction
		if(y + size >= panel.getHeight() || y <= 0)
			dy = -dy;	// Reverse vertical direction
		
		x += dx;
		y += dy;
	}
	
	/**
     * Getters used by panel for drawing
     */
    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
}
