import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frm6 extends Frame implements ActionListener, FocusListener {
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button b1, b2;
    int no, mrk;
    String nm;

    Frm6(String s) {
        super(s);
        l1 = new Label("Number");
        l2 = new Label("Name");
        l3 = new Label("Marks");

        t1 = new TextField(5);
        t2 = new TextField(30);
        t3 = new TextField(5);

        b1 = new Button("Ok");
        b2 = new Button("Exit");

        t1.addFocusListener(this);
        t3.addFocusListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        setSize(400, 300);
        setVisible(true);
    }

    public void focusGained(FocusEvent e) {
        TextField t = (TextField) e.getSource();

        if (t == t1) {
            b1.setEnabled(false);
        }
    }

    public void focusLost(FocusEvent e) {
        TextField t = (TextField) e.getSource();

        if (t == t1) {
            try {
                no = Integer.parseInt(t1.getText());
            } catch (Exception e1) {
                t1.requestFocus();
                return;
            }
            if (no < 0) {
                t1.requestFocus();
                return;
            }
        }

        if (t == t3) {
            try {
                mrk = Integer.parseInt(t3.getText());
            } catch (Exception e1) {
                t3.requestFocus();
                return;
            }

            if (mrk < 0 || mrk > 100) {
                t3.requestFocus();
                return;
            }

            b1.setEnabled(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Button b;
        b = (Button) e.getSource();

        if (b == b2) {
            System.exit(0);
        }

        if (b == b1) {
            String s = "Roll Number: " + no + "\nName: " + t2.getText() + "\nMarks: " + mrk;

            JOptionPane.showMessageDialog(null, s);
            t1.requestFocus();
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm6 a = new Frm6("Result");
        a.menu();
    }
}