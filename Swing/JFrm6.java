import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyDialog extends JDialog implements ActionListener {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;

    MyDialog(JFrame a, String title, boolean state) {
        super(a, title, state);

        l1 = new JLabel("Number");
        l2 = new JLabel("Name");

        t1 = new JTextField(10);
        t2 = new JTextField(20);

        b1 = new JButton("OK");
        b2 = new JButton("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        setSize(400, 400);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == b1) {
            String a = "Roll Number: " + t1.getText() + "\nName: " + t2.getText();
            JOptionPane.showMessageDialog(null, a);
        }

        setVisible(false);
    }
}

public class JFrm6 extends JFrame implements ActionListener {

    MyDialog a;
    JButton b;

    JFrm6() {
        super("Dialog");

        a = new MyDialog(this, "Student", true);
        b = new JButton("Student");

        b.addActionListener(this);

        setLayout(null);
        b.setBounds(50, 100, 100, 20);
        add(b);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        a.setVisible(true);
    }

    public void error() {
    }

    public static void main(String args[]) {
        JFrm6 a = new JFrm6();
        a.error();
    }
}