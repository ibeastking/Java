//! Use of Button Class

import java.awt.*;
import java.awt.event.*;

class Frm2 extends Frame implements ActionListener {
    Button b1; // * button is component

    Frm2(String str) {
        super(str);
        b1 = new Button("Exit");

        b1.addActionListener(this);

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
        Frm2 a = new Frm2("Button");
        a.menu();
    }
}