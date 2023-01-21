import java.awt.*;
import java.awt.event.*;

class Frm22 extends Frame implements ActionListener, AdjustmentListener, FocusListener {

    TextField t1, t2, t3;
    Panel p1, p2, p3, p4;
    Scrollbar s1, s2, s3;
    Label l1, l2, l3, l4;
    int r, g, b, val;
    Button bx;

    Frm22() {
        super("Scrollbar");

        // ! label declaration
        l1 = new Label("Red");
        l2 = new Label("Green");
        l3 = new Label("Blue");
        l4 = new Label("Color");

        // ! textfield declaration
        t1 = new TextField(10);
        t1.addFocusListener(this);
        t2 = new TextField(10);
        t2.addFocusListener(this);
        t3 = new TextField(10);
        t3.addFocusListener(this);

        // ! panel declaration
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();

        // ! Scrollbar arguments are
        // ! first argument is direction of the scrollbar
        // ! second argument is the default value
        // ! third argument is the value by which the scrollbar will change when clicked
        // on
        // ! fourth and fifth arguments are the starting and ending point of the scroll
        s1 = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 255);
        s2 = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 255);
        s3 = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 255);
        s1.addAdjustmentListener(this);
        s2.addAdjustmentListener(this);
        s3.addAdjustmentListener(this);

        // ! button declaration
        bx = new Button("Exit");
        bx.addActionListener(this);

        setLayout(null);

        l1.setBounds(50, 50, 20, 20);
        s1.setBounds(50, 80, 50, 100);
        t1.setBounds(50, 190, 50, 20);
        p1.setBounds(50, 220, 50, 20);

        l2.setBounds(110, 50, 20, 20);
        s2.setBounds(110, 80, 50, 100);
        t2.setBounds(110, 190, 50, 20);
        p2.setBounds(110, 220, 50, 20);

        l3.setBounds(170, 50, 20, 20);
        s3.setBounds(170, 80, 50, 100);
        t3.setBounds(170, 190, 50, 20);
        p3.setBounds(170, 220, 50, 20);

        l4.setBounds(230, 50, 100, 20);
        p4.setBounds(230, 80, 100, 130);
        bx.setBounds(230, 220, 100, 20);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(s1);
        add(s2);
        add(s3);
        add(p4);
        add(t1);
        add(t2);
        add(t3);
        add(p1);
        add(p2);
        add(p3);
        add(bx);

        setSize(370, 290);
        setVisible(true);
    }

    public void focusGained(FocusEvent e) {

    }

    public void focusLost(FocusEvent e) {
        TextField t = (TextField) e.getSource();

        try {
            val = Integer.parseInt(t.getText());
        } catch (Exception e1) {
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

        s1.setValue(r);
        s2.setValue(g);
        s3.setValue(b);

        p1.setBackground(new Color(r, 0, 0));
        p2.setBackground(new Color(0, g, 0));
        p3.setBackground(new Color(0, 0, b));
        p4.setBackground(new Color(r, g, b));
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        Scrollbar s = (Scrollbar) e.getSource();

        if (s == s1) {
            r = s1.getValue();
        }

        if (s == s2) {
            g = s2.getValue();
        }

        if (s == s3) {
            b = s3.getValue();
        }

        t1.setText("" + r);
        t2.setText("" + g);
        t3.setText("" + b);

        p1.setBackground(new Color(r, 0, 0));
        p2.setBackground(new Color(0, g, 0));
        p3.setBackground(new Color(0, 0, b));
        p4.setBackground(new Color(r, g, b));
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void error() {
    }

    public static void main(String args[]) {
        Frm22 a = new Frm22();
        a.error();
    }
}