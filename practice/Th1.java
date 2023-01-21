
import javax.swing.*;

class share1 {

    synchronized void sum(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("Thread " + (Thread.currentThread()).getName() + " -> " + n * i);
        }
    }
}

class Th1 extends Thread {
    share1 obj;
    int n;

    Th1(share1 obj, int n) {
        super();
        this.obj = obj;
        this.n = n;
        start();
    }

    public void run() {
        obj.sum(n);
    }

    public static void main(String args[]) {
        share1 obj = new share1();
        Th1 a = new Th1(obj, Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: ")));
        Th1 b = new Th1(obj, Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: ")));
        Th1 c = new Th1(obj, Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: ")));

        try {
            a.join();
            b.join();
            c.join();
        } catch (Exception e) {
        }
    }
}