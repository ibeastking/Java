import java.util.*;

class Scanner2 {
    public static void main(String args[]) {
        String str = new String("12 16 8 24 9");
        Scanner s = new Scanner(str);

        System.out.println("Data: ");
        int val = 0, tot = 0;

        while (s.hasNextInt()) {
            val = s.nextInt();
            System.out.println(val + " ");
            tot = tot + val;
        }

        System.out.println("Total: " + tot);
        s.close();
    }
}