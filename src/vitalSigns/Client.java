package vitalSigns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * The class used to read from a server.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class Client {

	/**
	 * Run the client
	 * 
	 * @param args
	 *            Ignored
	 * @throws IOException
	 *             If there is an error reading from the server
	 */
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 100; i++) {
			// this will need to change if the server is on a different machine
			// from the client, ex. 192.168.1.101
			Socket s = new Socket("localhost", 9090);
			// buffer for reading from an InputStream
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// read a single line
			String answer = input.readLine();
			// print to console the vital status
			System.out.println(answer);
			// close socket to prevent memory leak
			s.close();
		} // end 100 integer loop
		System.out.println("End of data stream.");
		// close Client
		System.exit(0);
	} // end main
} // end class
