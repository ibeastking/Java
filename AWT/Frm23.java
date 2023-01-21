import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frm23 extends Frame implements ActionListener {

    Checkbox c1, c2, c3, c4, c5, c6;
    Button b1, b2;

    Frm23() {
        super("CheckBox");

        c1 = new Checkbox("Tata");
        c2 = new Checkbox("Ford");
        c3 = new Checkbox("Suzuki");
        c4 = new Checkbox("Maruti");
        c5 = new Checkbox("BMW");
        c6 = new Checkbox("Mahindra");

        b1 = new Button("Ok");
        b2 = new Button("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new FlowLayout());
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(c6);
        add(b1);
        add(b2);

        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == b2) {
            System.exit(0);
        }

        if (b == b1) {
            String s = "Brands\n";

            if (c1.getState() == true) {
                s = s + c1.getLabel() + "\n";
            }

            if (c2.getState() == true) {
                s = s + c2.getLabel() + "\n";
            }

            if (c3.getState() == true) {
                s = s + c3.getLabel() + "\n";
            }

            if (c4.getState() == true) {
                s = s + c4.getLabel() + "\n";
            }

            if (c5.getState() == true) {
                s = s + c5.getLabel() + "\n";
            }

            if (c6.getState() == true) {
                s = s + c6.getLabel() + "\n";
            }

            JOptionPane.showMessageDialog(null, s);
        }
    }

    public void error() {
    }

    public static void main(String args[]) {
        Frm23 a = new Frm23();
        a.error();
    }
}