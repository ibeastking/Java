//! Program to write class objects to file

import mypkg.*;
import java.io.*;

class WObject{
    public static void main(String args[]){
        int n;
        YStudent s = null;

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("ystu.dat");
            oos = new ObjectOutputStream(fos);
        }catch(Exception e){}

        while(true){
            n = Util.iInput("Roll Number");

            if(n==0){
                break;
            }

            s = new YStudent();
            s.setData(n);

            try{
                oos.writeObject(s);
            }catch(Exception e){}
        }

        try{
            fos.close();
            oos.close();
        }catch(Exception e){}
    }
}