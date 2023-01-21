import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class JFrm4 extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;

    JFrm4() {
        super("Login");

        l1 = new JLabel("ID");
        l2 = new JLabel("Password");
        t1 = new JTextField(10);
        p1 = new JPasswordField(10);
        b1 = new JButton("OK");
        b2 = new JButton("Clear");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);
        add(b2);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == b1) {
            String a = "abc_1234";
            String bs = "9096064326";
            String c = t1.getText();
            String d = p1.getText();

            if (a.equals(c)) {
                if (bs.equals(d)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid ID");
            }
        }

        t1.setText("");
        p1.setText("");

        t1.requestFocus();
    }

    void menu() {
    }

    public static void main(String args[]) {
        JFrm4 a = new JFrm4();
        a.menu();
    }
}