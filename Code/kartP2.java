package assignment_part2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class kartP2 extends JPanel
{
	private final static String IMAGE_NAME_KART2 = "b";
	protected ImageIcon secondKart[];
	private final int TOTAL_IMAGES = 16; // number of images
	private int currentImage = 0; // current image index
	private final int ANIMATION_DELAY = 200; // millisecond delay
	private int width; // image width
	private int height; // image height
    private Timer animationTimer; // Timer drives animation
    
    private int x,y;
    private int direction;
    private int speedf;
    private Image currentCar2;
    
    public kartP2()
    {
    	   secondKart = new ImageIcon[ TOTAL_IMAGES ];
    	   //load 30 images
    	    for ( int count = 0; count < secondKart.length; count++ )
    	    {
    		  secondKart[ count ] = new ImageIcon( getClass().getResource(
    				  "/images3/" + IMAGE_NAME_KART2 + (count + 1) + ".png" ) );
    	  
    	     //this example assumes all images have the same width and height
    	    width = secondKart[ 0].getIconWidth(); // get icon width
    	    height = secondKart[ 0].getIconHeight(); // get icon height
    	    }
    	    
    	    this.x = 0;
    		this.y = 0;
    		this.direction = 8;
    		this.speedf = 0;
    
    }

    public Dimension getMinimumSize()
    {
    	return getPreferredSize();
    }

    public Dimension getPreferredSize()
    {
    	return new Dimension(width,height);
    }

    public int getX() {
    	return x;
    }

    public void setX(int x) {
    	this.x = x;
    }

    public int getY() {
    	return y;
    }

    public void setY(int y) {
    	this.y = y;
    }

    public int getDirection() {
    	return direction;
    }

    public void setDirection(int dP2) {
    	if (dP2 <= -1) {
    		dP2 = 15;
    	} else if (dP2 > 15) {
    		dP2 = 0;
    	}

    	this.direction = dP2;
    }

    public int getSpeedf() {
    	return speedf;
    }

    public void setSpeedf(int startSpeed) {

    	if (startSpeed > 8) {
    		startSpeed = 8;
    	} else if (startSpeed < 0) {
    		startSpeed = 0;
    	}

    	this.speedf = startSpeed;
    }
    
    public ImageIcon[] getCar2() {
    	// return imagesIcon.getImage();
    	return secondKart;
    }

    public Image getCurrentCar2() {
    	return currentCar2;
    }
    
    public void P2CurrentCar(Image currentCar2)
    {
    	this.currentCar2 = currentCar2;
    }
    
    public void carMoveSpeedP2()
    {
    	switch (direction) {
    	case 0:
    		currentCar2 = secondKart[0].getImage();
    		x = x - 2 * speedf;
    		break;

    	case 1:
    		currentCar2 = secondKart[1].getImage();
    		x = x - 2 * speedf;
    		y = y - 1 * speedf;
    		break;

    	case 2:
    		currentCar2 = secondKart[2].getImage();
    		x = x - 2 * speedf;
    		y = y - 2 * speedf;
    		break;

    	case 3:
    		currentCar2 = secondKart[3].getImage();
    		x = x - 1 * speedf;
    		y = y - 2 * speedf;
    		break;

    	case 4:
    		currentCar2 = secondKart[4].getImage();
    		y = y - 2 * speedf;
    		break;

    	case 5:
    		currentCar2 = secondKart[5].getImage();
    		x = x + 1 * speedf;
    		y = y - 2 * speedf;
    		break;

    	case 6:
    		currentCar2 = secondKart[6].getImage();
    		x = x + 2 * speedf;
    		y = y - 2 * speedf;
    		break;

    	case 7:
    		currentCar2 = secondKart[7].getImage();
    		x = x + 2 * speedf;
    		y = y - 1 * speedf;
    		break;

    	case 8:
    		currentCar2 = secondKart[8].getImage();
    		x = x + 2 * speedf;
    		break;

    	case 9:
    		currentCar2 = secondKart[9].getImage();
    		x = x + 2 * speedf;
    		y = y + 1 * speedf;
    		break;

    	case 10:
    		currentCar2 = secondKart[10].getImage();
    		x = x + 2 * speedf;
    		y = y + 2 * speedf;
    		break;

    	case 11:
    		currentCar2 = secondKart[11].getImage();
    		x = x + 1 * speedf;
    		y = y + 2 * speedf;
    		break;

    	case 12:
    		currentCar2 = secondKart[12].getImage();
    		y = y + 2 * speedf;
    		break;

    	case 13:
    		currentCar2 = secondKart[13].getImage();
    		x = x - 1 * speedf;
    		y = y + 2 * speedf;
    		break;

    	case 14:
    		currentCar2 = secondKart[14].getImage();
    		x = x - 2 * speedf;
    		y = y + 2 * speedf;
    		break;

    	case 15:
    		currentCar2 = secondKart[15].getImage();
    		x = x - 2 * speedf;
    		y = y + 1 * speedf;
    		break;
    	}
    }
}
