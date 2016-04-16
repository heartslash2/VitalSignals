package vitalSigns;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class VitalSigns {

	public static void main(String[] args) throws IOException{
		
		// create a listening socket on port 9090
        try (ServerSocket listener = new ServerSocket(9090)) {
            while (true) {
                for (int i = 0; i < 100; i++) { 
                	Person person = new Person();
                	String health = person.checkHealth();
                    try (Socket socket = listener.accept()) { 
                        // create message to send to client
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        // push message as a line
                        out.println(health);
                    }
                }
            }
        }
	}
}