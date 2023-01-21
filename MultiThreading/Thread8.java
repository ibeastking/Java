import java.awt.*;
import java.awt.event.*;

class Thrd4 extends Thread {
    int x, y;
    Color cr;
    Graphics g;

    Thrd4(Frame frm) {
        super();

        g = frm.getGraphics();

        start();
    }

    public void run() {
        while (true) {
            x = (int) (Math.random() * 600);
            y = (int) (Math.random() * 600);

            cr = new Color((int) ((Math.random()) * 255), (int) ((Math.random()) * 255), (int) ((Math.random()) * 255));

            g.setColor(cr);
            g.fillOval(x, y, 20, 20);

            try {
                Thread.sleep(2000);
            } catch (Exception e1) {
            }
        }
    }
}

class Thrd5 extends Thread {
    int x, y;
    Color cr;
    Graphics g;

    Thrd5(Frame frm) {
        super();

        g = frm.getGraphics();

        start();
    }

    public void run() {
        while (true) {
            x = (int) (Math.random() * 600);
            y = (int) (Math.random() * 600);

            cr = new Color((int) ((Math.random()) * 255), (int) ((Math.random()) * 255), (int) ((Math.random()) * 255));

            g.setColor(cr);
            g.fillRect(x, y, 20, 20);

            try {
                Thread.sleep(3000);
            } catch (Exception e1) {
            }
        }
    }
}

class Thrd6 extends Thread {
    int x, y;
    Color cr;
    Graphics g;

    Thrd6(Frame frm) {
        super();

        g = frm.getGraphics();

        start();
    }

    public void run() {
        while (true) {
            x = (int) (Math.random() * 600);
            y = (int) (Math.random() * 600);

            cr = new Color((int) ((Math.random()) * 255), (int) ((Math.random()) * 255), (int) ((Math.random()) * 255));

            g.setColor(cr);
            g.drawString("Welcome", x, y);

            try {
                Thread.sleep(4000);
            } catch (Exception e1) {
            }
        }
    }
}

public class Thread8 extends Frame implements Runnable {

    Thrd4 a;
    Thrd5 b;
    Thrd6 c;

    boolean flag;

    Thread8() {
        super("Thread");
        flag = true;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (flag == true) {
                    tstart();
                    flag = false;
                } else {
                    tstop();
                    flag = true;
                }
            }
        });

        Thread th = new Thread(this);
        th.start();
        setSize(600, 600);
        setVisible(true);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(30000);
            } catch (Exception e) {
            }

            repaint();
        }
    }

    // ! method which starts the threads
    public void tstart() {
        a = new Thrd4(this);
        b = new Thrd5(this);
        c = new Thrd6(this);
    }

    public void tstop() {
        a.interrupt();
        b.interrupt();
        c.interrupt();
    }

    public void error() {
    }

    public static void main(String args[]) {
        Thread8 a = new Thread8();
        a.error();
    }
}