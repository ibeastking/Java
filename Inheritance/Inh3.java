import javax.swing.*;

abstract class Aclass {
    abstract void setData();
    abstract void display();
}

class MyNumber extends Aclass {
    int no;

    MyNumber() {
        no = 0;
    }

    void setData() {
        try {
            no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: "));
        } catch (Exception e) {
        }
    }

    public String toString() {
        String s = "Number: " + no;
        return s;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class MyName extends MyNumber {
    String nm;

    MyName() {
        super();
        nm = new String();
    }

    void setData() {
        super.setData();
        nm = JOptionPane.showInputDialog(null, "Enter Name: ");
    }

    public String toString() {
        String k = super.toString() + "\nName: " + nm;
        return k;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

class Inh3 {
    public static void main(String args[]) {
        Aclass ref = new MyNumber();
        ref.setData();
        ref.display();

        ref = new MyName();
        ref.setData();
        ref.display();
    }
}