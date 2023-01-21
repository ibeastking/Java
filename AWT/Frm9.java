import java.awt.*;
import java.awt.event.*;

class Frm9 extends Frame implements ActionListener, FocusListener, WindowListener {
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button ba, bs, bm, bd, bc;
    Panel p1, p2;
    int v1, v2, res;
    char opr;

    Frm9() {
        super("Calculation");
        l1 = new Label("Value 1");
        l2 = new Label("Value 2");
        l3 = new Label("Result");

        t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);

        t3.setEditable(false);

        t1.addFocusListener(this);
        t2.addFocusListener(this);

        p1 = new Panel();
        p1.setLayout(new GridLayout(3, 2, 5, 5));

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);

        add(p1, BorderLayout.CENTER);

        ba = new Button("+");
        bs = new Button("-");
        bd = new Button("/");
        bc = new Button("C");
        bm = new Button("*");

        ba.addActionListener(this);
        bs.addActionListener(this);
        bc.addActionListener(this);
        bd.addActionListener(this);
        bm.addActionListener(this);

        p2 = new Panel();
        p2.add(ba);
        p2.add(bs);
        p2.add(bm);
        p2.add(bd);
        p2.add(bc);

        add(p2, BorderLayout.SOUTH);
        addWindowListener(this);
        setSize(400, 300);
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

    void comp() {
        switch (opr) {
            case '+':
                res = v1 + v2;
                break;
            case '-':
                res = v1 - v2;
                break;
            case '*':
                res = v1 * v2;
                break;
            case '/':
                res = v1 / v2;
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        opr = (e.getActionCommand()).charAt(0);

        if (opr != 'C') {
            comp();
            t3.setText(res + " ");
        }

        t1.requestFocus();
    }

    public void focusGained(FocusEvent e) {
        TextField t = (TextField) e.getSource();

        if (t == t1) {
            ba.setEnabled(false);
            bs.setEnabled(false);
            bm.setEnabled(false);
            bd.setEnabled(false);
            bc.setEnabled(false);
        }
    }

    public void focusLost(FocusEvent e) {
        TextField t = (TextField) e.getSource();

        if (t == t1) {
            try {
                v1 = Integer.parseInt(t1.getText());
            } catch (Exception e1) {
                t1.setText("0");
                t1.requestFocus();
                return;
            }
        } else {
            try {
                v2 = Integer.parseInt(t2.getText());
            } catch (Exception e2) {
                t2.setText("0");
                t2.requestFocus();
                return;
            }

            ba.setEnabled(true);
            bs.setEnabled(true);
            bm.setEnabled(true);
            bd.setEnabled(true);
            bc.setEnabled(true);
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm9 a = new Frm9();
        a.menu();
    }
}