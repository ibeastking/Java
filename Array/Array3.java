import java.io.*;
import java.util.*;

class Array3 {
    public static void main(String args[]) {
        int i = 0;
        int[] x = new int[5];
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }

        while (i < 5) {
            System.out.println("Enter data: ");
            try {
                x[i] = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                continue;
            }
            i++;
        }

        System.out.println("Data: " + Arrays.toString(x));
        Arrays.sort(x);

        System.out.println("Data: " + Arrays.toString(x));

        int sv = 0, res = 0;

        try {
            System.out.println("Enter Search Value: ");
            sv = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            return;
        }

        res = Arrays.binarySearch(x, sv);

        System.out.println("Number: " + res);

        if (res == -1) {
            System.out.println("\nNot found");
        } else {
            System.out.println("\nFound");
        }
    }
}