//! Asynchronized Threads

public class Thread9 extends Thread {
    int no;

    Thread9(int n) {
        super();

        no = n;
    }

    void tstart() {
        start();
    }

    void table() {
        int i = 1;
        for (i = 1; i < 11; i++) {
            System.out.println("Thread " + (Thread.currentThread()).getName() + " " + no * i + " ");
        }
    }

    public void run() {
        table();
    }

    public void error() {
    }

    public static void main(String args[]) {
        System.out.println("Main Thread Starts");
        Thread9 a = new Thread9(5);
        Thread9 b = new Thread9(7);
        Thread9 c = new Thread9(9);

        a.tstart();
        b.tstart();
        c.tstart();

        // ! This join method is used just so that all the threads die before printing
        // ! the Main Thread Ends message
        try {
            a.join();
            b.join();
            c.join();
        } catch (Exception e) {
        }

        System.out.println("Main Thread Ends");
        a.error();
        b.error();
        c.error();
    }
}
