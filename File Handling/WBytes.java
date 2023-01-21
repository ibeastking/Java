//! File creation using byte stream classes

import java.io.*;
import mypkg.Util;

class WBytes{
    public static void main(String args[]){
        FileOutputStream fos = null;
        int n = 0;

        try{
            fos=new FileOutputStream("num.dat");
        }catch(Exception e){}

        System.out.println("Enter Numbers");
        while(true)
        {
            n=Util.iInput("Enter Number: ");
            if(n==0)
            {
                break;
            }

            try{
                fos.write(n);
            }catch(Exception e){}
        }

        try{
            fos.close();
        }catch(Exception e){}
    }
}