//! Chatting program using GUI

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Server3 extends Frame implements ActionListener, Runnable {

    Label l1, l2;
    TextArea t1, t2;
    Button b1, b2;
    String str;
    DataOutputStream dos;
    DataInputStream dis;
    Thread th;
    ServerSocket ss;
    Socket s;

    // ! throws exception
    Server3() throws Exception {
        super("Server");

        l1 = new Label("From Client");
        l2 = new Label("To Client");

        t1 = new TextArea(null, 10, 60, TextArea.SCROLLBARS_BOTH);
        t1.setEditable(false);
        t2 = new TextArea(null, 10, 60, TextArea.SCROLLBARS_BOTH);
        t2.setEditable(true);

        b1 = new Button("Ok");
        b1.addActionListener(this);
        b2 = new Button("Clear");
        b2.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLayout(null);
        l1.setBounds(50, 50, 100, 20);
        t1.setBounds(50, 80, 200, 100);
        l2.setBounds(50, 190, 100, 20);
        t2.setBounds(50, 220, 200, 100);
        b1.setBounds(50, 330, 90, 20);
        b2.setBounds(160, 330, 90, 20);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        setSize(300, 400);
        setVisible(true);

        ss = new ServerSocket(4040);
        s = ss.accept();
        dos = new DataOutputStream(s.getOutputStream());
        dis = new DataInputStream(s.getInputStream());

        th = new Thread(this);
        th.start();

        str = "";
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == b1) {
            try {
                str = t2.getText();
                dos.writeUTF(str);

                if (str == "bye") {
                    th.interrupt();
                    System.exit(0);
                }
            } catch (Exception e1) {
            }
        }

        t2.setText("");
    }

    public void run() {
        try {
            while (true) {
                str = dis.readUTF();
                str = t1.getText() + "\n" + str;
                t1.setText(str);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        Server3 s = null;

        try {
            s = new Server3();
        } catch (Exception e) {
        }
    }
}