import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class AMD {
    void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            String s = JOptionPane.showInputDialog(null, "Enter File Name: ");
            s = s + 0;

            fos = new FileOutputStream("s.dat");
            oos = new ObjectOutputStream(fos);

            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }
}

public class vs extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu f, t;
    JMenuItem o, t1, t2, t3;
    Color cr;

    JTextArea ta;

    vs() {
        super("Editor");

        setSize(500, 500);
        setVisible(true);
    }

    public void menu() {
        ta = new JTextArea("Type", 300, 300);

        o = new JMenuItem("Open");
        o.addActionListener(this);

        f = new JMenu("File");
        f.add(o);

        t1 = new JMenuItem("Red");
        t2 = new JMenuItem("Blue");
        t3 = new JMenuItem("Green");

        t1.addActionListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);

        t = new JMenu("Themes");
        t.add(t1);
        t.add(t2);
        t.add(t3);

        mb = new JMenuBar();
        mb.add(f);
        mb.add(t);

        add(ta);
        ta.setVisible(false);
        setJMenuBar(mb);

    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem b = (JMenuItem) e.getSource();

        if (b == o) {
            ta.setVisible(true);
        }

        if (b == t1) {
            cr = new Color(255, 0, 0);
            ta.setBackground(cr);
        }

        if (b == t2) {
            cr = new Color(0, 0, 255);
            ta.setBackground(cr);
        }

        if (b == t3) {
            cr = new Color(0, 255, 0);
            ta.setBackground(cr);
        }
    }

    public static void main(String args[]) {
        vs a = new vs();
        a.menu();
    }
}
