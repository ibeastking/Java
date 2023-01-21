import javax.swing.*;
import java.util.*;

class XBook implements Comparable<XBook> {
    int bno;
    String bnm;
    int bprice;

    XBook() {
        bno = bprice = 0;
        bnm = new String();
    }

    public String toString() {
        String s = "Book Data\nNumber: " + bno + "\nName: " + bnm + "\nPrice: " + bprice;
        return s;
    }

    void display() {
        System.out.println(toString());
    }

    void setData(int n) {
        bno = n;
        try {
            bnm = JOptionPane.showInputDialog(null, "Name");
            bprice = Integer.parseInt(JOptionPane.showInputDialog(null, "Price"));
        } catch (Exception e) {}
    }

    public int compareTo(XBook k) {
        return (bno - k.bno);
    }
}

public class UseComparable1 {
    public static void main(String args[]) {
        XBook a[] = new XBook[5];
        int no = 0;

        for (int i = 0; i < 5; i++) {
            a[i] = new XBook();
            try {
                no = Integer.parseInt(JOptionPane.showInputDialog(null, "Book Number: "));
            } catch (Exception e) {
            }

            a[i].setData(no);
        }
        JOptionPane.showMessageDialog(null, Arrays.toString(a));

        Arrays.sort(a);
        JOptionPane.showMessageDialog(null, Arrays.toString(a));

    }
}
