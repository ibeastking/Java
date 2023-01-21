import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class prat1 extends Frame implements ActionListener {
    Button b1, b2, b3, b4;

    prat1(String str) {

        super(str);
        JOptionPane.showMessageDialog(null, "Who is India's Best Captian?");

        b1 = new Button("A) Virat Kohli");
        b2 = new Button("B) Rohit Sharma");
        b3 = new Button("C) Mahendra Singh Dhoni");
        b4 = new Button("D) Ravindra Jadeja");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setLayout(new GridLayout(2, 2, 15, 5));

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        setSize(400, 300);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == b3) {
            JOptionPane.showMessageDialog(null, "Your Answer is Correct");
        } else {
            JOptionPane.showMessageDialog(null, "Your Answer is Wrong");
        }

        System.exit(0);
    }

    void menu() {
    }

    public static void main(String args[]) {
        prat1 a = new prat1("Question");
        a.menu();
    }
}