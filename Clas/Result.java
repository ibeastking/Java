import javax.swing.*;
import java.util.*;

public class Result {
    int roll;
    int mark[];

    Result() {
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
        String a = "Result\nRoll Number: " + roll + "\nMarks: " + Arrays.toString(mark) + "\nTotal: " + gettotal();
        return a;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    public static void main(String args[]) {
        Result r = new Result();
        r.setdata(1032);
        r.display();
    }
}
