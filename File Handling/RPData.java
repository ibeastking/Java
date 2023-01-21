//! File to read primitive data from File

import java.io.*;
import mypkg.Util;

class RPData{
    public static void main(String args[]){
        
        int n = 0;
        double mrk = 0.0;
        String nm = "";

        DataInputStream dis = null;
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("stu.dat");
            dis = new DataInputStream(fis);
        }catch(Exception e){}

        while(true){
            try{
                n = dis.readInt();
                nm = dis.readUTF();
                mrk = dis.read();
            }catch(Exception e){
                break;
            }

            String a = "Roll Number: "+ n + "\nName: "+ nm + "\nMarks: " + mrk;
            Util.display(a);
        }

        try{
            fis.close();
            dis.close();
        }catch(Exception e){}
    }
}