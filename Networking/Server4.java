
//! Data Transfer

import java.io.*;
import java.net.*;

public class Server4 {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(6969);
        System.out.println("Server Started");

        Socket s = ss.accept(); // * server is waiting for client
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "Enter File Name: ";

        dos.writeUTF(str); // * Message to Client

        str = dis.readUTF(); // * Gets File name from client
        File f = new File(str);

        Boolean result = false;

        result = f.exists();
        dos.writeBoolean(result); // * sends message to client about file existence

        if (result == false) {
            ss.close();
            s.close();
            return;
        }

        str = "Enter File Destination: ";
        dos.writeUTF(str);

        FileInputStream fis = new FileInputStream(f);
        int val = 0;

        while (true) {
            val = fis.read(); // * reads a byte

            dos.write(val); // * sends Byte to client
            if (val == -1) {
                break;
            }
        }

        dos.close();
        dis.close();
        fis.close();
        s.close();
        ss.close();
    }
}
