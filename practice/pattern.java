import javax.swing.*;

class pattern {

    int n; // ! n stands for number of rows and columns
    String s = "";

    void pat() {

        try {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of rows and columns"));
        } catch (Exception e) {
        }

        if (n % 2 == 1) {
            int i = 1, j = 1;

            for (j = 1; j <= n; j++) {
                for (i = 1; i <= n; i++) {
                    if (((i + j) > (n / 2 - i)) && ((i + j) < (n / 2 + i))) {
                        s = s + "*";
                    } else {
                        s = s + " ";
                    }
                }
                s = s + "\n";
            }
        }

        System.out.println(s);
    }

    public static void main(String args[]) {
        pattern a = new pattern();
        a.pat();
    }
}