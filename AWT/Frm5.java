import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frm5 extends Frame implements ActionListener {
    Label l1, l2;
    TextField t1, t2;
    Button b1, b2;

    Frm5(String s) {
        super(s);

        l1 = new Label("Number: ");
        l2 = new Label("Name: ");

        t1 = new TextField(10);
        t2 = new TextField(20);

        b1 = new Button("Ok");
        b2 = new Button("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5)); // * GridLayout(row,col,hgap,vgap)

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == b2) {
            System.exit(0);
        } else {
            String a = "Number: " + t1.getText() + "\nName: " + t2.getText();
            JOptionPane.showMessageDialog(null, a);
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm5 a = new Frm5("Student List");
        a.menu();
    }
}