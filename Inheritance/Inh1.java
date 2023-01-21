import javax.swing.*;

class Base {
    int no;

    Base() {
        no = 0;
    }

    Base(int a) {
        no = a;
    }

    void setData() {
        try {
            no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: "));
        } catch (Exception e) {
        }
    }

    void setData(int a) {
        no = a;
    }

    int getData() {
        return no;
    }

    public String toString() {
        String s = "Number: " + no;
        return s;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class Result22 extends Base {
    double mrk;

    Result22() {
        super();
        mrk = 0.0;
    }

    Result22(int a, double b) {
        super(a);
        mrk = b;
    }

    void setData() {
        super.setData();
        try {
            mrk = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Marks: "));
        } catch (Exception e) {
        }
    }

    void setData(int a) {
        no = a;
        try {
            mrk = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Marks: "));
        } catch (Exception e) {
        }
    }

    public String toString() {
        String s = super.toString() + "\nMarks: " + mrk;
        return s;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class Inh1 {
    public static void main(String args[]) {
        Base a = new Base();
        a.setData();
        a.display();
        Result22 b = new Result22();
        b.setData(101);
        b.display();
    }
}