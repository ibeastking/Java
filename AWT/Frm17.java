import java.awt.*;
import java.awt.event.*;

class Frm17 extends Frame {
    int x, y, flg;
    Color cr;

    Frm17() {
        super("Mouse Button");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                int a = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                int c = (int) (Math.random() * 255);

                cr = new Color(a, b, c);

                if (e.getButton() == MouseEvent.BUTTON1) {
                    flg = 0;
                } else {
                    flg = 1;
                }

                draw();
            }
        });

        setSize(500, 500);
        setVisible(true);
    }

    void draw() {
        Graphics g;
        g = getGraphics();
        g.setColor(cr);

        if (flg == 0) {
            g.drawRect(x, y, 20, 20);
        } else {
            g.drawOval(x, y, 20, 20);
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm17 a = new Frm17();
        a.menu();
    }
}