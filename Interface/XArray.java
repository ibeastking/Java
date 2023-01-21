import javax.swing.*;
import java.util.*;

interface Isize {
    int size = 5;
}

interface Dataio {
    void setData();

    void display();
}

interface Icomp {
    int total();

    int avg();
}

interface Isearch {
    void sort();

    int search(int sv);
}

interface Iarray extends Isize, Dataio, Icomp, Isearch {
    int findmin();

    int findmax();
}

class XArray implements Iarray {
    int arr[];

    XArray() {
        arr = new int[size];
    }

    public void sort() {
        Arrays.sort(arr);
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    public void setData() {
        int i = 0;

        while (i < size) {
            try {
                arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Data: "));
            } catch (Exception e) {
                continue;
            }
            i++;
        }
    }

    public int total() {
        int tot = arr[0], i = 1;

        while (i < size) {
            tot = tot + arr[i];
            i++;
        }

        return tot;
    }

    public int avg() {
        return total() / size;
    }

    public int search(int sv) {
        sort();

        return Arrays.binarySearch(arr, sv);
    }

    public int findmax() {
        int max = arr[0], i = 1;

        while (i < size) {
            if (arr[i] > max) {
                max = arr[i];
            }
            i++;
        }
        return max;
    }

    public int findmin() {
        int min = arr[0], i = 1;

        while (i < size) {
            if (arr[i] < min) {
                min = arr[i];
            }
            i++;
        }

        return min;
    }

    public static void main(String args[]) {
        XArray p = new XArray();
        p.setData();
        p.display();
        p.sort();
        p.display();

        String s = p.toString() + "\nTotal" + p.total() + "\nAverage" + p.avg() + "\nMinimun" + p.findmin()
                + "\nMaximum" + p.findmax();

        JOptionPane.showMessageDialog(null, s);
    }
}