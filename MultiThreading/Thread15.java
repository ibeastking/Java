
import java.awt.*;
import java.awt.event.*;

class Ball extends Thread {
    Panel pan;
    static final int xsize = 10;
    static final int ysize = 10;
    int x, y, dx, dy;
    Color cr;

    Ball(Panel pan) {
        super();
        this.pan = pan;
        x = 0;
        dx = dy = 2;
        y = (int) (Math.random() * 400);
        cr = new Color(((int) (Math.random() * 255)), ((int) (Math.random() * 255)), ((int) (Math.random() * 255)));
        start();
    }

    public void run() {
        while (true) {
            move();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    void move() {
        Graphics g = pan.getGraphics();
        g.setColor(Color.WHITE);
        g.fillOval(x, y, xsize, ysize);
        x = x + dx;
        y = y + dy;
        g.setColor(cr);
        g.fillOval(x, y, xsize, ysize);

        Dimension d = pan.getSize();

        if (x < 0) {
            x = 0;
            dx = -dx;
        }

        if (x + xsize >= d.width) {
            x = d.width - xsize;
            dx = -dx;
        }

        if (y < 0) {
            y = 0;
            dy = -dy;
        }

        if (y + ysize >= d.height) {
            y = d.height - ysize;
            dy = -dy;
        }
    }
}

public class Thread15 extends Frame implements ActionListener {
    Panel p, q;
    Button b1, b2;

    Thread15() {
        super("Bouncing Ball");
        p = new Panel();
        q = new Panel();

        b1 = new Button("Start");
        b2 = new Button("Exit");
        b1.addActionListener(this);
        b2.addActionListener(this);

        q.add(b1);
        q.add(b2);

        add(p, BorderLayout.CENTER);
        add(q, BorderLayout.SOUTH);

        setSize(600, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == b2) {
            System.exit(0);
        }

        if (b == b1) {
            Ball a = new Ball(p);
        }
    }

    public static void main(String args[]) {
        Thread15 a = new Thread15();
    }
}