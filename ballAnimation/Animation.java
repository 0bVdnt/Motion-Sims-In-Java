package ballAnimation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Animation extends JPanel {
	int x=0;
	int y=0;
	int ballWidth=50;
	int ballHeight=50;
	int max_x, max_y;
	int speedx=20;
	int speedy=20;

	Animation(int w, int h){
		this.max_x=w-ballWidth;
		this.max_y=h-ballHeight;
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);

		g.setColor(Color.red);
		g.fillOval(x, y, ballWidth, ballHeight);
		
		if(x>max_x || x<0)
			speedx=-speedx;
		if(y>max_y || y<0)
			speedy=-speedy;
		
		x=x+speedx;
		y=y+speedy;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}


}


