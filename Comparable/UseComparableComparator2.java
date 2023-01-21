import javax.swing.*;
import java.util.*;

class XAccount implements Comparable<XAccount>, Comparator<XAccount> {
    int n;
    String nm;
    int amt;

    XAccount() {
        n = amt = 0;
        nm = new String();
    }

    XAccount(int a, String b, int c) {
        n = a;
        nm = b;
        amt = c;
    }

    public String toString() {
        String a = "\nAccount Number: " + n + "\nName: " + nm + "\nAmount: " + amt;
        return a;
    }

    void display() {
        System.out.println(toString());
    }

    void setData() {
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Roll Number: "));
            nm = JOptionPane.showInputDialog(null, "Name: ");
            amt = Integer.parseInt(JOptionPane.showInputDialog(null, "Amount: "));
        } catch (Exception e) {
        }
    }

    public int compareTo(XAccount p) {
        return (n - p.n);
    }

    public int compare(XAccount p, XAccount q) {
        return (p.nm).compareTo(q.nm);
    }

    public static Comparator<XAccount> Amt = new Comparator<XAccount>() {
        public int compare(XAccount p, XAccount q) {
            return (p.amt - q.amt);
        }
    };

    public static Comparator<XAccount> Balnm = new Comparator<XAccount>() {
        public int compare(XAccount p, XAccount q) {
            int res = p.amt - q.amt;

            if (res == 0) {
                return (p.nm).compareTo(q.nm);
            }
            return res;
        }
    };
}

class UseComparableComparator2 {
    public static void main(String args[]) {
        XAccount p[] = new XAccount[2];
        int i = 0;
        while (i < 2) {
            p[i] = new XAccount();
            p[i].setData();
            i++;
        }

        JOptionPane.showMessageDialog(null, Arrays.toString(p));
        Arrays.sort(p);
        JOptionPane.showMessageDialog(null, Arrays.toString(p));
        Arrays.sort(p, new XAccount());
        JOptionPane.showMessageDialog(null, Arrays.toString(p));
        Arrays.sort(p, XAccount.Amt);
        JOptionPane.showMessageDialog(null, Arrays.toString(p));
    }
}
