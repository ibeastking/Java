import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class Shape implements Serializable {
    int x, y;
    Color cr;
    int shp;

    Shape(int x, int y, Color cr, int shp) {
        this.x = x;
        this.y = y;
        this.cr = cr;
        this.shp = shp;
    }

    void paint(Graphics g) {
        g.setColor(cr);

        switch (shp) {
            case 1:
                g.drawRect(x, y, 20, 20);
                break;
            case 2:
                g.drawOval(x, y, 20, 20);
        }
    }
}

class Frm16 extends Frame {

    int x, y, shp;
    Color cr;
    LinkedList<Shape> ls;

    Shape obj;

    Frm16() {
        super("Paint 1");
        ls = new LinkedList<Shape>();
        shp = 1;

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                open();
            }

            public void windowDeiconified(WindowEvent e) {
                repaint();
            }

            public void windowClosing(WindowEvent e) {
                close();
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
                obj = new Shape(x, y, cr, shp);
                ls.add(obj);
                repaint();
            }
        });

        setSize(500, 500);
        setVisible(true);
    }

    public void paint(Graphics g) {
        int i = 0, n = ls.size();

        while (i < n) {
            obj = ls.get(i);
            obj.paint(g);
            i++;
        }
    }

    public void open() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("shp.dat");
            ois = new ObjectInputStream(fis);
            ls = (LinkedList<Shape>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

    public void close() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("shp.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ls);
            fos.close();
            oos.close();
        } catch (Exception e) {
        }
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm16 a = new Frm16();
        a.menu();
    }
}