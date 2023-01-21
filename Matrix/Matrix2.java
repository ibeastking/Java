import java.io.*;
import java.util.*;

class Matrix2 {
    public static void main(String args[]) {
        BufferedReader br = null;
        int x[][] = null;

        x = new int[3][];

        int i = 0, j = 0;

        for (i = 0; i < 3; i++) {
            x[i] = new int[i + 1];
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
            } catch (Exception e) {
            }
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < x[i].length; j++) {
                System.out.println("x[" + i + "][" + j + "]: ");

                try {
                    x[i][j] = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    continue;
                }
            }
        }

        String s = "Matrix\n";

        for (i = 0; i < 3; i++) {
            s = s + Arrays.toString(x[i]) + "\n";
        }

        System.out.println(s);
    }
}