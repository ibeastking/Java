//! File to write primitive data to File

import java.io.*;
import mypkg.Util;

class WPData{
    public static void main(String args[]){
        int n;
        double mrk;
        String nm="";

        DataOutputStream dos = null;
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("stu.dat");
            dos = new DataOutputStream(fos);

            while(true)
            {
                n=Util.iInput("Roll Number");
                if(n==0){
                    break;
                }
                nm=Util.sInput("Name");
                mrk=Util.dInput("Marks");

                dos.writeInt(n);
                dos.writeUTF(nm);
                dos.writeDouble(mrk);
            }

            dos.close();
            fos.close();
        }catch(Exception e){}
    }
}