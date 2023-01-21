import java.util.*;
import javax.swing.*;

class Employee {
    int eno = 0;
    String enm = "";
    double esal = 0.0;
    boolean estate;

    Employee() {
        eno = 0;
        enm = new String();
        esal = 0.0;
        estate = true;
    }

    boolean getState() {
        return estate;
    }

    int getNumber() {
        return eno;
    }

    String getName() {
        return enm;
    }

    double getSalary() {
        return esal;
    }

    void delete() {
        estate = false;
    }

    public String toString() {
        String s = "\nEmployee Data\nEmployee Number: " + eno + "\nEmployee Name: " + enm + "\nEmployee Salary: " + esal
                + "\nState: " + estate;
        return s;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }

    void setData(int no) {
        eno = no;
        enm = JOptionPane.showInputDialog(null, "Employee Name: ");

        try {
            esal = Double.parseDouble(JOptionPane.showInputDialog(null, "Employee Salary: "));
        } catch (Exception e) {
            esal = 0.0;
        }
        estate = true;
    }
}

public class EmployeeAMD {
    LinkedList<Employee> ls;
    Employee ref;

    EmployeeAMD() {
        ls = new LinkedList<Employee>();
        ref = null;
    }

    // * if the function returns -1 the record is not found
    int search(int no) {
        int i = 0, n = ls.size(), pos = -1;

        while (i < n) {
            ref = ls.get(i);
            if (ref.getNumber() == no) {
                pos = i;
                break;
            }
            i++;
        }

        if (i == n) {
            ref = null;
        }
        return pos;
    }

    void add() {
        int no = 0;
        try {
            no = Integer.parseInt(JOptionPane.showInputDialog(null, "Employee Number: "));
        } catch (Exception e) {
            return;
        }

        int pos = search(no);

        if (pos >= 0) {
            JOptionPane.showMessageDialog(null, "Record Found");
            return;
        }

        ref = new Employee();
        ref.setData(no);
        ls.add(ref);
    }

    void mod() {
        int no = 0, pos = 0;

        try {
            no = Integer.parseInt(JOptionPane.showInputDialog(null, "Employee Number: "));
        } catch (Exception e) {
            return;
        }

        pos = search(no);

        if (pos == -1 || ref.getState() == false) {
            JOptionPane.showMessageDialog(null, "Invalid Record");
            return;
        }

        ref.setData(no);
    }

    void del() {
        int no = 0, pos = 0;

        try {
            no = Integer.parseInt(JOptionPane.showInputDialog(null, "Employee Number: "));
        } catch (Exception e) {
            return;
        }

        pos = search(no);

        if (pos == -1 || ref.getState() == false) {
            JOptionPane.showMessageDialog(null, "Invalid Record");
            return;
        }

        ref.delete();
    }

    void display() {
        int i = 0, n = ls.size();

        while (i < n) {
            ref = ls.get(i);
            ref.display();
            i++;
        }
    }

    void menu() {
        int opt = 0, no = 0, pos = 0;
        String a[] = new String[] { "Add", "Modify", "Delete", "Display", "Search", "Exit" };

        while (true) {
            opt = JOptionPane.showOptionDialog(null, "Choose Option", "Employee Record",
                    JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, a, 0);

            if (opt == 5) {
                break;
            }
            switch (opt) {
                case 0:
                    add();
                    JOptionPane.showMessageDialog(null, "Record Added");
                    break;
                case 1:
                    mod();
                    JOptionPane.showMessageDialog(null, "Record Modified");
                    break;
                case 2:
                    del();
                    JOptionPane.showMessageDialog(null, "Record Deleted");
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    try {
                        no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Employee Number: "));
                    } catch (Exception e) {
                        continue;
                    }
                    pos = search(no);
                    if (pos == -1) {
                        JOptionPane.showMessageDialog(null, "Record Not Found");
                    } else {
                        ref.display();
                    }
                    break;
            }
        }
    }

    public static void main(String args[]) {
        EmployeeAMD p;
        p = new EmployeeAMD();
        p.menu();
    }

}
