import javax.swing.*;
import java.util.*;

interface Dataio {
    void setData(int n);

    void display();
}

interface GetData {
    int getNo();

    String getName();
}

interface Resultio {
    void setMarks();

    int size = 5;

    int total();

    int avg();

    void dispMarks();
}

class XStudent implements Dataio, GetData {
    int no;
    String nm;

    XStudent() {
        no = 0;
        nm = new String();
    }

    public String toString() {
        String s = "Roll Number: " + no + "\nName: " + nm;
        return s;
    }

    public void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return nm;
    }

    public void setData(int n) {
        no = n;

        nm = JOptionPane.showInputDialog(null, "Name: ");
    }
}

interface Istate {
    boolean getState();

    void setState(boolean b);
}

class XMarks extends XStudent implements Resultio {
    int mrk[];

    XMarks() {
        super();
        mrk = new int[5];
    }

    public void setMarks() {
        int i = 0;
        while (i < size) {
            try {
                mrk[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Marks: "));
            } catch (Exception e) {
                mrk[i] = 0;
            }

            i++;
        }
    }

    public int total() {
        int i = 1;
        int tot = mrk[0];

        while (i < size) {
            tot = tot + mrk[i];
        }

        return tot;
    }

    public int avg() {
        return total() / size;
    }

    public String toString() {
        String s = super.toString() + "Marks: " + Arrays.toString(mrk);

        return s;
    }

    public void dispMarks() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class XResult extends XMarks implements Istate {
    int tot;
    int avg;
    boolean state;

    XResult() {
        super();
        tot = 0;
        avg = 0;
        state = true;
    }

    public void setState(boolean b) {
        state = b;
    }

    public boolean getState() {
        return state;
    }

    void compute() {
        tot = total();
        avg = tot / 5;
    }

    public String toString() {
        String s = super.toString() + "\nTotal: " + tot + "\nAverage: " + avg + "\nState: " + state;

        return s;
    }
}

public class XRecord {
    public static void main(String args[]) {
        XResult a = new XResult();
        a.setData(101);
        a.setMarks();
        a.compute();

        JOptionPane.showMessageDialog(null, "\nRecord\n" + a);
    }
}
