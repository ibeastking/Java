import javax.swing.*;
import java.util.*;

class OptionPaneDemo {
    public static void main(String args[]) {
        int x[] = new int[5];
        int i = 0, tot = 0, avg = 0;

        while (i < 5) {
            try {
                x[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number: "));
            } catch (Exception e) {
                continue;
            }
            tot = tot + x[i];
            i++;
        }

        avg = tot / x.length;

        String s = "Data\n" + Arrays.toString(x) + "\nTotal: " + tot + "\nAverage: " + avg;

        JOptionPane.showMessageDialog(null, s);
    }
}