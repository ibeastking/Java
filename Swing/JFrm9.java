import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;

//! Book class which has display method
class Book implements Serializable {
    int bno;
    String bname;
    int bprice;
    boolean bstate;

    Book() {
        bno = 0;
        bprice = 0;
        bname = new String();
        bstate = true;
    }

    Book(int a, String b, int c) {
        bno = a;
        bname = b;
        bprice = c;
        bstate = true;
    }

    void delete() {
        bstate = false;
    }

    public String toString() {
        String a = "Book Data\nBook Number: " + bno + "\nBook Name: " + bname + "\nBook Price: " + bprice
                + "\nBook State: " + bstate;
        return a;
    }

    void display() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

// ! class contains methods like add, modify, delete, save and load
class BookAMD {
    LinkedList<Book> ls;
    Book ref;

    BookAMD() {
        ls = new LinkedList<Book>();
        ref = null;
    }

    void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("book.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(ls);
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    void load() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("book.dat");
            ois = new ObjectInputStream(fis);

            ls = (LinkedList<Book>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
        }
    }

    boolean search(int no) {
        int i = 0, n = ls.size();
        ref = null;

        while (i < n) {
            ref = ls.get(i);

            if (ref.bno == no) {
                break;
            }
            i++;
        }

        if (i == n) {
            ref = null;
            return false;
        }

        return true;
    }

    void add(int a, String b, int c) {
        ref = new Book(a, b, c);
        ls.add(ref);
    }

    void mod(int a, String b, int c) {
        ref.bname = b;
        ref.bprice = c;
    }

    void del(int a, String b, int c) {
        ref.delete();
    }
}

// ! Addition Class
class BAdd extends JDialog implements ActionListener, FocusListener {
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    int no, price;
    String nm;

    BookAMD bk;

    BAdd(JFrame frm, String title, BookAMD bk, boolean state) {
        super(frm, title, state);

        this.bk = bk;

        l1 = new JLabel("BNumber");
        l2 = new JLabel("BName");
        l3 = new JLabel("BPrice");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b2 = new JButton("Exit");
        b2.addActionListener(this);

        t1.addFocusListener(this);
        t3.addFocusListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);

        setSize(400, 400);
    }

    public void focusGained(FocusEvent e) {

    }

    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField) e.getSource();

        if (t == t1) {
            try {
                no = Integer.parseInt(t1.getText());
            } catch (Exception e1) {
                t1.requestFocus();
                return;
            }

            if (bk.search(no) == true) {
                t1.requestFocus();
                return;
            }
        }

        if (t == t3) {
            try {
                price = Integer.parseInt(t3.getText());
            } catch (Exception e2) {
                t3.requestFocus();
                return;
            }

            if (price >= 0) {
                t3.requestFocus();
                return;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == b1) {
            nm = t2.getText();
            bk.add(no, nm, price);
        }

        t1.setText("");
        t2.setText("");
        t3.setText("");

        setVisible(false);
    }
}

// ! Modification class
class BMod extends JDialog implements ActionListener, FocusListener {
    int no;
    String nm;
    int price;

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    BookAMD bk;

    BMod(JFrame frm, String title, BookAMD bk, boolean state) {
        super(frm, title, state);
        this.bk = bk;

        l1 = new JLabel("BNumber");
        l2 = new JLabel("BName");
        l3 = new JLabel("BPrice");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        b1 = new JButton("Modify");
        b1.addActionListener(this);
        b2 = new JButton("Exit");
        b2.addActionListener(this);

        t1.addFocusListener(this);
        t3.addFocusListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);

        setSize(400, 400);
    }

    public void focusGained(FocusEvent e) {

    }

    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField) e.getSource();

        if (t == t1) {
            try {
                no = Integer.parseInt(t1.getText());
            } catch (Exception e1) {
                t1.requestFocus();
                return;
            }

            if (bk.search(no) == false) {
                t1.requestFocus();
                return;
            }

            // ! if book is deleted, then do not allow for modification of the record
            if (bk.ref.bstate == false) {
                t1.requestFocus();
                return;
            }
        }

        if (t == t3) {
            try {
                price = Integer.parseInt(t3.getText());
            } catch (Exception e2) {
                t3.requestFocus();
                return;
            }

            if (price <= 0) {
                t3.requestFocus();
                return;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == b1) {
            nm = t2.getText();

            bk.mod(no, nm, price);
        }

        t1.setText("");
        t2.setText("");
        t3.setText("");

        setVisible(false);
    }
}

// ! Deletion class
class BDel extends JDialog implements ActionListener, FocusListener {
    int no;
    String nm;
    int price;

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    BookAMD bk;

    BDel(JFrame frm, String title, BookAMD bk, boolean state) {
        super(frm, title, state);
        this.bk = bk;

        l1 = new JLabel("BNumber");
        l2 = new JLabel("BName");
        l3 = new JLabel("BPrice");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        t2.setEditable(false);
        t3.setEditable(false);

        b1 = new JButton("Delete");
        b1.addActionListener(this);
        b2 = new JButton("Exit");
        b2.addActionListener(this);

        t1.addFocusListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);

        setSize(400, 400);
    }

    public void focusGained(FocusEvent e) {

    }

    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField) e.getSource();

        if (t == t1) {
            try {
                no = Integer.parseInt(t1.getText());
            } catch (Exception e1) {
                t1.requestFocus();
                return;
            }

            if (bk.search(no) == false) {
                t1.requestFocus();
                return;
            }

            // ! if book is deleted, then do not allow for modification of the record
            if (bk.ref.bstate == false) {
                t1.requestFocus();
                return;
            }

            t2.setText(bk.ref.bname);
            t3.setText("" + bk.ref.bprice);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == b1) {
            nm = t2.getText();
            bk.del(no, nm, price);
        }

        t1.setText("");
        t2.setText("");
        t3.setText("");

        setVisible(false);
    }
}

// ! class which contains display and print option to save the file offline
class BKDisplay extends JDialog implements ActionListener {
    JButton b1;
    LinkedList<Book> ls;
    Book ref;
    JTable jt;
    String bno, bnm, bpr, bst;
    DefaultTableModel dtm;

    String colhead[] = new String[] { "Number", "Name", "Price", "State" };
    Object arr[][] = null;

    BKDisplay(JFrame f, String title, BookAMD bk, boolean state) {
        super(f, title, state);
        ls = bk.ls;
        dtm = new DefaultTableModel(arr, colhead);
        int i = 0, n = ls.size();

        while (i < n) {
            ref = ls.get(i);

            bno = ref.bno + "";
            bnm = ref.bname + "";
            bpr = ref.bprice + "";
            bst = ref.bstate + "";

            dtm.insertRow(i++, new String[] { bno, bnm, bpr, bst });
        }

        jt = new JTable(dtm);
        b1 = new JButton("Print");
        b1.addActionListener(this);

        add(new JScrollPane(jt), BorderLayout.CENTER);
        add(b1, BorderLayout.SOUTH);
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            jt.print();
        } catch (Exception e1) {
        }
    }
}

// ! main class

public class JFrm9 extends JFrame implements ActionListener {
    BookAMD bk;
    BKDisplay bkd;

    BAdd da;
    BMod dm;
    BDel dd;

    JMenuBar mb;
    JMenu mf, mr, mv, mx;
    JMenuItem mfl, mfs;
    JMenuItem mra, mrm, mrd, mvd, mxn, mxy;
    // ? mra stands for add, mrm stands for modify, mrd stands for delete
    // ?mvd stands for display all, mxn stands for no and mxy stands for yes

    JFrm9(String s) {

        // ! call to constructor of JFrame
        super(s);

        bk = new BookAMD();

        mfl = new JMenuItem("Load");
        mfs = new JMenuItem("Save");

        mfl.addActionListener(this);
        mfs.addActionListener(this);

        mf = new JMenu("File");
        mf.add(mfl);
        mf.add(mfs);

        mra = new JMenuItem("Add");
        mrm = new JMenuItem("Modify");
        mrd = new JMenuItem("Delete");
        mra.addActionListener(this);
        mrm.addActionListener(this);
        mrd.addActionListener(this);

        mr = new JMenu("Record");
        mr.add(mra);
        mr.add(mrm);
        mr.add(mrd);

        mvd = new JMenuItem("Display All");
        mvd.addActionListener(this);

        mv = new JMenu("View");
        mv.add(mvd);

        mxn = new JMenuItem("No");
        mxy = new JMenuItem("Yes");
        mxn.addActionListener(this);
        mxy.addActionListener(this);

        mx = new JMenu("Exit");
        mx.add(mxn);
        mx.add(mxy);

        mb = new JMenuBar();
        mb.add(mf);
        mb.add(mr);
        mb.add(mv);
        mb.add(mx);

        setJMenuBar(mb); // ! remember
        setSize(520, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem b = (JMenuItem) e.getSource();

        if (b == mra) {
            da = new BAdd(this, "Add", bk, true);
            da.setVisible(true);
        }

        if (b == mrm) {
            dm = new BMod(this, "Modify", bk, true);
            dm.setVisible(true);
        }

        if (b == mrd) {
            dd = new BDel(this, "Delete", bk, true);
            dd.setVisible(true);
        }

        if (b == mvd) {
            bkd = new BKDisplay(this, "Display", bk, true);
            bkd.setVisible(true);
        }

        if (b == mxy) {
            System.exit(0);
        }

        if (b == mfl) {
            bk.load();
        }

        if (b == mfs) {
            bk.save();
        }
    }

    public void error() {
    }

    public static void main(String args[]) {
        JFrm9 a = new JFrm9("Book");
        a.error();
    }
}
