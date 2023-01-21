//! Subclass in same package

package mypkg;

import java.io.*;

public class YNewAccount extends YAccount implements Serializable {
    int bal;
    boolean state;

    public YNewAccount() {
        super();
        bal = 0;
        state = true;
    }

    public String toString() {
        String s = super.toString() + "\nOpening Balance: " + bal + "\nState: " + state;
        return s;
    }

    public void display() {
        Util.display(toString());
    }

    public int getBal() {
        return bal;
    }

    public boolean getState() {
        return state;
    }

    public void delete() {
        state = false;
    }

    public void setData(int n) {
        super.setData(n);
        bal = Util.iInput("Balance: ");
        state = true;
    }
}