import java.io.*;
import java.util.*;

public class Matrix3 {
    public static void main(String args[]) {
        BufferedReader br = null;

        String opt[] = new String[5];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        }

        int i = 0;
        while (i < 5) {
            System.out.println("City Name: ");
            try {
                opt[i] = br.readLine();
            } catch (Exception e) {
            }
            i++;
        }

        System.out.println(Arrays.toString(opt));
        Arrays.sort(opt);
        System.out.println(Arrays.toString(opt));
    }
}
