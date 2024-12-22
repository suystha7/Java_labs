package TCP;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SingleChatClient {
    public static void main(String[] args) {
        try (Socket cs = new Socket("localhost", 1254);
             Scanner serverInput = new Scanner(cs.getInputStream());
             PrintWriter clientOutput = new PrintWriter(cs.getOutputStream(), true);
             Scanner userInput = new Scanner(System.in)) {

            String rmsg, smsg;

            do {
                if (serverInput.hasNextLine()) {
                    rmsg = serverInput.nextLine();
                    System.out.println("\tServer: " + rmsg);
                } else {
                    System.out.println("Connection closed by server.");
                    break;
                }
                System.out.print("Client: ");
                smsg = userInput.nextLine();
                clientOutput.println(smsg);

            } while (!"buy".equalsIgnoreCase(rmsg));

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
