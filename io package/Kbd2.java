import java.io.*;

class Kbd2 {
    public static void main(String args[]) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        int n = 0, i = 1;

        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        } catch (Exception e) {
        }
        System.out.println("Enter number: ");
        String str = "Table\n";

        try {
            n = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Invalid Format");
            return;
        }

        while (i < 11) {
            str = str + (n * i) + " ";
            i++;
        }

        System.out.println(str);
    }
}
