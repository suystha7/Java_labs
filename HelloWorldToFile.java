
import java.io.FileWriter;
import java.io.IOException;

public class HelloWorldToFile {
    public static void main(String[] args) {
        String fileName = "abc.txt";
        String text = "Hello World";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Successfully wrote to the file:" + fileName);
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file:" + fileName);
            e.printStackTrace();
        }
    }

}
