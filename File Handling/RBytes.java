//! Program to read byte file 

import java.io.*;
import mypkg.Util;

class RBytes{
    public static void main(String args[]){
        File f = null;
        
        f = new File("num.dat");

        if(f.exists()==false)
        {
            Util.display("File Does not Exist");
            return;
        }
        
        FileInputStream fis = null;

        int n = 0;

        try{
            fis = new FileInputStream("num.dat");
        }catch(Exception e){}

        System.out.println("Data");

        while(true)
        {
            try{
                n=fis.read();
                if(n==-1)
                {
                    break;
                }
                System.out.println(" "+n);
            }catch(Exception e){}
        }
    }
}