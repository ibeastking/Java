//! Waiting for thread child to die

class Thrd3 extends Thread {
    int n;

    Thrd3(String nm, int n) {
        super(nm); // * naming to the thread
        this.n = n;
        start();
    }

    public void run() {
        int i = 1;
        while (i <= 10) {
            System.out.println("" + (n * i));

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

class Thread4 {
    public static void main(String args[]) {
        System.out.println("Main Start");
        Thrd3 a = new Thrd3("O", 18);
        Thrd3 b = new Thrd3("M", 27);

        a.error();
        b.error();

        try {
            // * allows the thread childs to die and then complete the main function
            a.join();
            b.join();
        } catch (Exception e) {
        }

        System.out.println("Main Ends");
    }
}
