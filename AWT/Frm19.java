//! Draw images on panel

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

class MyPanel extends Panel {
    Image img;

    MyPanel() {
        super();
    }

    void setImage(Image i) {
        img = i;
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 200, 200, this);
    }
}

class Frm19 extends Frame {

    Image img;
    MyPanel pan;

    Frm19() {
        super("Iamge");

        try {
            img = (Image) ImageIO.read(new File("chart.jpeg"));
        } catch (Exception e) {
        }

        pan = new MyPanel();

        add(pan, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pan.setImage(img);
        setSize(400, 400);
        setVisible(true);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm19 a = new Frm19();
        a.menu();
    }
}