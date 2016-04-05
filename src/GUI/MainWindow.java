package GUI;

import javax.swing.JFrame;

public class MainWindow {
	public JFrame frame;
	public MainWindow()
	{
		frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);		
//		frame.setResizable(false);
	}
}
