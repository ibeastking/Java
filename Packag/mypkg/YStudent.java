package mypkg;

import java.io.*;

public class YStudent implements Serializable {
    int n;
    String nm;
    double mrk;
    boolean state;

    public YStudent() {
        n = 0;
        nm = new String();
        mrk = 0.0;
        state = true;
    }

    public String toString() {
        String s = "Roll Number: " + n + "\nName: " + nm + "\nMarks: " + mrk + "\nState: " + state;
        return s;
    }

    public void display() {
        Util.display(toString());
    }

    public void setData(int n) {
        this.n = n;
        nm = Util.sInput("Name");
        mrk = Util.dInput("Marks");
        state = true;
    }

    public void setData() {
        n = Util.iInput("Roll Number");
        nm = Util.sInput("Name");
        mrk = Util.dInput("Marks");
        state = true;
    }

    public int getNo() {
        return n;
    }

    public boolean getState() {
        return state;
    }

    public void delete() {
        state = false;
    }

    public double getMarks() {
        return mrk;
    }

    public String getName() {
        return nm;
    }
}