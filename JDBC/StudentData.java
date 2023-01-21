
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class StuDialog extends JDialog implements ActionListener, FocusListener {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    int rno, tno, tcap;
    String snm, tnm;
    JButton b1, b2;
    String action;
    ResultSet rs, rt;
    Connection con;
    PreparedStatement pss, pst;
    PreparedStatement psa, psm, psd;
    boolean res;

    StuDialog(JFrame f, String t, boolean v, Connection c) {
        super(f, t, v);
        con = c;
        action = t;

        l1 = new JLabel("Roll Number");
        l2 = new JLabel("Name");
        l3 = new JLabel("Trade ID");
        l4 = new JLabel("Trade Name");
        l5 = new JLabel("Trade Cap");

        t1 = new JTextField(10);
        t1.addActionListener(this);
        t2 = new JTextField(30);
        t2.addActionListener(this);
        t3 = new JTextField(10);
        t3.addFocusListener(this);
        t4 = new JTextField(30);
        t5 = new JTextField(10);
        t4.setEditable(false);
        t5.setEditable(false);

        b1 = new JButton(action);
        b1.addActionListener(this);
        b2 = new JButton("Back");
        b2.addActionListener(this);

        setLayout(new GridLayout(6, 2, 5, 5));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(b1);
        add(b2);

        try {
            pss = con.prepareStatement("select * from Student where rollno = ?");
            pst = con.prepareStatement("select * from trade where tid = ?");
            psa = con.prepareStatement("insert into Student values(?,?,?");
            psm = con.prepareStatement("update student set sname=?,tid=? where rollno=?");
            psd = con.prepareStatement("delete from student where rollno=?");
        } catch (Exception e) {
        }
    }

    public void focusGained(FocusEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Back")) {
            setVisible(false);
        }

        if (s.equals("ADD")) {
            add();
        }

        if (s.equals("MOD")) {
            mod();
        }

        if (s.equals("DEL")) {
            del();
        }
    }

    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField) e.getSource();

        if (t == t1) {
            try {
                rno = Integer.parseInt(t1.getText());
                pss.setInt(1, rno);
                rs = pss.executeQuery();
                res = rs.next();

                if (res == true) {
                    if (action.equals("ADD")) {
                        t1.requestFocus();
                        return;
                    }
                    snm = rs.getString(2);
                    tno = rs.getInt(3);

                    t2.setText(snm);
                    t3.setText("" + tno);

                    if (action.equals("DEL")) {
                        t2.setEditable(false);
                        t3.setEditable(false);
                    } else {
                        t2.setEditable(true);
                        t3.setEditable(true);
                    }
                } else {
                    if (action.equals("ADD") == false) {
                        t1.requestFocus();
                        return;
                    }
                }

            } catch (Exception e1) {
            }
        }

        if (t == t3) {
            try {
                tno = Integer.parseInt(t3.getText());
                pst.setInt(1, tno);
                rt = pst.executeQuery();
                res = rt.next();

                if (res == true) {
                    t4.setText(rt.getString(2));
                    t5.setText("" + rt.getInt(3));
                } else {
                    t3.requestFocus();
                    return;
                }
            } catch (Exception e2) {
            }
        }
    }

    void add() {
        try {
            rno = Integer.parseInt(t1.getText());
            snm = t2.getText();
            tno = Integer.parseInt(t3.getText());
            psa.setInt(1, rno);
            psa.setString(2, snm);
            psa.setInt(3, tno);
            psa.executeUpdate();
            t1.requestFocus();
        } catch (Exception e) {
        }
    }

    void mod() {
        try {
            rno = Integer.parseInt(t1.getText());
            snm = t2.getText();
            tno = Integer.parseInt(t3.getText());
            psm.setString(1, snm);
            psm.setInt(2, tno);
            psm.setInt(3, rno);
            psm.executeUpdate();
            t1.requestFocus();
        } catch (Exception e1) {
        }
    }

    void del() {
        try {
            rno = Integer.parseInt(t1.getText());

            psd.setInt(1, rno);
            psd.executeUpdate();
            t1.requestFocus();
        } catch (Exception e1) {
        }
    }
}
