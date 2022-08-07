package assignment_part2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;





public class KartJPanel extends JPanel implements ActionListener, KeyListener{
	
	private Timer timeRace = new Timer(200, this);
	
	private part1_animatingKarts car = new part1_animatingKarts(); // car 1 starting location
	private kartP2 car2 = new kartP2(); // car 2 starting location

    
 
	
    
    public KartJPanel() 
    {
    	car.setX(375);
    	car.setY(500);
    	
    	car2.setX(375);
    	car2.setY(550);
		timeRace.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		     
    }
    



	
	public void paintComponent(Graphics g1)
	{
	  super.paintComponent(g1);
	  
	  Color c1 = Color.green; 
	  g1.setColor( c1 ); 
	  g1.fillRect( 150, 200, 550, 300 ); // grass
	  
	  Color c2 = Color.black;
	  g1.setColor( c2 ); 
	  g1.drawRect(50, 100, 750, 500);  // outer edge 
	  g1.drawRect(150, 200, 550, 300); // inner edge
	  
	  Color c3 = Color.yellow; 
	  g1.setColor( c3 ); 
	  g1.drawRect( 100, 150, 650, 400 ); // mid-lane marker
	  
	  Color c4 = Color.white; 
	  g1.setColor( c4 ); 
	  g1.drawLine( 425, 500, 425, 600 ); // start line  
	  
	  Color c5 = Color.red;
	  g1.setColor(c5);
	  g1.drawLine (375, 500, 375, 600); // finish line
	  

	  g1.drawImage(car.getCurrentCar(), car.getX(), car.getY(), null);
	  g1.drawImage(car2.getCurrentCar2(), car2.getX(), car2.getY(), null);
	}
	
	
	 public void soundCrash() 
	 {
		 String crashPath = new File("").getAbsolutePath()+"\\crash.wav";
		 
		 File crashSoundPlay = new File(crashPath);
		 
		 try
		 {
			 AudioInputStream AIS = AudioSystem.getAudioInputStream(crashSoundPlay);
			 Clip crashClip = AudioSystem.getClip();
			 crashClip.open(AIS);
			 crashClip.start();
		 }
		 
		 catch (Exception crashError)
		 {
			 System.out.println("No Sound!");
		 }
	 }
	 
	 public void soundGrassFail()
	 {
         String crashPath = new File("").getAbsolutePath()+"\\grassFail.wav";
		 
		 File crashSoundPlay = new File(crashPath);
		 
		 try
		 {
			 AudioInputStream AIS = AudioSystem.getAudioInputStream(crashSoundPlay);
			 Clip crashClip = AudioSystem.getClip();
			 crashClip.open(AIS);
			 crashClip.start();
		 }
		 
		 catch (Exception crashError)
		 {
			 System.out.println("No Sound!");
		 }
	 }
	 
	 public void winSound()
	 {
         String winSoundEffect = new File("").getAbsolutePath()+"\\win.wav";
		 
		 File crashSoundPlay = new File(winSoundEffect);
		 
		 try
		 {
			 AudioInputStream winAIS = AudioSystem.getAudioInputStream(crashSoundPlay);
			 Clip winClip = AudioSystem.getClip();
			 winClip.open(winAIS);
			 winClip.start();
		 }
		 
		 catch (Exception winSoundError)
		 {
			 System.out.println("No Sound!");
		 }
	 }
	 
	 



	  
	 public void checkWin() 
	 {
		 

         // 2 karts collided
         if (Math.abs((car.getX() + 25) - (car2.getX() + 25 )) < 35 && Math.abs((car.getY() + 25) - (car2.getY() +25 )) < 35)
		 {
        	 soundCrash();
			 JOptionPane.showMessageDialog(null, "Both Karts crashed.");
			 System.exit(0);
			 timeRace.stop();
			 

		 }
		
         //outer edge collission check, x-axis
         if ((car.getX() >= 760 || car2.getX() >= 760) || (car.getX() <= 42.5 || car2.getX() <= 42.5))
			 
		 {
        	 soundCrash();
			 JOptionPane.showMessageDialog(null, "Serious? Player 1 or Player 2? Why did you try to leave the track?");
			 System.exit(0);
			 timeRace.stop();

	 		
		 }
		 
		 //outer edge collission check, y-axis
		 if ((car.getY() <= 100 || car2.getY() <= 100) || (car.getY() >= 560 || car2.getY() >= 560))
			 
		 {
			 soundCrash();
			 JOptionPane.showMessageDialog(null, "Serious? Player 1 or Player 2? Why did you try to leave the track?");
			 System.exit(0);
			 timeRace.stop();
	

		 }
		 
		 // grass collission check
		 if ((car.getX() >= 110 && car.getX() <= 685) && ((car.getY() >= 160 && car.getY() <= 485)) || 
				 (car2.getX() >= 110 && car2.getX() <= 685) && ((car2.getY() >= 160 && car2.getY() <= 485)))
		 {
			 soundGrassFail();
			 JOptionPane.showMessageDialog(null, "Dont go into the grass!");
			 System.exit(0);
			 timeRace.stop();

		 }
		 
		 // cross the finish line check
		 if ((car.getX() >= 355 && car.getX() <= 370) && ((car.getY() >= 445 && car.getY() <= 700)))	 
         {
        	 JOptionPane.showMessageDialog(null, "Player 1 wins!");
        	 System.exit(0);
        	 timeRace.stop();
         }
        	 
        	 else if ((car2.getX() >= 355 && car2.getX() <= 370) && ((car2.getY() >= 445 && car2.getY() <= 700)))
        	 {
        		 JOptionPane.showMessageDialog(null, "Player 2 wins!");
            	 System.exit(0);
            	 timeRace.stop();
        	 }
         }
		 
		
	 
	


	public void actionPerformed(ActionEvent ae) {

		try {
			
			car.carMoveSpeedP1();
			car2.carMoveSpeedP2();
			checkWin();
			repaint();
			
		} 
		
		catch (UnsupportedOperationException ex) {
			throw new UnsupportedOperationException("Not supported yet."); 
		}		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		try 
		{

		} 
		catch (UnsupportedOperationException ex) {
			throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																			// choose Tools | Templates.
		}
	}

	
	

	@Override
	public void keyReleased(KeyEvent ke) {

		try {

		} catch (UnsupportedOperationException ex) {
			throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																			// choose Tools | Templates.
		}
	}




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

			try {
				int c = e.getKeyCode();

				
					switch (c) {
					case KeyEvent.VK_A:
						car.setDirection(car.getDirection() - 1);
						break;

					case KeyEvent.VK_D:
						car.setDirection(car.getDirection() + 1);
						break;

					case KeyEvent.VK_W:
						car.setSpeedf(car.getSpeedf() + 1);
						break;

					case KeyEvent.VK_S:
						car.setSpeedf(car.getSpeedf() - 1);
						break;

				
					case KeyEvent.VK_LEFT:
						car2.setDirection(car2.getDirection() - 1);
						break;

					case KeyEvent.VK_RIGHT:
						car2.setDirection(car2.getDirection() + 1);
						break;

					case KeyEvent.VK_UP:
						car2.setSpeedf(car2.getSpeedf() + 1);
						break;

					case KeyEvent.VK_DOWN:
						car2.setSpeedf(car2.getSpeedf() - 1);
						break;

					default:
						break;
					
				}

			} catch (UnsupportedOperationException ex) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}

		}
	
	private class TimerHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent actionEvent)
		{
			repaint();
		}
	}
	}





	
