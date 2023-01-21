
import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String args[]) throws Exception {

        Socket s = new Socket("localhost", 8086);

        if (args.length != 1) {
            System.out.println("Invalid Arguments");
            s.close();
            return;
        }

        String cnn = args[0];
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dos.writeUTF(cnn); // *sends Client Name to Server

        String str = dis.readUTF();
        System.out.println("Message From Sever: " + str);

        while (true) {
            System.out.println("Message To Server: ");
            str = br.readLine();

            dos.writeUTF(str); // * writes to Server

            if (str == "bye") {
                break;
            }

            str = dis.readUTF(); // * reads Message send by the server

            System.out.println("Message From Server: " + str);

            if (str.equals("bye")) {
                break;
            }
        }

        s.close();
    }
}
