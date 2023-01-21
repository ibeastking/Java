import java.io.*;
import java.util.*;

class Static2 {
    static int x[];

    static BufferedReader br;

    static {
        x = new int[5];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }
    }

    static void display() {
        System.out.println("Array: " + Arrays.toString(x));
    }

    static void input() {
        int i = 0;

        while (i < 5) {
            System.out.print("Enter Number: ");

            try {
                x[i] = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                continue;
            }
            i++;
        }
    }

    public static void main(String args[]) {
        input();
        display();
    }
}