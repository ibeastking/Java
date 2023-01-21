package ds;

import mypkg.YArray;

public class NewYArray extends YArray implements NewDataIO {
    public NewYArray() {
        super();
    }

    public int total() {
        int i = 1, tot = arr[0];

        while (i < 5) {
            tot = tot + arr[i++];
        }

        return tot;
    }

    public int avg() {
        return total() / 5;
    }
}