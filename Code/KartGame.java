package assignment_part2;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class KartGame 
{
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		new KartFrame();
		
        File soundMusic = new File("music.wav");
		
		AudioInputStream audioGame = AudioSystem.getAudioInputStream(soundMusic);
		Clip clip = AudioSystem.getClip();
		clip.open(audioGame);
		
		clip.start();
	
	}
	

}
