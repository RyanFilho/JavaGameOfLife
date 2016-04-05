package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;


public class MainWindow {
	public JFrame frame;
	private GridLayout layout;
	public MainWindow()
	{
		frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);		
		
		
//		frame.setResizable(false);
	}
}
