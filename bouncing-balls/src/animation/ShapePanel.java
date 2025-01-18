package animation;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * Panel class responsible for drawing all shapes
 */
public class ShapePanel extends JPanel{
	/**
     * Override paintComponent to draw all shapes
     * Called automatically by repaint()
     */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw each shape as a filled oval
		for(Shape shape : Shape.shapes) {
			g.setColor(Color.RED);
			g.fillOval(shape.x, shape.y, shape.size, shape.size);
		}
	}
}