import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frm7 extends Frame implements ActionListener {
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button b1, b2;

    int no, price;
    String nm;

    Frm7(String s) {
        super(s);

        l1 = new Label("Book ID");
        l2 = new Label("Book Name");
        l3 = new Label("Book Price");

        t1 = new TextField(10);
        t2 = new TextField(20);
        t3 = new TextField(10);

        b1 = new Button("Ok");
        b2 = new Button("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(50, 80, 100, 20);
        l3.setBounds(50, 110, 100, 20);
        b1.setBounds(50, 140, 100, 20);

        t1.setBounds(160, 50, 100, 20);
        t2.setBounds(160, 80, 150, 20);
        t3.setBounds(160, 110, 100, 20);
        b2.setBounds(160, 140, 100, 20);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);

        setSize(350, 210);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b;
        b = (Button) e.getSource();

        if (b == b2) {
            System.exit(0);
        } else {

            try {
                no = Integer.parseInt(t1.getText());
                nm = t2.getText();
                price = Integer.parseInt(t3.getText());
            } catch (Exception e1) {
            }

            if (no <= 0) {
                t1.requestFocus();
                return;
            }

            if (price <= 0) {
                t3.requestFocus();
                return;
            }

            String s = "Book Data" + "\nBook ID:    " + no + "\nBook Name:  " + nm + "\nBook Price: " + price;

            JOptionPane.showMessageDialog(null, s);
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm7 a = new Frm7("Book Information");
        a.menu();
    }
}