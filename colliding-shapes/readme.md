# Colliding Shapes

This project is a Java application that animates geometric shapes on a panel. The shapes move around, bounce off the edges of the panel, and collide with each other. The application uses Java Swing for the graphical user interface and multithreading to animate the shapes.

## Project Structure
    colliding-shapes/
    ├── src/
    │   ├── collisionAnimation/
    │   │   ├── AnimatedShapes.java
    │   │   ├── Shape.java
    │   │   ├── ShapeFactory.java
    │   │   └── ShapeType.java
    │   ├── module-info.java
    │   └── utils/
    │       └── RandomUtils.java
    └── README.md

    
## Code Explanation

### `AnimatedShapes.java`

This class represents a panel that displays and animates geometric shapes. Key features include:
- Uses a thread-safe `CopyOnWriteArrayList` to store shapes.
- Shapes are created via mouse clicks.
- Each shape runs on its own thread.
- Supports collision detection between shapes.

### `Shape.java`

This class represents a geometric shape that can move and collide with other shapes. It implements `Runnable` to allow each shape to move independently in its own thread. Key methods include:
- `run()`: The main loop that handles the shape's movement and collision detection.
- `move()`: Updates the shape's position and handles boundary collisions.
- `checkCollision()`: Detects and handles collisions with other shapes.
- `isColliding()`: Determines if two shapes are intersecting.
- `draw()`: Renders the shape on the graphics context.
- `drawTriangle()`: Helper method to draw triangular shapes.

### `ShapeFactory.java`

This class is a factory for creating random shapes. It implements the Factory pattern to generate `Shape` objects with random properties.

### `ShapeType.java`

This enum represents the different types of shapes: `CIRCLE`, `SQUARE`, and `TRIANGLE`.

### `RandomUtils.java`

This utility class provides a method to generate random integers.

### `module-info.java`

This module descriptor specifies that the module requires `java.desktop`.

## How to Use

Method 1. Using Commandline:
   ```sh
   git clone https://github.com/0bVdnt/simple-java-animations.git
   cd simple-java-animations\colliding-shapes\src
   javac collisionAnimation/*.java
   java collisionAnimation.AnimatedShapes.java
   ```
Method 2. Using IDEs:

1. Clone the repository:
    ```sh
    git clone https://github.com/0bVdnt/simple-java-animations.git
    cd colliding-shapes
    ```
2. Open the project in your preferred IDE (e.g., Eclipse, IntelliJ IDEA).
      
3. Run the AnimatedShapes class:
          - In Eclipse: Right-click on AnimatedShapes.java and select  `Run As > Java Application `.
          - In IntelliJ IDEA: Right-click on AnimatedShapes.java and select Run `AnimatedShapes.main()`.
        
4. Click on the panel to create and animate shapes.

## Features
  1. Graphical User Interface (GUI): 
      - Uses Java Swing to create a graphical panel where shapes are displayed and animated.
  2. Shape Animation: 
      - Shapes move with random initial velocities.
      - Shapes bounce off the edges of the panel.
  4. Collision Detection:
      - Implements a radius-based approach to detect collisions between shapes.
      - Shapes reverse direction upon collision with other shapes.
  5. Multithreading:
      - Each shape runs on its own thread, allowing for independent movement and collision detection.
  5.Shape Creation:
      - Shapes can be created by clicking on the panel.
      - Supports multiple types of shapes (e.g., circles, squares, triangles).
  6. Random Shape Properties:
      - Shapes are created with random sizes, colors, and initial velocities.
  7. Factory Pattern:
      - Uses the Factory design pattern to create shapes with random properties.
  8. Thread-Safe Collection:
      - Uses CopyOnWriteArrayList to store shapes, ensuring thread safety during concurrent modifications.
