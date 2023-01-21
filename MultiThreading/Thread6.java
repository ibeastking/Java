import java.awt.*;

class Thread6 extends Frame implements Runnable {
    int x, y;
    Color cr;

    Thread6() {
        super("Thread");
        Thread th = new Thread(this);
        setSize(500, 500);
        setVisible(true);
        th.start();
    }

    public void run() {
        Draw();
    }

    void Draw() {
        while (true) {
            x = (int) (Math.random() * 480);
            y = (int) (Math.random() * 480);
            cr = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            Graphics g = getGraphics();
            g.setColor(cr);
            g.drawOval(x, y, 20, 20);
            try {
                Thread.sleep(12000);
            } catch (Exception e) {
            }
        }
    }

    void error() {
    }

    public static void main(String[] args) {
        Thread6 a = new Thread6();
        a.error();
    }
}