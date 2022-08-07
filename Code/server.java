package assignment_part2;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class server {
        
	boolean runnable = true;
	int i = 0;
	
	ServerSocket serverSocket;
	ArrayList<serverConnector> connecting = new ArrayList<serverConnector>();
	
	public static void main(String[] args) {
		new server();
	}
        
	public server() {
		
		System.out.println("Server is online.");
		try {
			serverSocket = new ServerSocket(9999);

			while (i < 2) {
				Socket socket = serverSocket.accept();
				i++;
				System.out.println("Connection established.");
				System.out.println("Player " + i );

				serverConnector severConnector = new serverConnector(socket, this, i);
				connecting.add(severConnector);

				Thread thread = new Thread(severConnector);
				thread.start();
			}

			System.out.println("Maximum 2 players. You need to wait.");

		} 
		
		catch (IOException ex) {
			Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
		}

	}    
}
