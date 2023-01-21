import java.awt.*;
import java.awt.event.*;

class Thread7 extends Frame implements Runnable {
    int x, y;

    boolean flag;

    Thread th;
    Thread7 obj;

    Thread7() {
        super("MThread");

        obj = this;

        flag = true;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (flag == true) {
                    th = new Thread(obj);
                    flag = false;
                    th.start();
                } else {
                    flag = true;
                    th.interrupt();
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(500, 500);
        setVisible(true);
    }

    public void run() {
        draw();
    }

    void draw() {
        Graphics g = getGraphics();
        while (true) {
            x = (int) (Math.random() * 480);
            y = (int) (Math.random() * 480);

            g.drawOval(x, y, 20, 20);

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }

    void error() {
    }

    public static void main(String[] args) {
        Thread7 a = new Thread7();
        a.error();
    }

}