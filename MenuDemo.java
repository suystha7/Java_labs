import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu.Separator;

public class MenuDemo extends JFrame implements ActionListener {

    JMenu filemenu, editmenu, viewmenu, toolbarmenu;
    JMenuItem openmitem, newmitem, savemitem, undomitem, redomitem, debugitem;
    JDesktopPane pane;

    public MenuDemo() {
        JMenuBar bar = new JMenuBar();

        setSize(500, 500);
        setTitle("Menu Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        filemenu = new JMenu("File");

        editmenu = new JMenu("Edit");
        viewmenu = new JMenu("View");
        toolbarmenu = new JMenu("Toolbars");

        ImageIcon icon = new ImageIcon("123.png");
        openmitem = new JMenuItem("Open", icon);
        openmitem.addActionListener(this);

        newmitem = new JMenuItem("New");
        newmitem.addActionListener(this);

        savemitem = new JMenuItem("Save");
        undomitem = new JMenuItem("Undo");
        redomitem = new JMenuItem("Redo");
        debugitem = new JMenuItem("Debug");

        setJMenuBar(bar);

        bar.add(filemenu);
        bar.add(editmenu);
        bar.add(viewmenu);

        viewmenu.add(toolbarmenu);
        toolbarmenu.add(debugitem);

        filemenu.add(openmitem);
        filemenu.add(newmitem);
        filemenu.add(new Separator());
        filemenu.add(savemitem);

        editmenu.add(undomitem);
        editmenu.add(redomitem);

        pane = new JDesktopPane();
        pane.setBackground(Color.BLACK);
        add(pane);

        setVisible(true);
    }

    public static void main(String[] args) {
        MenuDemo menuDemo = new MenuDemo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == newmitem) {
            JInternalFrame newframe = getInternalFrame();
            newframe.setBounds(200, 100, 400, 300);
            newframe.setTitle("New Form");
            newframe.setMaximizable(true);
            newframe.setResizable(false);
            newframe.setClosable(true);
            newframe.setVisible(true);
            pane.add(newframe);
        }

        if (ae.getSource() == openmitem) {
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(null);
            file.setVisible(true);
            pane.add(file);

        }

    }

    public JInternalFrame getInternalFrame() {
        return new JInternalFrame();
    }
}
