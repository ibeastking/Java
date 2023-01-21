import javax.swing.*;
import java.util.*;

class UseStack {
    static Stack<Integer> s;

    static {
        s = new Stack<Integer>();
    }

    public static void push() {
        int n = 0;
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Data"));
        } catch (Exception e) {
            return;
        }
        s.push(n);
    }

    public static void pop() {
        if (s.empty()) {
            JOptionPane.showMessageDialog(null, "Empty Stack");
        } else {
            JOptionPane.showMessageDialog(null, "Data: " + s.pop());
        }
    }

    public static void display() {
        String str = "Stack ";

        if (s.empty()) {
            str = str + "Empty";
        } else {
            str = str + "\n" + s;
        }
        JOptionPane.showMessageDialog(null, str);
    }

    public static void menu() {
        String choice[] = new String[] { "push", "pop", "display", "exit" };

        int opt = 0;

        while (true) {
            opt = JOptionPane.showOptionDialog(null, "Choose 1", "Stack", JOptionPane.YES_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 0);

            if (opt == 3) {
                break;
            } else {
                switch (opt) {
                    case 0:
                        push();
                        break;
                    case 1:
                        pop();
                        break;
                    case 2:
                        display();
                        break;
                }
            }
        }
    }

    public static void main(String args[]) {
        menu();
    }
}