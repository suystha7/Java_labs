import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPGreatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to the server.");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            System.out.println("Sending numbers: " + num1 + " and " + num2);
            out.writeInt(num1);
            out.writeInt(num2);

            int greatest = in.readInt();
            System.out.println("Greatest number received from server: " + greatest);

            in.close();
            out.close();
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
