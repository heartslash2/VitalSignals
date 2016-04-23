package vitalSigns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * A testing class used to check server sending properly. This client only reads
 * in one string from the server. To receive multiple strings, run multiple
 * times. Only one string is recorded at a time.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class TestClient {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 9090);
		// buffer for reading from an InputStream
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		// read a single line
		String answer = input.readLine();
		// print line to console
		System.out.println(answer);
		// close socket to prevent memory leaks
		s.close();
	}
}
