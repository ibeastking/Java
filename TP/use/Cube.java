package use;

import javax.swing.*;

public class Cube extends Thread {
    int n;
    String s = "";

    public Cube() {
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number: "));
        s = s + "Cube\n";
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            s = s + (i * i * i) + " ";
        }
        JOptionPane.showMessageDialog(null, s);
    }
}
