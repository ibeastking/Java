import java.awt.*;
import java.awt.event.*;
import mypkg.Util; //! remember to set classpath before running

class Pan1 extends Panel implements ActionListener {
    Label lno, lnm;
    TextField tno, tnm;
    Button bo, bc;

    Pan1() {
        super();
        lno = new Label("Roll Number: ");
        lnm = new Label("Name: ");

        tno = new TextField(10);
        tnm = new TextField(20);

        bo = new Button("Ok");
        bc = new Button("Clear");
        bo.addActionListener(this);
        bc.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5));

        add(lno);
        add(tno);
        add(lnm);
        add(tnm);
        add(bo);
        add(bc);

        setSize(200, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == bo) {
            String s = "Roll Number: " + tno.getText() + "\nName: " + tnm.getText();
            Util.display(s);
        }

        tno.setText("");
        tnm.setText("");
    }
}

class Pan2 extends Panel implements ActionListener {
    Label lcity;
    TextField tcity;
    Button bo, bc;

    Pan2() {
        super();
        lcity = new Label("City");

        tcity = new TextField(40);

        bo = new Button("Ok");
        bc = new Button("Clear");
        bo.addActionListener(this);
        bc.addActionListener(this);

        setLayout(new GridLayout(2, 2, 5, 5));

        add(lcity);
        add(tcity);
        add(bo);
        add(bc);

        setSize(200, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == bo) {
            String s = "City: " + tcity.getText();
            Util.display(s);
        }

        tcity.setText("");
    }
}

class Pan3 extends Panel implements ActionListener {
    Label ltrade;
    List trade;
    Button bo, bc;

    Pan3() {
        super();

        ltrade = new Label("Trade");
        trade = new List(5);

        trade.addItem("CSE");
        trade.addItem("IT");
        trade.addItem("Electronics");
        trade.addItem("Electrical");
        trade.addItem("Mechanical");
        trade.addItem("Civil");
        trade.addItem("Aerospace");

        bo = new Button("Ok");
        bc = new Button("Clear");
        bo.addActionListener(this);
        bc.addActionListener(this);

        setLayout(new FlowLayout());

        add(ltrade);
        add(trade);
        add(bo);
        add(bc);

        setSize(200, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == bo) {
            String s = "Trade: " + trade.getSelectedItem();
            Util.display(s);
        }
    }
}

class Frm26 extends Frame implements ActionListener {

    Pan1 a;
    Pan2 b;
    Pan3 c;
    Panel main;
    CardLayout cl;
    Button ba, bb, bc;

    Frm26() {
        super();
        a = new Pan1();
        b = new Pan2();
        c = new Pan3();

        ba = new Button("Panel 1");
        bb = new Button("Panel 2");
        bc = new Button("Panel 3");

        ba.addActionListener(this);
        bb.addActionListener(this);
        bc.addActionListener(this);

        cl = new CardLayout(20, 20);

        main = new Panel();

        main.setLayout(cl);
        main.add(a, "Pan1");
        main.add(b, "Pan2");
        main.add(c, "Pan3");

        Panel tmp = new Panel();
        tmp.add(ba);
        tmp.add(bb);
        tmp.add(bc);

        add(main, BorderLayout.CENTER);
        add(tmp, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == ba) {
            cl.show(main, "Pan1");
        }

        if (b == bb) {
            cl.show(main, "Pan2");
        }

        if (b == bc) {
            cl.show(main, "Pan3");
        }
    }

    public void error() {
    }

    public static void main(String args[]) {
        Frm26 a = new Frm26();
        a.error();
    }
}