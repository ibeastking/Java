import javax.swing.*;
import java.util.*;

public class Book1 {
    int bno;
    String bnm;
    double bprice;
    boolean bstate;

    Book1() {
        bno = 0;
        bprice = 0.0;
        bstate = true;
        bnm = new String();
    }

    boolean getstate() {
        return bstate;
    }

    int getno() {
        return bno;
    }

    String getnm() {
        return bnm;
    }

    double getprice() {
        return bprice;
    }

    public String toString() {
        String a = "\nBook Data\nNumber: " + bno + "\nName: " + bnm + "\nPrice: " + bprice + "\nState: " + bstate;
        return a;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    void delRecord() {
        bstate = false;
    }

    void setData(int no) {
        bno = no;
        bnm = JOptionPane.showInputDialog(null, "Book Name: ");

        try {
            bprice = Double.parseDouble(JOptionPane.showInputDialog(null, "Price: "));
        } catch (Exception e) {
            bprice = 0.0;
        }
        bstate = true;
    }

    public static void main(String args[]) {
        LinkedList<Book1> a = new LinkedList<Book1>();

        Book1 b = new Book1();

        b.setData(101);
        a.add(b);

        Book1 c = new Book1();
        c.setData(102);
        a.add(c);

        b.setData(103);
        a.add(b);

        JOptionPane.showMessageDialog(null, "Data: " + a);
    }
}