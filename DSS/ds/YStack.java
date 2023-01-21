package ds;

import mypkg.YArray;
import mypkg.Util;

public class YStack extends YArray implements iData, Total {
    int top;

    public YStack() {
        super();
        top = -1;
    }

    public int get(int pos) {
        return arr[pos];
    }

    public void set(int pos, int d) {
        arr[pos] = d;
    }

    public void push(int d) {
        if (top == size - 1) {
            Util.dInput("Overflow");
        } else {
            set(++top, d);
        }
    }

    public int pop() {
        return arr[top--];
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public String toString() {
        String s = "Stack";

        if (isEmpty()) {
            s = s + "Empty";
        } else {
            for (int i = top; i >= 0; i--) {
                s = s + " " + get(i);
            }
        }

        return s;
    }

    public void display() {
        Util.display(toString());
    }

    public int total() {
        int i = 0;
        int sum = 0;
        for (i = 0; i < 5; i++) {
            sum = sum + arr[i];
        }

        return sum;
    }

    public double average() {
        return (total() / 5);
    }

    public void menu() {
        String choice[] = new String[] { "Push", "Pop", "Display", "Total", "Average", "Exit" };

        int opt = 0;

        while (true) {
            opt = Util.oInput("Stack", "Choose", choice);

            if (opt == 5) {
                break;
            }
            switch (opt) {
                case 0:
                    if (isFull()) {
                        Util.display("Full Stack");
                    } else {
                        push(Util.iInput("Data"));
                    }
                    break;

                case 1:
                    if (isEmpty()) {
                        Util.display("Empty Stack");
                    } else {
                        Util.display("Popped: " + pop());
                    }
                    break;
                case 2:
                    display();
                case 3:
                    Util.display("Sum of the Stack: " + total());
                    break;
                case 4:
                    Util.display("Average of the Stack: " + average());
                    break;
            }

        }
    }
}
