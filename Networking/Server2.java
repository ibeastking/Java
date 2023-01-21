
import java.io.*;
import java.net.*;

public class Server2 {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(8086);
        System.out.println("Server Started");
        Socket s = ss.accept();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        String cnn = dis.readUTF(); // * reads Client Name send by the Client
        String str = "Welcome " + cnn;
        dos.writeUTF(str);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            str = dis.readUTF(); // * reads the message send by the client
            System.out.println("Message From " + cnn + ": " + str);

            if (str == "bye") {
                break;
            }

            System.out.println("Message To " + cnn + ": ");
            str = br.readLine();
            dos.writeUTF(str);

            if (str.equals("bye")) {
                break;
            }
        }

        s.close();
        ss.close();
    }
}
