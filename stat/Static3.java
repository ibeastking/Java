import java.io.*;
import java.util.*;

class Static3 {
    static BufferedReader br;
    static int x[][];

    static {
        x = new int[3][3];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }
    }

    static void input() {

        int i = 0;
        int j = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.println("Enter the number: ");

                try {
                    x[i][j] = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

    static void display() {
        int i = 0;
        for (i = 0; i < 3; i++)

        {
            System.out.println("Arrays: " + Arrays.toString(x[i]));

        }
    }

    public static void main(String args[]) {
        input();
        display();
    }
}