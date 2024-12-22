package TCP;
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is running and waiting for a client...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive length and breadth from the client
            String lengthStr = in.readLine();
            String breadthStr = in.readLine();
            System.out.println("Received length: " + lengthStr);
            System.out.println("Received breadth: " + breadthStr);

            // Convert to integers and calculate the area
            try {
                int length = Integer.parseInt(lengthStr);
                int breadth = Integer.parseInt(breadthStr);
                int area = length * breadth;

                // Send the area back to the client
                out.println("The area of the rectangle is: " + area);
                System.out.println("Area calculated and sent to client.");
            } catch (NumberFormatException e) {
                out.println("Invalid input. Please send valid integers.");
            }

            // Close the connection
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Server closed the connection.");

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
