package TCP;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to the server!");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the length of the rectangle: ");
            String length = scanner.nextLine();
            System.out.print("Enter the breadth of the rectangle: ");
            String breadth = scanner.nextLine();

            out.println(length);
            out.println(breadth);

            String response = in.readLine();
            System.out.println("Server: " + response);

            in.close();
            out.close();
            scanner.close();
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
