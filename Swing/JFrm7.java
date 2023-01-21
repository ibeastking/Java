import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class JFrm7 extends JFrame {

    JTree tr;
    JLabel l1;

    JFrm7() {
        super("Tree");

        l1 = new JLabel("Choose City");
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Choices");
        DefaultMutableTreeNode c = new DefaultMutableTreeNode("City");

        top.add(c);

        DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("Sangli");
        c.add(c1);

        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("Kolhapur");
        c.add(c2);

        DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("Nagpur");
        c.add(c3);

        DefaultMutableTreeNode c4 = new DefaultMutableTreeNode("Mumbai");
        c.add(c4);

        DefaultMutableTreeNode s = new DefaultMutableTreeNode("State");
        top.add(s);

        DefaultMutableTreeNode s1 = new DefaultMutableTreeNode("Karnataka");
        s.add(s1);

        DefaultMutableTreeNode s2 = new DefaultMutableTreeNode("Gujarat");
        s.add(s2);

        DefaultMutableTreeNode s3 = new DefaultMutableTreeNode("Goa");
        s.add(s3);

        DefaultMutableTreeNode s4 = new DefaultMutableTreeNode("Telagana");
        s.add(s4);

        DefaultMutableTreeNode s5 = new DefaultMutableTreeNode("Madya Pradesh");
        s.add(s5);

        DefaultMutableTreeNode s6 = new DefaultMutableTreeNode("Chhattisgarh");
        s.add(s6);

        tr = new JTree(top);

        tr.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                l1.setText("Selection is " + e.getPath());
            }
        });

        JScrollPane jsp = new JScrollPane(tr);
        add(jsp);
        add(l1, BorderLayout.SOUTH);
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void menu() {

    }

    public static void main(String args[]) {
        JFrm7 a = new JFrm7();
        a.menu();
    }
}