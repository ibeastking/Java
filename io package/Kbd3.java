//! Program to calculate character count

import java.io.*;

class Kbd3 {
    public static void main(String args[]) {
        int i = 1, n = 0, pc = 0, nc = 0, zc = 0, oc = 0;

        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        } catch (Exception e) {
        }

        String str = "";

        while (i < 11) {
            System.out.println("Enter value: ");
            try {
                n = Integer.parseInt(br.readLine());
                if (n > 0) {
                    pc++;
                } else {
                    if (n < 0) {
                        nc++;
                    } else {
                        if (n == 0) {
                            zc++;
                        }
                    }
                }
            } catch (Exception e) {

                oc++;
            }
            str = str + n + " ";
            i++;
        }

        System.out.println(
                "Positive Count: " + pc + "\nNegative Count: " + nc + "\nZero Count: " + zc + "\nOther Count: " + oc);
    }
}
