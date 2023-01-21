import javax.swing.*;

abstract class MyArray {
    int arr[];
    static final int size = 5;

    MyArray() {
        arr = new int[size];
    }

    void set(int pos, int d) {
        arr[pos] = d;
    }

    int get(int pos) {
        return arr[pos];
    }

    public String toString() {
        String s = "Data: ";
        return s;
    }

    abstract void menu();
}

class MyStack extends MyArray {
    int top;

    MyStack() {
        super();
        top = -1;
    }

    boolean isEmpty() {
        return (top == -1);
    }

    boolean isFull() {
        return (top == size - 1);
    }

    void push(int d) {
        set(++top, d);
    }

    void pop() {
        top--;
    }

    public String toString() {
        String a = "Stack : ";

        if (isEmpty()) {
            a = a + "Empty";
        } else {
            for (int i = top; i >= 0; i--) {
                a = a + get(i) + " ";
            }
        }

        return a;
    }

    void menu() {
        String option[] = new String[] { "push", "pop", "display", "Exit" };

        int opt = 0, d = 0;

        while (true) {
            opt = JOptionPane.showOptionDialog(null, "Choose Option", "stack", JOptionPane.YES_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, option, 0);

            if (opt == 3) {
                break;
            } else {
                switch (opt) {
                    case 0:
                        if (isFull()) {
                            JOptionPane.showMessageDialog(null, "Overflow");
                        } else {
                            try {
                                d = Integer.parseInt(JOptionPane.showInputDialog(null, "Data: "));
                            } catch (Exception e) {
                            }

                            push(d);
                        }
                        break;
                    case 1:
                        if (isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Underflow");
                        } else {
                            pop();
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, toString());
                }
            }
        }
    }
}

class MyQueue extends MyArray {
    int fr, rr;

    MyQueue() {
        super();
        rr = -1;
        fr = 0;
    }

    void insert() {
        if (rr == size - 1) {
            JOptionPane.showMessageDialog(null, "Overflow");
            return;
        }
        int d = 0;
        try {
            d = Integer.parseInt(JOptionPane.showInputDialog(null, "Data: "));
        } catch (Exception e) {
        }

        set(++rr, d);
    }

    void remque() {
        if (rr < fr) {
            JOptionPane.showMessageDialog(null, "UnderFlow");
            return;
        }
        fr++;
    }

    void display() {
        String str = "Queue";

        if (rr < fr) {
            str = str + " Empty";
        } else {
            for (int i = fr; i <= rr; i++) {
                str = str + " " + get(i);
            }
        }

        JOptionPane.showMessageDialog(null, str);
    }

    void menu() {
        String option[] = new String[] { "insert", "remove", "display", "Exit" };
        int opt;

        while (true) {

            opt = JOptionPane.showOptionDialog(null, "Choose Option", "Queue", JOptionPane.YES_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, option, 0);

            if (opt == 3) {
                break;
            } else {
                switch (opt) {
                    case 0:
                        insert();
                        break;
                    case 1:
                        remque();
                        break;
                    case 2:
                        display();
                        break;
                }
            }

        }
    }
}

class DS {
    public static void main(String args[]) {
        String option[] = new String[] { "Stack", "Queue", "Exit" };

        int opt = 0;
        MyArray obj = null;

        while (true) {
            opt = JOptionPane.showOptionDialog(null, "Choose Option", "Data Structure", JOptionPane.YES_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, option, 0);

            if (opt == 2) {
                break;
            } else {
                switch (opt) {
                    case 0:
                        obj = new MyStack();
                        obj.menu();
                        break;
                    case 1:
                        obj = new MyQueue();
                        obj.menu();
                        break;
                }
            }
        }
    }
}