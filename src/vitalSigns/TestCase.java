package vitalSigns;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestCase {

	public static void main(String[] args) throws IOException {
		System.out.print("Enter the number of test patients: ");
		Scanner in = new Scanner(System.in);
		int input = 0;
		try {
			input = in.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// create a listening socket on port 9090
        try (ServerSocket listener = new ServerSocket(9090)) {
            while (true) {
                for (int i = 0; i < input; i++) {
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
                	Person person = new Person(oxygen, systolic, diastolic, temperature, glucose, rate);
                	String health = person.checkHealth();
                    try (Socket socket = listener.accept()) { 
                        // create message to send to client
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        // push message as a line
                        out.println(health);
                    }
                }
                System.out.println("All vitals sent");
                in.close();
                break;
            }
        }
	}
	
}
