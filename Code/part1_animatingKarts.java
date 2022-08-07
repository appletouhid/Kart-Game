import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class part1_animatingKarts extends JPanel 
{

	private final static String IMAGE_NAME = "a";
	private final static String IMAGE_NAME_KART2 = "b";
	protected ImageIcon images[]; // array of images
	protected ImageIcon images21[];
	private final int TOTAL_IMAGES = 16; // number of images
	private int currentImage = 0; // current image index
	private final int ANIMATION_DELAY = 200; // millisecond delay
	private int width; // image width
	private int height; // image height
    private Timer animationTimer; // Timer drives animation

// constructor initializes LogoAnimatorJPanel by loading images
public part1_animatingKarts()
{
   images = new ImageIcon[ TOTAL_IMAGES ];
   //load 30 images
    for ( int count = 0; count < images.length; count++ )
	  images[ count ] = new ImageIcon( getClass().getResource(
			  "/images/" + IMAGE_NAME + (count + 1) + ".png" ) );
  
     //this example assumes all images have the same width and height
    width = images[ 0].getIconWidth(); // get icon width
    height = images[ 0 ].getIconHeight(); // get icon height
   
    
    images21 = new ImageIcon[ TOTAL_IMAGES ];
    //load 30 images
     for ( int count = 0; count < images21.length; count++ )
 	  images21[ count ] = new ImageIcon( getClass().getResource(
 			  "/images3/" + IMAGE_NAME_KART2 + (count + 1) + ".png" ) );
   
      //this example assumes all images have the same width and height
     width = images21[ 0].getIconWidth(); // get icon width
     height = images21[ 0].getIconHeight(); // get icon height
} 

public void paintComponent( Graphics g )
{
super.paintComponent( g ); // call superclass paintComponent
images[ currentImage ].paintIcon( this, g, 0, 0 );
images21[currentImage].paintIcon(this, g, 50, 0);

if (animationTimer.isRunning())
currentImage = (currentImage + 1) % TOTAL_IMAGES;
}

public void startAnimation()
{
	if (animationTimer == null)
	{
		currentImage = 0;
		
		animationTimer =
				new Timer(ANIMATION_DELAY, new TimerHandler());
		
		animationTimer.start();
	}
	
	else
	{
		if (!animationTimer.isRunning())
			animationTimer.restart();
	}
}

public void stopAnimation()
{
	animationTimer.stop();
}

public Dimension getMinimumSize()
{
	return getPreferredSize();
}

public Dimension getPreferredSize()
{
	return new Dimension(width,height);
}

private class TimerHandler implements ActionListener
{
	public void actionPerformed(ActionEvent actionEvent)
	{
		repaint();
	}
}
}