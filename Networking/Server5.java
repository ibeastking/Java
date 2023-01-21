
//! One server Many client

import java.net.*;
import java.io.*;
import java.util.*;

class Server5 implements Runnable {

    ServerSocket ss;
    Socket s;
    LinkedList<DataOutputStream> ls;
    BufferedReader br;
    DataOutputStream dos;

    Server5() throws Exception {

        ls = new LinkedList<DataOutputStream>();
        br = new BufferedReader(new InputStreamReader(System.in));
        ss = new ServerSocket(6969);
        System.out.println("Server Started");

        while (true) {
            try {
                s = ss.accept();
                ls.add(new DataOutputStream(s.getOutputStream()));
                new Thread(this).start();
            } catch (Exception e) {
            }
        }
    }

    public void run() {

        String str = "";

        while (true) {
            try {
                System.out.println("Message");
                str = br.readLine();

                int i = 0, n = ls.size();

                while (i < n) {
                    dos = ls.get(i);
                    dos.writeUTF(str);
                    i++;
                }
            } catch (Exception e) {
            }

            if (str.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        new Server5();
    }
}