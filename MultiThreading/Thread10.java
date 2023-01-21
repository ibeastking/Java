
//! if the user has defined the class, then we need to use this method because we can use the keyword the synchronized for every method we want to synchronize

//? the class name need not be compulsory named shared
//? it is a user defined class
class shared {
    synchronized void table(int n) {
        int i = 1;
        System.out.println("\nTable");

        for (i = 1; i < 11; i++) {
            System.out.println("Thread " + (Thread.currentThread()).getName() + " " + n * i + " ");
        }
    }
}

class Thread10 extends Thread {
    shared sh;
    int n;

    Thread10(shared sh, int no) {
        super();

        this.sh = sh;
        n = no;
        start();
    }

    public void run() {
        sh.table(n);
    }

    public static void main(String args[]) {
        shared obj = new shared();
        Thread10 a = new Thread10(obj, 5);
        Thread10 b = new Thread10(obj, 7);
        Thread10 c = new Thread10(obj, 9);

        System.out.println("Main Thread starts");

        try {
            a.join();
            b.join();
            c.join();
        } catch (Exception e) {
        }

        System.out.println("Main Thread ends");
    }
}