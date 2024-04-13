package ballAnimation;

import java.awt.Color;

import javax.swing.JFrame;

public class BallFrame extends JFrame {

	BallFrame(){
		setSize(800,600);
		setTitle("Graphic Programming");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Animation panel=new Animation(780,560);
		panel.setBackground(Color.black);
		add(panel);
	}
	
	public static void main(String[] args) {

		new BallFrame().setVisible(true);
	}
}