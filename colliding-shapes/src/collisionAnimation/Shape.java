/**
* Represents a geometric shape that can move and collide with other shapes.
 * This class implements Runnable to allow each shape to move independently in its own thread. 
 */

/**
 * The Shape class manages the behavior and appearance of geometric shapes in an animation.
 * Each shape can be a circle, square, or triangle that moves within the bounds of a panel
 * and can collide with other shapes.
 * 
 * Fields:
 * @field x - The x-coordinate position of the shape
 * @field y - The y-coordinate position of the shape
 * @field size - The size of the shape (width/height)
 * @field dx - The horizontal velocity of the shape
 * @field dy - The vertical velocity of the shape
 * @field color - The randomly generated color of the shape
 * @field type - The type of shape (CIRCLE, SQUARE, or TRIANGLE)
 * @field panel - Reference to the parent panel containing all shapes
 * 
 * Methods:
 * @method run() - The main loop that handles the shape's movement and collision detection
 * @method move() - Updates the shape's position and handles boundary collisions
 * @method checkCollision() - Detects and handles collisions with other shapes
 * @method isColliding() - Determines if two shapes are intersecting
 * @method draw() - Renders the shape on the graphics context
 * @method drawTriangle() - Helper method to draw triangular shapes
 * 
 * The shape moves with random initial velocities and bounces off panel boundaries
 * and other shapes. Collision detection is implemented using a simple radius-based
 * approach, and shapes reverse direction upon collision.
 */
package collisionAnimation;

import java.awt.*;
import java.util.Random;

public class Shape implements Runnable {
    private int x, y, size;
    private int dx, dy;
    private Color color;
    private ShapeType type;
    private final AnimatedShapes panel; // Reference to the parent panel

    // Constructor now accepts a reference to the AnimatedShapes panel
    public Shape(int x, int y, int size, ShapeType type, AnimatedShapes panel) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.type = type;
        this.panel = panel; // Set the reference to the panel

        Random random = new Random();
        this.dx = random.nextInt(5) + 1;
        this.dy = random.nextInt(5) + 1;
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public void run() {
        while (true) {
            move();
            checkCollision();
            panel.repaint(); // Use the reference to repaint
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void move() {
        if (x + size >= panel.getWidth() || x <= 0) dx = -dx;
        if (y + size >= panel.getHeight() || y <= 0) dy = -dy;
        x += dx;
        y += dy;
    }

    private void checkCollision() {
        for (Shape other : panel.shapes) {
            if (other != this && isColliding(other)) {
                dx = -dx;
                dy = -dy;
                other.dx = -other.dx;
                other.dy = -other.dy;
            }
        }
    }

    private boolean isColliding(Shape other) {
        int distanceX = Math.abs(this.x - other.x);
        int distanceY = Math.abs(this.y - other.y);
        int radiusSum = (this.size + other.size) / 2;
        return distanceX < radiusSum && distanceY < radiusSum;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        switch (type) {
            case CIRCLE -> g.fillOval(x, y, size, size);
            case SQUARE -> g.fillRect(x, y, size, size);
            case TRIANGLE -> drawTriangle(g);
        }
    }

    private void drawTriangle(Graphics g) {
        int[] xPoints = {x + size / 2, x, x + size};
        int[] yPoints = {y, y + size, y + size};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
