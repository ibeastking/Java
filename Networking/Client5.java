
//! One Server many User

import java.io.*;
import java.net.*;

class Client5 {

    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 6969);
        DataInputStream dis = new DataInputStream(s.getInputStream());

        while (true) {
            String str = dis.readUTF();
            System.out.println("From Server: " + str);

            if (str.equals("bye")) {
                break;
            }
        }

        dis.close();
        s.close();
    }
}