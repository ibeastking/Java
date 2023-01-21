import java.awt.*;
import java.awt.event.*;

class Frm3 extends Frame implements ActionListener {
    Button b1; // * button is component

    Frm3(String str) {
        super(str);
        b1 = new Button("Exit");

        b1.addActionListener(this);

        setLayout(null);
        b1.setBounds(100, 190, 200, 20); // * (C,R,W,H)

        // * add method adds the button to Window and so specific direction is set is
        // assumes centre position
        add(b1);

        setSize(600, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm3 a = new Frm3("Button");
        a.menu();
    }
}