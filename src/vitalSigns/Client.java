package vitalSigns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException, FileNotFoundException {
			for (int i = 0; i < 100; i++) { 
				Socket s = new Socket("localhost", 9090);
				// buffer for reading from an InputStream
				BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// read a single line
				String answer = input.readLine();
				System.out.println(answer);
				s.close();
			} // end 100 integer loop
			System.out.println("End of data stream.");
		// close Client
		System.exit(0);
	} // end main
} // end class
