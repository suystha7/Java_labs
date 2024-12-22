package TCP;

import java.io.*;
import java.net.*;

public class TCPGreatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int num1 = in.readInt();
            int num2 = in.readInt();
            System.out.println("Received numbers: " + num1 + " and " + num2);

            int greatest = Math.max(num1, num2);

            out.writeInt(greatest);
            System.out.println("Sent greatest number: " + greatest);

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
