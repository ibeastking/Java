package mypkg;

import java.util.*;
import java.io.*;

public class YArray implements DataIO, Serializable {
    public int arr[];

    public YArray() {
        arr = new int[5];
    }

    public String toString() {
        String s = Arrays.toString(arr);
        return s;
    }

    public void display() {
        Util.display(toString());
    }

    public void setData() {
        int i = 0;
        for (i = 0; i < 5; i++) {
            try {
                arr[i] = Util.iInput("Enter Number");
            } catch (Exception e) {
            }
        }
    }
}
