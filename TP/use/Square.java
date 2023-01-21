package use;

import javax.swing.*;

public class Square extends Thread {
    int n;
    String s = "Sqaures\n";

    public Square() {
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: "));
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            s = s + (i * i) + " ";
        }
        JOptionPane.showMessageDialog(null, s);
    }
}
