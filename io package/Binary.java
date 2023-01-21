import java.io.*;

class Binary {
    public static void main(String args[]) {
        int n = 0, cnt = 0;

        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        } catch (Exception e) {
        }

        System.out.println("Enter number: ");
        try {
            n = Integer.parseInt(br.readLine());
            int length = (int) (Math.log10(n) + 1);

            while (n > 0) {
                if (n % 10 == 0 || n % 10 == 1) {
                    cnt++;
                }
                n = n / 10;
            }

            if (cnt == length) {
                System.out.println("The Inputted number is binary.");
            } else {
                System.out.println("The Inputted number is not binary.");
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }
}
