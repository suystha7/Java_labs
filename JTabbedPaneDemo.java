

import java.awt.Color;
import javax.swing.*;

public class JTabbedPaneDemo {

    JTabbedPane jtp;

    public JTabbedPaneDemo() {
        JFrame f = new JFrame();
        f.setTitle("Example of JTabbedPane");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JTabbedPane
        jtp = new JTabbedPane();
        jtp.setBounds(50, 50, 410, 300);

        // Add Tabs
        jtp.addTab("Hobbies", new HobbiesTab());
        jtp.addTab("Education", new EducationTab());
        jtp.addTab("Gender", new GenderTab());
        f.add(jtp);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new JTabbedPaneDemo();
    }
}

class HobbiesTab extends JPanel {
    JCheckBox ch1, ch2, ch3, ch4;
    JTextArea commentArea;
    JLabel commentLabel;

    public HobbiesTab() {
        setLayout(null);

        // Checkboxes
        ch1 = new JCheckBox("Gaming");
        ch2 = new JCheckBox("Swimming");
        ch3 = new JCheckBox("Riding");
        ch4 = new JCheckBox("Coding");

        add(ch1);
        add(ch2);
        add(ch3);
        add(ch4);

        ch1.setBounds(100, 50, 100, 30);
        ch2.setBounds(100, 85, 100, 30);
        ch3.setBounds(100, 120, 100, 30);
        ch4.setBounds(100, 155, 100, 30);

        // Label
        commentLabel = new JLabel("Comments:");
        commentLabel.setBounds(100, 190, 80, 30);
        add(commentLabel);

        // TextArea with ScrollPane
        commentArea = new JTextArea();
        JScrollPane pane = new JScrollPane(commentArea);
        pane.setBounds(190, 190, 200, 60);
        add(pane);
    }
}

class EducationTab extends JPanel {
    JComboBox<String> jcb;

    public EducationTab() {
        setLayout(null);

        // ComboBox
        String[] levels = { "Primary", "Secondary", "High School", "Bachelor", "Master", "PhD" };
        jcb = new JComboBox<>(levels);

        JLabel label = new JLabel("Education Level:");
        label.setBounds(50, 50, 120, 30);
        add(label);

        jcb.setBounds(180, 50, 150, 30);
        add(jcb);

        setBackground(Color.LIGHT_GRAY);
    }
}

class GenderTab extends JPanel {
    JRadioButton male, female, other;
    ButtonGroup group;

    public GenderTab() {
        setLayout(null);

        // Radio Buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        add(male);
        add(female);
        add(other);

        male.setBounds(100, 50, 100, 30);
        female.setBounds(100, 85, 100, 30);
        other.setBounds(100, 120, 100, 30);

        setBackground(Color.WHITE);
    }
}
