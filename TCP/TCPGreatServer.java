package TCP;
import java.io.*;
import java.net.*;

public class TCPGreatServer {
    public static void main(String[] args) {
        try {
            // Start server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Setup input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive two integers from the client
            int num1 = in.readInt();
            int num2 = in.readInt();
            System.out.println("Received numbers: " + num1 + " and " + num2);

            // Find the greatest number
            int greatest = Math.max(num1, num2);

            // Send the result back to the client
            out.writeInt(greatest);
            System.out.println("Sent greatest number: " + greatest);

            // Close connections
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
