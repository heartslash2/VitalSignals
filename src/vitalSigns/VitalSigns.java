package vitalSigns;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class acts as a server receiving the data from the sensors to send out
 * to a client. For client purposes, where this code is will act as the host
 * machine, so that machine's IP address will need to be added to the client
 * code to work properly.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class VitalSigns {

	/**
	 * Run the server simulating vital signs.
	 * 
	 * @param args
	 *            Ignored
	 * @throws IOException
	 *             In case there is a problem writing messages to server queue.
	 */
	public static void main(String[] args) throws IOException {

		// create a listening socket on port 9090
		try (ServerSocket listener = new ServerSocket(9090)) {
			// keep server open forever
			while (true) {
				for (int i = 0; i < 100; i++) {
					// create random person vitals
					Person person = new Person();
					// get string of vitals from person
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