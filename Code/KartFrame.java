package assignment_part2;

import javax.swing.*;

public class KartFrame extends JFrame 
{
 
	KartFrame()
	{
		KartJPanel arguments = new KartJPanel();
		this.add(arguments);
		this.setTitle("Game Kart!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(850, 650);
		this.setVisible(true);
		
		this.setLocationRelativeTo(null);
	
	}
}
