import javax.swing.*;

//! class SNumber which is the super class
class SNumber {
    int no;

    SNumber() {
        no = 0;
    }

    SNumber(int a) {
        no = a;
    }

    public String toString() {
        String s = "\nNumber: " + no;
        return s;
    }

    int getNumber() {
        return no;
    }

    void setData(int a) {
        no = a;
    }

    void setData() {
        try {
            no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Roll number: "));
        } catch (Exception e) {
        }
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class SName extends SNumber {
    String nm;

    SName() {
        super();
        nm = new String();
    }

    SName(int a, String b) {
        super(a);
        nm = b;
    }

    public String toString() {
        String s = super.toString() + "\nName: " + nm;
        return s;
    }

    String getName() {
        return nm;
    }

    void setData(int a, String b) {
        // * we can use no=a also but we are using super
        super.setData(a);
        nm = b;
    }

    void setData(int a) {
        super.setData(a);
        nm = JOptionPane.showInputDialog(null, "\nName: ");
    }

    void setData() {
        super.setData();
        nm = JOptionPane.showInputDialog(null, "\nName: ");
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class SResult extends SName {
    double mrk;

    SResult() {
        super();
        mrk = 0.0;
    }

    SResult(int a, String b, double c) {
        super(a, b);
        mrk = c;
    }

    public String toString() {
        String s = super.toString() + "\nMarks: " + mrk;
        return s;
    }

    double getMarks() {
        return mrk;
    }

    void setData(int a, String b, double c) {
        no = a;
        nm = b;
        mrk = c;
    }

    void setData(int a) {
        super.setData(a);
        try {
            mrk = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter marks: "));
        } catch (Exception e) {
        }
    }

    void setData() {
        super.setData();
        try {
            mrk = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter marks: "));
        } catch (Exception e) {
        }
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class Inh2 {
    public static void main(String args[]) {
        SNumber ref = null;
        ref = new SNumber();

        ref.setData();
        ref.display();

        JOptionPane.showMessageDialog(null, "SName");

        ref = new SName();
        ref.setData();
        ref.display();

        JOptionPane.showMessageDialog(null, "SResult");

        ref = new SResult();
        ref.setData();
        ref.display();
    }
}
