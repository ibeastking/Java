import java.net.*;
import java.io.*;

class Server1 {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3030); // * port number, declaring the server
        System.out.println("Server Started");

        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String str = dis.readUTF(); // * reads data send by the client
        System.out.println("From Client " + str);

        str = "Fuck Off";
        dos.writeUTF(str); // * sends message to client
        s.close();
        ss.close();
    }
}