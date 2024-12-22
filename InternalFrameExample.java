import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InternalFrameExample {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Internal Frame Example");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);

        JDesktopPane desktopPane = new JDesktopPane();

        JButton addFrameButton = new JButton("Add Internal Frame");
        addFrameButton.setBounds(10, 10, 150, 30);
        desktopPane.add(addFrameButton);
        addFrameButton.addActionListener(new ActionListener() {
            int frameCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                frameCount++;
                JInternalFrame internalFrame = new JInternalFrame(
                    "Frame " + frameCount,
                    true,
                    true,
                    true,
                    true
                );
                internalFrame.setSize(200, 150);
                internalFrame.setVisible(true);

                internalFrame.setLocation(30 * frameCount, 30 * frameCount);

                desktopPane.add(internalFrame);
            }
        });

        mainFrame.add(desktopPane);
        mainFrame.setVisible(true);
    }
}
