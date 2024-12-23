import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI {
    JFrame f;
    JPanel p1, p2;
    JLabel usernameLabel, passwordLabel;
    JTextField usernameTextField;
    JPasswordField passwordField;
    JButton loginBtn, resetBtn, cancelBtn;

    public LoginGUI() {
        f = new JFrame();
        f.setSize(400, 250);
        f.setTitle("Login");
        f.setLocation(200, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        p1 = new JPanel();
        p1.setBackground(Color.GRAY);
        p1.setBounds(0, 0, 400, 150);
        f.add(p1);
        p1.setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 20, 100, 30);
        p1.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(150, 20, 150, 30);
        p1.add(usernameTextField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 100, 30);
        p1.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        p1.add(passwordField);

        p2 = new JPanel();
        p2.setBackground(Color.DARK_GRAY);
        p2.setBounds(0, 150, 400, 100);
        f.add(p2);
        p2.setLayout(null);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(50, 20, 80, 30);
        p2.add(loginBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(160, 20, 80, 30);
        p2.add(resetBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(270, 20, 80, 30);
        p2.add(cancelBtn);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
