package vitalSigns;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class creates a test server to simulate a server run case. The
 * administrator must input all health values, so this should only be used for
 * testing purposes.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class TestCase {

	/**
	 * Run the test server.
	 * 
	 * @param args
	 *            Ignored
	 * @throws IOException
	 *             If there is an error writing to server or reading from
	 *             Scanner
	 */
	public static void main(String[] args) throws IOException {

		// prompt for number of trial cases
		System.out.print("Enter the number of test patients: ");
		// create scanner for reading input numbers
		Scanner in = new Scanner(System.in);
		// get number for trial cases
		int input = in.nextInt();

		// create a listening socket on port 9090
		try (ServerSocket listener = new ServerSocket(9090)) {
			while (true) { // continuously run
				for (int i = 0; i < input; i++) {
					// input prompts followed by respective scanner read
					System.out.print("Enter the blood oxygen: ");
					int oxygen = in.nextInt();
					System.out.print("Enter the blood pressure (systolic): ");
					int systolic = in.nextInt();
					System.out.print("Enter the blood pressure (diastolic): ");
					int diastolic = in.nextInt();
					System.out.print("Enter the body temperature: ");
					float temperature = in.nextFloat();
					System.out.print("Enter the glucose level: ");
					int glucose = in.nextInt();
					System.out.print("Enter the heart rate: ");
					int rate = in.nextInt();
					// create a person using the entered information
					Person person = new Person(oxygen, systolic, diastolic, temperature, glucose, rate);
					// create a string of the person's health
					String health = person.checkHealth();
					try (Socket socket = listener.accept()) {
						// create message to send to client
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						// push message as a line
						out.println(health);
					}
				}
				// inform administrator that all vitals from the test were sent
				System.out.println("All vitals sent");
				// close scanner
				in.close();
				// end server
				break;
			}
		}
	}

}
