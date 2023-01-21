import javax.swing.*;

class Student {
    int n;
    String name;
    double mark;

    Student() {
        n = 0;
        name = new String();
        mark = 0.0;
    }

    Student(int a, String b, double c) {
        n = a;
        name = b;
        mark = c;
    }

    public String toString() {
        String s = "Roll Number: " + n + "\nName: " + name + "\nMarks: " + mark;
        return s;
    }

    int getn() {
        return n;
    }

    String getname() {
        return name;
    }

    double getmark() {
        return mark;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    void setdata(int no) {
        n = no;
        name = JOptionPane.showInputDialog(null, "Name: ");
        try {
            mark = Double.parseDouble(JOptionPane.showInputDialog(null, "Marks: "));
        } catch (Exception e) {
            mark = 0.0;
        }
    }

    public static void main(String args[]) {
        Student s = null;
        s = new Student(); // * instance creation
        s.setdata(101);
        s.display();
        Student t = s;
        JOptionPane.showMessageDialog(null, "Data\n" + t);
    }
}