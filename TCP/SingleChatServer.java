package TCP;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1254)) {
            System.out.println("Server is running and waiting for a client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            try (Scanner clientInput = new Scanner(clientSocket.getInputStream());
                 PrintWriter serverOutput = new PrintWriter(clientSocket.getOutputStream(), true);
                 Scanner userInput = new Scanner(System.in)) {

                String rmsg, smsg;

                do {
                    System.out.print("Server: ");
                    smsg = userInput.nextLine();
                    serverOutput.println(smsg);
                    if (clientInput.hasNextLine()) {
                        rmsg = clientInput.nextLine();
                        System.out.println("\tClient: " + rmsg);
                    } else {
                        System.out.println("Client disconnected.");
                        break;
                    }

                } while (!"buy".equalsIgnoreCase(smsg));

            }

        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
        }
    }
}
