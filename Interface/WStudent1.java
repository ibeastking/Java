import javax.swing.*;

interface Dataio {
    void setData(int n);

    void display();
}

class WStudent1 implements Dataio {
    int rno;
    String nm;
    double mrk;

    WStudent1() {
        rno = 0;
        nm = "";
        mrk = 0.0;
    }

    public String toString() {
        String s = "Roll Number: " + rno + "\nName: " + nm + "\nMarks: " + mrk;
        return s;
    }

    public void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    public void setData(int n) {
        rno = n;
        nm = JOptionPane.showInputDialog(null, "Enter Name: ");

        try {
            mrk = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Marks: "));
        } catch (Exception e) {
        }
    }

    int getNo() {
        return rno;
    }

    double getMarks() {
        return mrk;
    }

    public static void main(String args[]) {
        WStudent1 a = new WStudent1();

        a.setData(101);

        String s = "Roll Number: " + a.getNo() + "\nName: " + a.nm + "\nMarks: " + a.getMarks();

        JOptionPane.showMessageDialog(null, s);

        Dataio ref = new WStudent1();

        ref.setData(123);
        ref.display();
    }
}