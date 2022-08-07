package assignment_part2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serverConnector implements Runnable{
      
	boolean running = true;
	private int allPlayer;
	int movement;
	int speedOfPlayer;
	
	server server;
	Socket socket;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	

	public serverConnector (Socket socket, server server, int playerID) {

		this.socket = socket;
		this.server = server;
		this.allPlayer = playerID;

	}

	public void ClientReceive(int noPlayer, int playerMovement, int playerSpeed) {
		try {

			dataOutputStream.writeInt(noPlayer);
			dataOutputStream.writeInt(playerMovement);
			dataOutputStream.writeInt(playerSpeed);

			dataOutputStream.flush();
		} 
		
		catch (IOException e) {
			Logger.getLogger(serverConnector.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void ClientReceives (int allOfPlayer, int movementOfPlayer, int speedOfPlayer) {
		for (int i = 0; i < server.connecting.size(); i++) {
			serverConnector clientRecieve = server.connecting.get(i);
			clientRecieve.ClientReceive(allOfPlayer, movementOfPlayer, speedOfPlayer);
		}
	}

	public void run() {
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			dataOutputStream.writeInt(allPlayer);
			dataOutputStream.flush();

			while (running) {

				allPlayer = dataInputStream.readInt();
				movement = dataInputStream.readInt();
				speedOfPlayer = dataInputStream.readInt();

				ClientReceives(allPlayer, movement, speedOfPlayer);
			}

		} 
		
		catch (IOException e) {
			Logger.getLogger(serverConnector.class.getName()).log(Level.SEVERE, null, e);
		}
	}
    
}
