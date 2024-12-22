package UDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on a specific port
            DatagramSocket serverSocket = new DatagramSocket(9876);
            System.out.println("Server is running and waiting for messages...");

            // Buffer to store incoming data
            byte[] receiveBuffer = new byte[1024];

            while (true) {
                // Prepare a DatagramPacket to receive data
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                // Receive data from a client
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + clientMessage);

                // Check for termination
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Connection closed by client.");
                    break;
                }

                // Send a response to the client
                String response = "Message received: " + clientMessage;
                byte[] responseBuffer = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        responseBuffer,
                        responseBuffer.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort());
                serverSocket.send(sendPacket);
            }

            // Close the socket
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
