import javax.swing.*;
import java.util.*;

public class Result1 {
    int roll;
    int mark[];

    Result1() {
        roll = 0;
        mark = null;
    }

    void setdata(int n) {
        roll = n;
        int nos = 0, i = 0;

        try {
            nos = Integer.parseInt(JOptionPane.showInputDialog(null, "Subject Count: "));
        } catch (Exception e) {
            nos = 5;
        }

        mark = new int[nos];
        while (i < nos) {
            try {
                mark[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "marks: " + i));
            } catch (Exception e) {
                continue;
            }
            i++;
        }
    }

    int getn() {
        return roll;
    }

    int getname() {
        return mark.length;
    }

    int gettotal() {
        int tot = mark[0], i = 1;

        while (i < mark.length) {
            tot = tot + mark[i++];
        }
        return tot;
    }

    public String toString() {
        String a = "\nResult\nRoll Number: " + roll + "Marks: " + Arrays.toString(mark) + "Total: " + gettotal();
        return a;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    public static void main(String args[]) {

        Result1 p[] = new Result1[5];
        int i = 0, n = 0;

        while (i < 5) {
            p[i] = new Result1();
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog(null, "Roll Number: "));
            } catch (Exception e) {
                continue;
            }

            p[i].setdata(n);
            i++;
        }

        i = 0;
        while (i < 5) {
            p[i].display();
            i++;
        }
        JOptionPane.showMessageDialog(null, Arrays.toString(p));
    }
}
