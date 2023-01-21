import java.io.*;

public class CopyFile {
    public static void main(String args[]) {
        int val = 0;

        File f = new File("abc.txt");

        if (f.exists() == false) {
            System.out.println("File Not Found");
            return;
        }

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(f);
            fw = new FileWriter("pqr.txt");

            while (true) {
                val = fr.read();
                if (val == -1) {
                    break;
                }
                fw.write(val);
            }
            fr.close();
            fw.close();
        } catch (Exception e) {
        }
    }
}
