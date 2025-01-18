/**
 * A panel that displays and animates geometric shapes.
 * Shapes are created by clicking on the panel and move around while checking for collisions.
 * 
 * Key features:
 * - Uses a thread-safe CopyOnWriteArrayList to store shapes
 * - Shapes are created via mouse clicks
 * - Each shape runs on its own thread
 * - Supports collision detection between shapes
 * 
 * Implementation notes:
 * - The panel has a black background and default size of 800x600
 * - Each shape is created at the mouse click coordinates
 * - Uses ShapeFactory to generate random shapes
 * - Shapes are continuously redrawn via paintComponent
 *
 * @author Vedant Neve
 * @version 1.0
 *
 * Fields:
 * @field shapes - Thread-safe list storing all active shapes
 * @field shapeFactory - Factory class for creating new shapes
 *
 * Methods:
 * @method addShape - Creates and starts a new shape thread at specified coordinates
 * @method paintComponent - Handles the rendering of all shapes
 * @method main - Entry point that sets up the JFrame and panel
 */

 
package collisionAnimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("serial")
public class AnimatedShapes extends JPanel {
    final List<Shape> shapes = new CopyOnWriteArrayList<>();  // Thread-safe list
    private final ShapeFactory shapeFactory = new ShapeFactory();

    public AnimatedShapes() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addShape(e.getX(), e.getY());
            }
        });
    }

    private void addShape(int x, int y) {
        Shape shape = shapeFactory.createRandomShape(x, y, this);
        shapes.add(shape);
        new Thread(shape).start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Shapes");
        AnimatedShapes panel = new AnimatedShapes();
        
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }
}