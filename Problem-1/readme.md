# Bouncing Shapes Animation

A simple Java animation project demonstrating multithreading and Swing GUI components by creating bouncing shapes that move independently.

## Preview
When running, the application shows 5 red balls bouncing around in a window, each operating on its own thread.

## Components

### BouncingShapes.java
- Main class that initializes the application window
- Creates the animation panel
- Spawns 5 independent shape threads

### Shape.java
- Represents a single bouncing shape
- Implements Runnable for threaded movement
- Handles collision detection with window boundaries
- Controls movement speed and direction

### ShapePanel.java
- Extends JPanel for drawing shapes
- Manages the collection of shapes
- Handles the rendering of shapes using Java Graphics

## Requirements
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Visual Studio Code recommended)

## Setup
1. Clone the repository
2. Open in your preferred Java IDE
3. Run `BouncingShapes.java`

## How to Run

1. Clone the repository
2. Open in any IDE of your convenience
3. Navigate to src/animation/BouncingShapes.java
4. Run the BouncingShapes.java file

Or via command line:
```bash
cd /src
javac animation/*.java
java animation.BouncingShapes
```

## Code Structure
    src/
      animation/
        ├── BouncingShapes.java
        ├── Shape.java
        └── ShapePanel.java

## Controls
- Close button to exit
- Window can be resized (shapes will adapt to new boundaries)

## Implementation Details
- Uses Java Swing for GUI
- Each shape runs on a separate thread for independent movement
- 20ms animation refresh rate
- Elastic collision with window boundaries

## Features
  - Multithreaded animation
  - Collision detection
  - Smooth movement
  - Independent shape behavior
