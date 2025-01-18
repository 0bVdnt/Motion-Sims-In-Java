package animation;

import javax.swing.JFrame;

/**
 * Main class that creates the animation window and initializes the bouncing shapes
 */
public class BouncingShapes {
    public static void main(String[] args) {
        // Create the main application window
        JFrame frame = new JFrame("Bouncing Balls");
        
        // Create panel where shapes will be drawn
        ShapePanel panel = new ShapePanel();
        
        // Add panel to frame and configure window properties
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);        
        
        // Create 5 shapes, each running on its own thread
        for(int i = 0; i < 5; i++) {
            new Thread(new Shape(panel)).start();
        }
    }
}