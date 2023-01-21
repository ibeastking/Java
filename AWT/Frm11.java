import java.awt.*;
import java.awt.event.*;

class Frm11 extends Frame implements ActionListener {
    int v1, v2, res, flag;
    char opr, ch;
    String p, q;
    TextField t1;
    Panel r;
    Button btn[];

    Frm11() {
        super("Calculator");
        p = new String();
        q = new String();

        t1 = new TextField(10);
        t1.setEditable(false);

        add(t1, BorderLayout.NORTH);
        String cap[] = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "C", "=", "/" };

        r = new Panel();
        r.setLayout(new GridLayout(4, 4, 5, 5));
        btn = new Button[16];

        for (int i = 0; i < 16; i++) {
            btn[i] = new Button(cap[i]);
            btn[i].addActionListener(this);
            r.add(btn[i]);
        }

        add(r, BorderLayout.CENTER);
        flag = 0;

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setVisible(true);
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
        ch = (e.getActionCommand()).charAt(0);

        if (ch == 'C') {
            flag = 0;
            p = "";
            q = "";

            t1.setText("");
            return;
        }

        if (ch == '=') {
            if (flag == 1) {
                try {
                    v2 = Integer.parseInt(t1.getText());
                } catch (Exception e1) {
                }

                comp();
                t1.setText(res + "");
                flag = 0;
                p = "";
                q = "";
            }
            return;
        }

        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            if (flag == 0) {
                try {
                    v1 = Integer.parseInt(t1.getText());
                } catch (Exception e1) {
                }

                opr = ch;
                flag = 1;
            } else {
                try {
                    v2 = Integer.parseInt(t1.getText());
                } catch (Exception e1) {
                }

                comp();
                v1 = res;
                t1.setText(v1 + " ");
                opr = ch;
            }
            p = "";
            q = "";
            return;
        }

        p = p + ch;
        t1.setText(p);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm11 a = new Frm11();
        a.menu();
    }
}
