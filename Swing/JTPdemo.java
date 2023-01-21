import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentPanel extends JPanel implements ActionListener {

    int no, mrk;
    String nm;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    StudentPanel() {
        super();

        l1 = new JLabel("Number");
        l2 = new JLabel("Name");
        l3 = new JLabel("Marks");

        t1 = new JTextField(10);
        t2 = new JTextField(40);
        t3 = new JTextField(10);

        b1 = new JButton("OK");
        b2 = new JButton("Clear");

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
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == b1) {
            String s = "Roll Number: " + t1.getText() + "\nName: " + t2.getText() + "\nMarks: " + t3.getText();

            JOptionPane.showMessageDialog(null, s);
        }

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t1.requestFocus();
    }
}

class TradePanel extends JPanel {
    JCheckBox b1, b2, b3, b4, b5;

    TradePanel() {
        super();

        b1 = new JCheckBox("Mechanical");
        b2 = new JCheckBox("CSE");
        b3 = new JCheckBox("IT");
        b4 = new JCheckBox("Electronics");
        b5 = new JCheckBox("Electrical");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
    }
}

class YearPanel extends JPanel {
    JRadioButton b1, b2, b3, b4;
    ButtonGroup bg;

    YearPanel() {
        super();

        b1 = new JRadioButton("FE");
        b2 = new JRadioButton("SE");
        b3 = new JRadioButton("TE");
        b4 = new JRadioButton("DE");

        bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        bg.add(b4);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }
}

public class JTPdemo extends JFrame {
    JTabbedPane a;

    JTPdemo() {
        super();
        a = new JTabbedPane();
        a.add(new StudentPanel(), "Student");
        a.add(new YearPanel(), "Trade");
        a.add(new YearPanel(), "Year");
        add(a);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String args[]) {
        JTPdemo a = new JTPdemo();
    }
}