import java.util.*;

class Scanner1 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int val = s.nextInt();

        System.out.println("Data: " + val);
        s.close();
    }
}