//! Draw rectangle

import java.awt.*;
import java.awt.event.*;

public class Frm14 extends Frame implements MouseListener {

    Color cr;
    int x, y;

    Frm14() {
        super("Moved");
        addMouseListener(this);

        cr = Color.RED;

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);

        cr = new Color(r, g, b);
        Graphics obj = getGraphics();
        obj.setColor(cr);
        obj.drawRect(x, y, 20, 20);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm14 a = new Frm14();
        a.menu();
    }
}
