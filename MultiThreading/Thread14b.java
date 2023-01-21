//! Quick Sort

import javax.swing.*;

class QuickSortb implements Runnable {
    int left, right;
    static int arr[];

    QuickSortb(int a, int b) {
        left = a;
        right = b;
    }

    static {
        arr = new int[10];
    }

    QuickSortb() {
        left = 0;
        right = 9;
    }

    void input() {
        int i = 0;
        for (i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number"));
        }
    }

    void display() {
        String str = "Data: ";
        for (int i = 0; i < 10; i++) {
            str = str + " " + arr[i];
        }

        JOptionPane.showMessageDialog(null, str);
    }

    void pivot() {
        if (arr[left] > arr[right]) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public void run() {
        Quick();
    }

    synchronized int partition() {
        pivot();
        int i = left, j = right + 1, k = arr[i];

        do {
            do {
                ++i;
            } while (arr[i] < k);

            do {
                --j;
            } while (arr[j] > k);

            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        } while (i < j);

        int temp = arr[j];
        arr[j] = arr[left];
        arr[left] = temp;
        return j;
    }

    synchronized void Quick() {
        int pos;

        if (left < right) {
            pos = partition();
            Thread th1 = new Thread(new QuickSortb(left, pos));
            th1.start();

            try {
                th1.join();
            } catch (Exception e1) {
            }

            Thread th2 = new Thread(new QuickSortb(pos + 1, right));
            th2.start();

            try {
                th2.join();
            } catch (Exception e2) {
            }
        }
    }
}

public class Thread14b {
    public static void main(String args[]) {
        QuickSortb a = new QuickSortb();

        a.input();
        a.display();

        Thread th = new Thread(a);
        th.start();

        try {
            th.join();
        } catch (Exception e) {
        }

        a.display();
    }
}