//! Mouse Interface

import java.awt.*;
import java.awt.event.*;

class Frm12 extends Frame implements MouseListener {
    String str;
    int x, y;

    Frm12() {
        super("Mouse Listener");
        str = "";

        addMouseListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void mouseEntered(MouseEvent e) {
        str = "Entered";
        x = 100;
        y = 100;
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        str = "Exited";
        x = 100;
        y = 100;
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        str = "Pressed";
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        str = "Clicked";
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        str = "Released";
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(str, x, y);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm12 a = new Frm12();
        a.menu();
    }
}