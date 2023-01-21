package mypkg;

import java.io.*;

public class YAccount implements Serializable {
    int n;
    String nm;
    double bal;
    boolean state;

    public YAccount() {
        n = 0;
        nm = new String();
    }

    public String toString() {
        String s = "Account Number: " + n + "\nAccount Name: " + nm;
        return s;
    }

    public void setData(int a) {
        n = a;
        nm = Util.sInput("Enter Name: ");
    }

    public void setData() {
        n = Util.iInput("Enter Number: ");
        nm = Util.sInput("Enter Name: ");
    }

    public void display() {
        Util.display(toString());
    }

    public int getNo() {
        return n;
    }

    public String getName() {
        return nm;
    }
}
