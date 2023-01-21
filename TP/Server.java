
//! Data transfer 

import java.io.*;
import java.net.*;

class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server Started");

        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String str = dis.readUTF();
        File f;
        f = new File(str);

        if (f.exists() == true) {
            str = "File Found";
        } else {
            str = "File Not Found";
        }

        dos.writeUTF(str);

        s.close();
        ss.close();
    }

}