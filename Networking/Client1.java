import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 3030);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        String str = "Hello ";
        dos.writeUTF(str); // * sends message to server

        str = dis.readUTF(); // * reads message send by server
        System.out.println("Message From Server: " + str);
        s.close();
    }
}