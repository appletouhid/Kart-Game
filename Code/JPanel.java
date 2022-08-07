package part1;


import javax.swing.JFrame;


public class JPanel {

	public static void main( String args[] )
	 {
     part1_animatingKarts animation = new part1_animatingKarts();
     
     
	
	 JFrame window = new JFrame( "Animator test" ); // set up window
	 window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 window.add( animation ); // add panel to frame
	
	window.pack();
	window.setVisible( true ); // display window
	
	 animation.startAnimation(); // begin animation
	} // end main
	 } // end class LogoAnimator