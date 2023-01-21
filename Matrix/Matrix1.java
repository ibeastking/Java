import java.io.*;
import java.util.*;

class Matrix1 {
    public static void main(String args[]) {
        BufferedReader br = null;

        int x[][] = new int[3][3];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }

        int i = 0, j = 0;

        while (i < 3) {
            j = 0;
            while (j < 3) {
                System.out.print("x[" + i + "][" + j + "]: ");
                try {
                    x[i][j] = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    continue;
                }
                j++;
            }
            i++;
        }

        String s = "Matrix\n";
        i = 0;

        while (i < 3) {
            s = s + Arrays.toString(x[i]) + "\n";
            i++;
        }

        System.out.println(s);
    }
}