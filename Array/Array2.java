import java.io.*;
import java.util.*;

class Array2 {
    public static void main(String args[]) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }

        int[] x = new int[5];

        int i = 0;

        while (i < x.length) {
            System.out.print("x[" + i + "]: ");

            try {
                x[i] = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                continue;
            }
            i++;
        }

        int tot = 0;
        while (i < x.length) {
            tot = tot + x[i];
            i++;
        }

        int avg = tot / x.length;

        String s = "Data\n" + Arrays.toString(x) + "\nTotal: " + tot + "\nAverage: " + avg;

        System.out.println(s);

    }
}