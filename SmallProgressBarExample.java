import java.awt.*;
import javax.swing.*;

public class SmallProgressBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Small Progress Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(200, 15));

        frame.add(progressBar);

        frame.setVisible(true);

        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setValue(i);
            }
            JOptionPane.showMessageDialog(frame, "Task Completed!", "Message", JOptionPane.INFORMATION_MESSAGE);
        }).start();
    }
}
