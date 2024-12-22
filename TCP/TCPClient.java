package TCP;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to the server!");

            // Streams for communication
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Input from the user
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the length of the rectangle: ");
            String length = scanner.nextLine();
            System.out.print("Enter the breadth of the rectangle: ");
            String breadth = scanner.nextLine();

            // Send length and breadth to the server
            out.println(length);
            out.println(breadth);

            // Receive and display the result
            String response = in.readLine();
            System.out.println("Server: " + response);

            // Close resources
            in.close();
            out.close();
            scanner.close();
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
