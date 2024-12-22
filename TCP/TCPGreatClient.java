import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPGreatClient {
    public static void main(String[] args) {
        try {
            // Connect to the server running on localhost and port 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to the server.");

            // Setup input and output streams
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Create Scanner to take input from the user
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter two integers
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Send the two numbers to the server
            System.out.println("Sending numbers: " + num1 + " and " + num2);
            out.writeInt(num1);
            out.writeInt(num2);

            // Receive the greatest number from the server
            int greatest = in.readInt();
            System.out.println("Greatest number received from server: " + greatest);
        
            // Close connections
            in.close();
            out.close();
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
