import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

class cus extends Frame implements ActionListener {
    Label l1, l2, l3, l4, l5, l6;
    Button b1, b2, b3, b4;
    Color cr1, cr2, cr3, cr4;
    Image img;

    cus() {
        super("Choose the item");

        l1 = new Label("Items");
        l2 = new Label("Prices");
        l3 = new Label("$1");
        l4 = new Label("$2");
        l5 = new Label("$5");
        l6 = new Label("$10");

        b1 = new Button("Candies");
        b2 = new Button("Cookies");
        b3 = new Button("Chips");
        b4 = new Button("Biscuits");

        b1.addActionListener(this);
        cr1 = new Color(255, 0, 0);
        b1.setBackground(cr1);

        b2.addActionListener(this);
        cr2 = new Color(0, 255, 0);
        b2.setBackground(cr2);

        b3.addActionListener(this);
        cr3 = new Color(0, 0, 255);
        b3.setBackground(cr3);

        b4.addActionListener(this);
        cr4 = new Color(255, 0, 255);
        b4.setBackground(cr4);

        setLayout(new GridLayout(5, 2, 5, 5));

        add(l1);
        add(l2);
        add(b1);
        add(l3);
        add(b2);
        add(l4);
        add(b3);
        add(l5);
        add(b4);
        add(l6);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b;
        b = (Button) e.getSource();

        int q; // * q stands for quantity
        int price;

        if (b == b1) {
            try {
                q = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Quantity: "));

                price = q;
                JOptionPane.showMessageDialog(null, "Total Price: " + price);
                repaint();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }

        if (b == b2) {
            try {
                q = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Quantity: "));

                price = q * 2;
                JOptionPane.showMessageDialog(null, "Total Price: " + price);
                repaint();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }

        if (b == b3) {
            try {
                q = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Quantity: "));

                price = q * 5;
                JOptionPane.showMessageDialog(null, "Total Price: " + price);
                repaint();
            } catch (Exception e3) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }

        if (b == b4) {
            try {
                q = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Quantity: "));

                price = q * 10;
                JOptionPane.showMessageDialog(null, "Total Price: " + price);
                repaint();
            } catch (Exception e4) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }

    }

    public void paint(Graphics g) {

        try {
            img = (Image) ImageIO.read(new File("chart.jpeg"));
        } catch (Exception e) {
        }

        Color cr;
        cr = new Color(255, 0, 0);

        g.drawImage(img, 0, 0, 300, 300, cr, this);
    }

    void menu() {

    }
}

class emp extends Frame implements ActionListener {
    Label l1, l2;
    TextField t1, t2;
    Button b1;
    Color cr1, cr2;

    emp() {
        l1 = new Label("Employee ID");
        l2 = new Label("Password");
        t1 = new TextField(10);
        t2 = new TextField(10);
        b1 = new Button("Login");

        cr1 = new Color(0, 0, 255);
        cr2 = new Color(0, 0, 255);

        t1.addActionListener(this);
        t2.addActionListener(this);
        b1.addActionListener(this);

        setLayout(null);
        l1.setBounds(50, 50, 100, 50);
        l1.setBackground(cr1);
        l2.setBounds(50, 150, 100, 50);
        l2.setBackground(cr2);
        t1.setBounds(250, 50, 100, 50);
        t2.setBounds(250, 150, 100, 50);
        b1.setBounds(100, 250, 100, 50);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b;
        b = (Button) e.getSource();

        if (b == b1) {
            String s = "";
            s = t2.getText();

            if (s == "7411") {
                JOptionPane.showMessageDialog(null, "Welcome");
            } else {
                JOptionPane.showMessageDialog(null, "Not Welcomed");
            }
        }
    }

    void menu() {

    }
}

class shop extends Frame implements ActionListener {
    Button b1, b2;
    Color cr1, cr2;

    shop() {
        super("Welcome");

        b1 = new Button("Customer");
        b2 = new Button("Employee");
        b1.addActionListener(this);
        b2.addActionListener(this);

        cr1 = new Color(255, 0, 0);
        cr2 = new Color(0, 255, 0);

        setLayout(null);

        b1.setBounds(50, 100, 100, 100);
        b2.setBounds(250, 100, 100, 100);
        b1.setBackground(cr1);
        b2.setBackground(cr2);

        add(b1);
        add(b2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b;
        b = (Button) e.getSource();

        if (b == b1) {
            cus a = new cus();
            a.menu();
        } else {
            emp m = new emp();
            m.menu();
        }
    }

    void menu() {

    }

    public static void main(String args[]) {
        shop a = new shop();
        a.menu();
    }
}
