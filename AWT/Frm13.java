//! mouse motion

import java.awt.*;
import java.awt.event.*;

class Frm13 extends Frame implements MouseListener, MouseMotionListener {

    String str;
    int x, y;

    Frm13() {
        super("Mouse");
        str = "";

        addMouseListener(this);
        addMouseMotionListener(this);
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

    public void mouseMoved(MouseEvent e) {
        str = "Moved";
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        str = "Dragged";
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
        Frm13 a = new Frm13();
        a.menu();
    }
}