//! Data Transfer Program

import java.net.*;
import java.io.*;

public class Client4 {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 6969);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = dis.readUTF();
        System.out.println(str);

        str = br.readLine();
        dos.writeUTF(str); // * sends file name to the server

        Boolean result = dis.readBoolean(); // *receives file information about file existence
        if (result == false) {
            System.out.println("Source File is Missing");
            s.close();
            return;
        }

        str = dis.readUTF(); // * receives message sent by server
        System.out.println(str);

        str = br.readLine(); // * enter destination file name

        FileOutputStream fos = new FileOutputStream(str);
        int val = 0;

        while (true) {
            val = dis.read();
            if (val == -1) {
                break;
            }
            fos.write(val);
        }

        fos.close();
        dos.close();
        dis.close();
        s.close();
    }
}