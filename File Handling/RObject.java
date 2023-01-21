//! Program to read class objects from file

import java.io.*;
import mypkg.Util;
import mypkg.YStudent;

class RObject {
    public static void main(String args[]) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        File f = new File("ystu.dat");

        if (f.exists() == false) {
            Util.display("No Such file exists");
        }

        try {
            fis = new FileInputStream("ystu.dat");
            ois = new ObjectInputStream(fis);
        } catch (Exception e) {
        }

        YStudent obj = null;

        while (true) {
            try {
                obj = (YStudent) ois.readObject();
            } catch (Exception e) {
                break;
            }

            obj.display();
        }

        try {
            fis.close();
            ois.close();
        } catch (Exception e) {
        }
    }
}