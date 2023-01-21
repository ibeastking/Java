import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Frm21 extends Frame implements ActionListener, TextListener {
    Panel pan;
    Button bn, bo, bs, bx;
    TextArea ta;
    String str;
    boolean flag;

    Frm21() {
        super("Editor");

        pan = new Panel();
        bn = new Button("New");
        bo = new Button("Open");
        bs = new Button("Save");
        bx = new Button("Exit");
        flag = true;

        bn.addActionListener(this);
        bo.addActionListener(this);
        bs.addActionListener(this);
        bx.addActionListener(this);

        pan.add(bn);
        pan.add(bo);
        pan.add(bs);
        pan.add(bx);

        add(pan, BorderLayout.SOUTH);

        ta = new TextArea("", 10, 80, TextArea.SCROLLBARS_BOTH);
        ta.addTextListener(this);
        add(ta, BorderLayout.CENTER);

        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == bn) {
            ta.setText("");
        }

        if (b == bx) {
            if (flag == false) {
                int opt = JOptionPane.showConfirmDialog(null, "Save?");

                if (opt == JOptionPane.YES_OPTION) {
                    save();
                }
            }
            System.exit(0);
        }

        if (b == bo) {
            open();
        }

        if (b == bs) {
            save();
        }
    }

    public void textValueChanged(TextEvent e) {
        flag = false;
    }

    void open() {
        FileDialog fol = null;
        File f = null;
        FileReader fr = null;

        fol = new FileDialog(this, "Open", FileDialog.LOAD);
        fol.setVisible(true);
        f = new File(fol.getDirectory() + fol.getFile());

        str = "";
        int val = 0;
        try {
            fr = new FileReader(f);
            while (true) {
                val = fr.read();
                if (val == -1) {
                    break;
                }
                str = str + (char) val;
            }
            fr.close();
            ta.setText(str);
            flag = true;
        } catch (Exception e) {
        }
    }

    void save() {
        FileDialog fd = null;
        File f = null;
        FileWriter fw = null;

        fd = new FileDialog(this, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        f = new File(fd.getDirectory() + fd.getFile());

        str = ta.getText();

        int i = 0;
        int len = str.length();
        char p[] = new char[len];
        p = str.toCharArray();

        try {
            fw = new FileWriter(f);
            while (i < len) {
                fw.write(p[i]);
                i++;
            }
            fw.close();
            flag = true;
        } catch (Exception e) {
        }
    }

    public void error() {
    }

    public static void main(String args[]) {
        Frm21 a = new Frm21();
        a.error();
    }
}
