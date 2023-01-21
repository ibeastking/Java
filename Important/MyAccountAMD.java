import java.io.*;
import java.util.*;
import mypkg.Util;

class MyAccount implements Serializable {
    int n;
    String nm;
    int opnbal;
    boolean state;
    LinkedList<Integer> tls;

    MyAccount() {
        n = 0;
        opnbal = 0;
        nm = new String();
        state = true;
        tls = new LinkedList<Integer>();
    }

    int getNo() {
        return n;
    }

    int getOpnBal() {
        return opnbal;
    }

    boolean getState() {
        return state;
    }

    int balance() {
        int tot = opnbal;
        int i = 0, n = tls.size();

        while (i < n) {
            tot = tot + tls.get(i);
            i++;
        }

        return tot;
    }

    void delete() {
        tls.add(-balance());
        state = false;
    }

    void depo() {
        int amt = Util.iInput("Deposit Amount");

        if (amt <= 0) {
            return;
        }
        tls.add(amt);
    }

    void with() {
        int bal = balance();
        int amt = Util.iInput("WithDraw Amount");

        if (bal - amt <= 500) {
            return;
        }

        tls.add(-amt);
    }

    public String toString() {
        String s = "Account Number: " + n + "\nAccount Holder Name: " + nm + "\nOpening Balance: " + opnbal
                + "\nTransactions\n" + tls + "\nCurrent Balance: " + balance() + "\nState: " + state;
        return s;
    }

    void display() {
        Util.display(toString());
    }

    void setData(int n) {
        this.n = n;
        nm = Util.sInput("\nName: ");
        opnbal = Util.iInput("\nOpening Balance: ");
        state = true;
    }
}

class MyAccountAMD {
    LinkedList<MyAccount> ls;
    MyAccount obj;

    MyAccountAMD() {
        ls = new LinkedList<MyAccount>();
    }

    int search(int no) {
        int i = 0, n = ls.size();

        while (i < n) {
            obj = ls.get(i);
            if (obj.getNo() == no) {
                break;
            }
            i++;
        }

        if (i == n) {
            obj = null;
            return -1;
        } else {
            return i;
        }
    }

    void add() {
        int no = Util.iInput("Account Number");
        if (no <= 0) {
            return;
        }

        if (search(no) >= 0) {
            Util.display("Record Already Exist");
            return;
        }

        obj = new MyAccount();
        obj.setData(no);

        ls.add(obj);
    }

    void mod() {
        int no = Util.iInput("Account Number");
        if (no <= 0) {
            return;
        }

        if (search(no) == -1) {
            Util.display("Record Not Found");
            return;
        }

        if (obj.getState() == false) {
            Util.display("Record Deleted");
            return;
        }

        obj.setData(no);
    }

    void del() {
        int no = Util.iInput("Account Number");
        if (no <= 0) {
            return;
        }

        if (search(no) == -1) {
            Util.display("Record Not Found");
            return;
        }

        if (obj.getState() == false) {
            Util.display("Record Already Deleted");
            return;
        }

        obj.delete();
    }

    void deposit() {
        int no = Util.iInput("Account Number");
        if (no <= 0) {
            return;
        }

        if (search(no) == -1) {
            Util.display("Record Not Found");
            return;
        }

        if (obj.getState() == false) {
            Util.display("Record Already Deleted");
            return;
        }

        obj.depo();
    }

    void withdraw() {
        int no = Util.iInput("Account Number");
        if (no <= 0) {
            return;
        }

        if (search(no) == -1) {
            Util.display("Record Not Found");
            return;
        }

        if (obj.getState() == false) {
            Util.display("Record Deleted");
            return;
        }

        obj.with();
    }

    void write() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("acc.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ls);
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    void read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("acc.dat");
            ois = new ObjectInputStream(fis);

            ls = (LinkedList<MyAccount>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

    void displayAll() {
        int i = 0, n = ls.size();

        while (i < n) {
            obj = ls.get(i);
            obj.display();
            i++;
        }
    }

    void menu() {
        String[] choice = new String[] { "Add", "Modify", "Delete", "Deposit", "Withdraw", "Search", "Display All",
                "Exit" };

        int opt = 0, no = 0, pos = 0;

        read(); // ! method used to read all the previously inputted data in file acc.dat

        while (true) {
            opt = Util.oInput("Account Data", "Enter Option", choice);

            if (opt == 7) {
                break;
            }

            switch (opt) {
                case 0:
                    add();
                    break;
                case 1:
                    mod();
                    break;
                case 2:
                    del();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    no = Util.iInput("Account Number");
                    pos = search(no);

                    if (pos == -1) {
                        Util.display("Record Not Found");
                    } else {
                        obj.display();
                    }
                case 6:
                    displayAll();
                    break;
            }
        }

        write(); // ! method used to write the inputted data to the acc.dat file from the current
                 // porgram
    }

    public static void main(String args[]) {
        MyAccountAMD a = new MyAccountAMD();
        a.menu();
    }
}