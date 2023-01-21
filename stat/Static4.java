//! Implementation of matrix operation

import java.io.*;
import java.util.*;

class Static4 {
    static int x[][], y[][], z[][];
    static BufferedReader br;

    static {
        x = new int[3][3];
        y = new int[3][3];
        z = new int[3][3];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }
    }

    static void input(int a[][]) {
        int i = 0;
        int j = 0;

        while (i < 3) {
            j = 0;
            while (j < 3) {

                System.out.println("a[" + i + "][" + j + "]: ");

                try {
                    a[i][j] = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    continue;
                }
                j++;
            }
            i++;
        }
    }

    static void display(int a[][]) {
        int i = 0;
        System.out.println("Matrix: ");
        while (i < 3) {
            System.out.println(Arrays.toString(a[i]));
            i++;
        }
    }

    static void add() {
        int i = 0;
        int j = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                z[i][j] = x[i][j] + y[i][j];
            }
        }
    }

    static void subtract() {
        int i = 0;
        int j = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                z[i][j] = x[i][j] - y[i][j];
            }
        }
    }

    static void mul() {
        int i = 0;
        int j = 0;
        int k = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                for (k = 0; k < 3; k++) {
                    z[i][j] = z[i][j] + (x[i][k] * y[k][j]);
                }
            }
        }
    }

    public static void main(String args[]) {
        input(x);
        input(y);
        add();
        display(z);
        subtract();
        display(z);
        mul();
        display(z);
    }
}
