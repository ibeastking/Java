import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class prat2 extends Frame implements ActionListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
    TextField t1;
    String pass;

    prat2(String s) {

        // * calling the Frame super class
        super(s);

        // * initializing the String
        pass = "";

        // * initializing the buttons
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b10 = new Button("0");
        b11 = new Button("Ok");
        b12 = new Button("Exit");
        b13 = new Button("Enter Password");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);

        // * initializing the text field
        t1 = new TextField(400);
        t1.setEditable(true);

        setLayout(null);

        // * setting the size of the buttons
        b1.setBounds(50, 150, 50, 50);
        b2.setBounds(100, 150, 50, 50);
        b3.setBounds(150, 150, 50, 50);

        b4.setBounds(50, 100, 50, 50);
        b5.setBounds(100, 100, 50, 50);
        b6.setBounds(150, 100, 50, 50);

        b7.setBounds(50, 50, 50, 50);
        b8.setBounds(100, 50, 50, 50);
        b9.setBounds(150, 50, 50, 50);

        b11.setBounds(50, 200, 50, 50);
        b10.setBounds(100, 200, 50, 50);
        b12.setBounds(150, 200, 50, 50);

        t1.setBounds(50, 10, 50, 150);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
        add(t1);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(250, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b;
        b = (Button) e.getSource();

        if (b == b12) {
            System.exit(0);
        }

        if (b == b11) {
            String s = t1.getText();
            String p = "7411";

            if (s == p) {
                System.out.println(s == p);
                JOptionPane.showMessageDialog(null, "Correct" + s);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect" + s);
            }
        }

        if (b == b1) {
            pass = pass + "1";
        }

        if (b == b2) {
            pass = pass + "2";
        }

        if (b == b3) {
            pass = pass + "3";
        }

        if (b == b4) {
            pass = pass + "4";
        }

        if (b == b5) {
            pass = pass + "5";
        }

        if (b == b6) {
            pass = pass + "6";
        }

        if (b == b7) {
            pass = pass + "7";
        }

        if (b == b8) {
            pass = pass + "8";
        }

        if (b == b9) {
            pass = pass + "9";
        }

        if (b == b10) {
            pass = pass + "0";
        }

        t1.setText(pass);
    }

    void menu() {
    }

    public static void main(String args[]) {
        prat2 a = new prat2("Lock");
        a.menu();
    }
}