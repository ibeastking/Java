import java.io.*;

class Kbd4 {
    public static void main(String args[]) {
        int n = 0, i = 1;
        int max = 0;

        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        } catch (Exception e) {
        }

        while (i < 11) {
            System.out.println("Enter data: ");

            try {

                n = Integer.parseInt(br.readLine());

            } catch (Exception e) {
                System.out.println("Invalid Input");
                continue; // * continue does not increment i but asks user to input again
            }

            if (i == 1) {
                max = n;
            } else {
                if (max < n) {
                    max = n;
                }
            }

            i++;
        }

        System.out.println("The Largest number is " + max);
    }
}
