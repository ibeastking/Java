import javax.swing.*;
import java.util.*;

class XEmployee implements Comparable<XEmployee>, Comparator<XEmployee> {
    int n;
    String nm;
    int sal;

    XEmployee() {
        n = sal = 0;
        nm = new String();
    }

    public String toString() {
        String s = "\nEmployee Data\nNumber: " + n + "\nName: " + nm + "\nSalary: " + sal;
        return s;
    }

    void display() {
        System.out.println(toString());
    }

    void setData() {
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Roll Number: "));
            nm = JOptionPane.showInputDialog(null, "Name: ");
            sal = Integer.parseInt(JOptionPane.showInputDialog(null, "Salary: "));
        } catch (Exception e) {
        }
    }

    // * comparable method
    public int compareTo(XEmployee t) {
        return (n - t.n);
    }

    // * comparator method
    public int compare(XEmployee p, XEmployee q) {
        return (p.nm).compareTo(q.nm);
    }
}

class UseComparableComparator1 {
    public static void main(String args[]) {
        int i = 0;
        XEmployee k[] = new XEmployee[5];

        while (i < 5) {
            k[i] = new XEmployee();
            k[i].setData();
            i++;
        }

        JOptionPane.showMessageDialog(null, Arrays.toString(k));
        Arrays.sort(k);
        JOptionPane.showMessageDialog(null, Arrays.toString(k));
        Arrays.sort(k, new XEmployee());
        JOptionPane.showMessageDialog(null, Arrays.toString(k));
    }
}