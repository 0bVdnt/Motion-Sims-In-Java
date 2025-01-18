
/**
 * Factory class for creating random shapes.
 * This class implements the Factory pattern to generate Shape objects with random properties.
 */
 
 /**
 * Creates a new Shape instance with random properties at specified coordinates.
 * The shape will have:
 * - Random size between 20 and 50 pixels
 * - Random shape type selected from available ShapeType enum values
 *
 * @param x      The x-coordinate for the new shape
 * @param y      The y-coordinate for the new shape
 * @param panel  The AnimatedShapes panel where the shape will be drawn
 * @return       A new Shape instance with random properties
 */

package collisionAnimation;

import java.util.Random;

public class ShapeFactory {

    private final Random random = new Random();

    public Shape createRandomShape(int x, int y, AnimatedShapes panel) {
        int size = random.nextInt(30) + 20;
        ShapeType type = ShapeType.values()[random.nextInt(ShapeType.values().length)];
        return new Shape(x, y, size, type, panel); // Pass panel reference to Shape constructor
    }
}
