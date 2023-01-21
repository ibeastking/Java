import java.io.*;

class Array1 {
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

        String str = "Array\n";

        for (i = 0; i < x.length; i++) {
            str = str + x[i] + " ";
        }

        System.out.println(str);
    }
}
