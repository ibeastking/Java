import java.awt.*;
import java.awt.event.*;

public class Frm15 extends Frame {
    int x, y, w, h, flg;
    Color cr;

    Frm15() {
        super("Mouse");
        flg = 0;
        cr = new Color(255, 0, 0);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (flg == 0) {
                    x = e.getX();
                    y = e.getY();
                    flg = 1;
                } else {
                    w = e.getX() - x;
                    h = e.getY() - y;
                    repaint();
                }
            }
        });

        setSize(500, 500);
        setVisible(true);
    }

    public void paint(Graphics g) {

        if (flg == 1) {
            int a = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            int c = (int) (Math.random() * 255);

            cr = new Color(a, b, c);
            g.setColor(cr);
            g.drawRect(x, y, w, h);
            flg = 0;
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm15 a = new Frm15();
        a.menu();
    }
}
