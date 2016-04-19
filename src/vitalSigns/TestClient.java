package vitalSigns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClient {

	
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 9090);
		// buffer for reading from an InputStream
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		// read a single line
		String answer = input.readLine();
		System.out.println(answer);
		s.close();
	}
}
