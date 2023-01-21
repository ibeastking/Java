import java.util.*;

class Pps1 {
    public static void main(String args[]) {
        String val = new String("I am On 6 ajit 7 oato");
        int v = 0;
        Scanner s = new Scanner(val);
        System.out.println("\nEnter String: ");

        while (s.hasNext()) {
            v = s.nextInt();
            System.out.println(v + " ");
        }
        s.close();
    }
}
