import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frm4 extends Frame implements ActionListener {
    Button b1, b2;

    Frm4(String s) {
        super(s);
        b1 = new Button("Ok");
        b2 = new Button("Exit");
        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        b1.setBounds(40, 40, 100, 60);
        b2.setBounds(260, 200, 100, 60);

        add(b1);
        add(b2);

        setSize(400, 300);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == b2) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Welcome");
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm4 a = new Frm4("Button");
        a.menu();
    }
}