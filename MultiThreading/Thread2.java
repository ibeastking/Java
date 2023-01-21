class Thrd1 extends Thread {
    int n;

    Thrd1(String nm, int n) {
        super(nm); // * naming to the thread
        this.n = n;
        start();
    }

    public void run() {
        int i = 1;
        while (i <= n) {
            System.out.println("Thread " + (Thread.currentThread()).getName() + ": " + i);

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            i++;
        }
    }

    public void error() {
    }
}

class Thread2 {
    public static void main(String args[]) {
        System.out.println("Main Start");
        Thrd1 a = new Thrd1("A", 7);
        Thrd1 b = new Thrd1("B", 8);

        a.error();
        b.error();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println("Main Ends");
    }
}
