
//! if the user is using a third party made class then we don't know if the method is synchronized or not so we use this approach for third party classes

//? synchronized code block
//? synchronized code statement
class shared2 {

    void table(int n) {
        int i = 1;
        System.out.println("\nTable");

        for (i = 1; i < 11; i++) {
            System.out.println("Thread " + (Thread.currentThread()).getName() + " " + n * i + " ");
        }
    }
}

class Thread11 extends Thread {
    shared2 sh;
    int n;

    Thread11(shared2 sh, int no) {
        super();

        this.sh = sh;
        n = no;
        start();
    }

    public void run() {
        synchronized (sh) {
            sh.table(n);
        }
    }

    public static void main(String args[]) {
        shared2 obj = new shared2();
        Thread11 a = new Thread11(obj, 5);
        Thread11 b = new Thread11(obj, 7);
        Thread11 c = new Thread11(obj, 9);

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