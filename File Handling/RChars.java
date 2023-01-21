//! Program to read the file using character stream classes

import java.io.*;

class RChars {
    public static void main(String args[]) {
        int val = 0;
        File f = new File("abc.txt");

        if (f.exists() == false) {
            System.out.println("\nFile Not Found");
            return;
        }

        FileReader fr = null;

        try {
            fr = new FileReader(f);
        } catch (Exception e) {
        }

        System.out.println("Data");

        while (true) {
            try {
                val = fr.read();

                if (val == -1) {
                    break;
                }
                System.out.print((char) val);
            } catch (Exception e) {
            }
        }

        try {
            fr.close();
        } catch (Exception e) {
        }
    }
}