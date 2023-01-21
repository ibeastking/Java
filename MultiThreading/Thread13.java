
class SharedObj {
    int data, flg;

    SharedObj() {
        data = 0;
        flg = 0;
    }

    synchronized void prod() {
        if (flg == 0) {
            flg = 1;
            try {
                wait();
            } catch (Exception e) {
            }
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        data = (int) (Math.random() * 100);
        notify();
    }

    synchronized void cons() {
        if (flg == 1) {
            notify();
        } else {
            flg = 1;
        }
        try {
            wait();
        } catch (Exception e) {
        }

        String s = "Table\n";

        for (int i = 1; i < 11; i++) {
            s = s + " " + (data * i);
        }

        System.out.println(s);
    }
}

class CThread1 extends Thread {

    SharedObj obj;

    CThread1(SharedObj a) {
        super();
        obj = a;
        start();
    }

    public void run() {
        obj.prod();
    }
}

class CThread2 extends Thread {

    SharedObj obj;

    CThread2(SharedObj a) {
        super();
        obj = a;
        start();
    }

    public void run() {
        obj.cons();
    }
}

class Thread13 {
    public static void main(String args[]) {

        System.out.println("Main Thread Begins\n");

        SharedObj a = new SharedObj();

        // * irrespect of the order in which we declare the output comes
        // * we can declare t1 first and then t2, still the output comes same
        CThread2 t2 = new CThread2(a);
        CThread1 t1 = new CThread1(a);

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }

        System.out.println("\nMain Ends");
    }
}