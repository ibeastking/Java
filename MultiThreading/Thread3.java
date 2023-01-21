//! Printing the table of two numbers using threads

class Thrd2 extends Thread {
    int n;

    Thrd2(String nm, int n) {
        super(nm); // * naming to the thread
        this.n = n;
        start();
    }

    public void run() {
        int i = 1;
        while (i <= 10) {
            System.out.println(" " + (n * i));

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

class Thread3 {
    public static void main(String args[]) {
        System.out.println("Main Start");
        Thrd2 a = new Thrd2("O", 18);
        Thrd2 b = new Thrd2("M", 27);

        a.error();
        b.error();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println("Main Ends");
    }
}
