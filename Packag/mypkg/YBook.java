package mypkg;

import java.io.*;

public class YBook implements Serializable {
    int bno;
    String bnm;
    double bprice;
    boolean state;

    public YBook() {
        bno = 0;
        bnm = new String();
        bprice = 0.0;
        state = true;
    }

    public String toString() {
        String s = "\nBook Number: " + bno + "\nBook Name: " + bnm + "\nBook Price: " + bprice + "\nBook State: "
                + state;
        return s;
    }

    public void display() {
        Util.display(toString());
    }

    public void setData(int n) {
        bno = n;
        bnm = Util.sInput("Enter Book Name: ");
        bprice = Util.dInput("Enter Book Price: ");
        state = true;
    }

    public void setData() {
        bno = Util.iInput("Enter Book Number: ");
        bnm = Util.sInput("Enter Book Name: ");
        bprice = Util.dInput("Enter Book Price: ");
        state = true;
    }

    public int getNo() {
        return bno;
    }

    public boolean getState() {
        return state;
    }

    public void delete() {
        state = false;
    }

    public double getPrice() {
        return bprice;
    }

    public String getName() {
        return bnm;
    }
}
