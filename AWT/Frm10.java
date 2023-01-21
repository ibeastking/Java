import java.awt.event.*;
import java.awt.*;

class Frm10 extends Frame implements WindowListener, FocusListener {
    int r, g, b;
    Color cr, cg, cb, clr;
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Panel p1, p2, p3, p4;

    Frm10() {
        super("Color");

        r = g = b = 0;

        l1 = new Label("Red");
        l2 = new Label("Green");
        l3 = new Label("Blue");

        t1 = new TextField(5);
        t2 = new TextField(5);
        t3 = new TextField(5);

        t1.addFocusListener(this);
        t2.addFocusListener(this);
        t3.addFocusListener(this);

        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();

        setLayout(null);

        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(50, 80, 100, 20);
        l3.setBounds(50, 110, 100, 20);

        t1.setBounds(160, 50, 100, 20);
        t2.setBounds(160, 80, 100, 20);
        t3.setBounds(160, 110, 100, 20);

        p1.setBounds(270, 50, 100, 20);
        p2.setBounds(270, 80, 100, 20);
        p3.setBounds(270, 110, 100, 20);
        p4.setBounds(380, 50, 100, 80);

        add(l1);
        add(t1);
        add(p1);
        add(p4);
        add(l2);
        add(t2);
        add(p2);
        add(l3);
        add(t3);
        add(p3);

        addWindowListener(this);

        setSize(530, 180);
        setResizable(false);
        setVisible(true);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        TextField t = (TextField) e.getSource();

        int val = 0;

        try {
            val = Integer.parseInt(t.getText());
        } catch (Exception e1) {
            t.requestFocus();
            return;
        }

        if (val < 0 || val > 255) {
            t.requestFocus();
            return;
        }

        if (t == t1) {
            r = val;
        }

        if (t == t2) {
            g = val;
        }

        if (t == t3) {
            b = val;
        }

        cr = new Color(r, 0, 0);
        cg = new Color(0, g, 0);
        cb = new Color(0, 0, b);

        clr = new Color(r, g, b);

        p1.setBackground(cr);
        p2.setBackground(cg);
        p3.setBackground(cb);
        p4.setBackground(clr);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm10 a = new Frm10();
        a.menu();
    }
}