import java.awt.*;
import java.awt.event.*;

class Frm25 extends Frame implements KeyListener {
    String str;
    Color bcr, fcr;
    Font fnt;
    int size, style;

    Frm25() {
        super("Key Listener");

        str = "BEASTKING";
        style = Font.PLAIN;
        size = 10;
        fnt = new Font("Serif", style, size);

        bcr = new Color(255, 255, 255);
        fcr = new Color(0, 0, 0);

        addKeyListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {

        fnt = new Font("serif", style, size);
        g.setFont(fnt);
        setBackground(bcr);
        g.setColor(fcr);
        g.drawString(str, 100, 100);
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_2) {
            style = Font.BOLD;
        }

        if (e.getKeyCode() == KeyEvent.VK_3) {
            style = Font.ITALIC;
        }

        if (e.getKeyCode() == KeyEvent.VK_4) {
            style = Font.PLAIN;
        }

        if (e.getKeyCode() == KeyEvent.VK_5) {
            int r, g, b;
            r = (int) ((Math.random()) * 255);
            b = (int) ((Math.random()) * 255);
            g = (int) ((Math.random()) * 255);
            bcr = new Color(r, g, b);
        }

        if (e.getKeyCode() == KeyEvent.VK_6) {
            int r, g, b;
            r = (int) ((Math.random()) * 255);
            b = (int) ((Math.random()) * 255);
            g = (int) ((Math.random()) * 255);

            fcr = new Color(r, g, b);
        }

        if (e.getKeyCode() == KeyEvent.VK_7) {
            size++;
        }

        if (e.getKeyCode() == KeyEvent.VK_8) {
            size--;
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        str = str + e.getKeyChar();
        repaint();
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm25 a = new Frm25();
        a.menu();
    }
}
