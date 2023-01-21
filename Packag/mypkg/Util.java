package mypkg;

import javax.swing.*;

public class Util{
    public static void display(String str){
        JOptionPane.showMessageDialog(null,str);
    }

    public static int iInput(String str){
        int n=0;
        try{
            n=Integer.parseInt(JOptionPane.showInputDialog(null,str));
        }catch(Exception e){}

        return n;
    }

    public static double dInput(String str){
        double n = 0.0;
        try{
            n=Double.parseDouble(JOptionPane.showInputDialog(null,str));
        }catch(Exception e){}

        return n;
    }

    public static String sInput(String str){
        String n = new String();
        try{
            n=JOptionPane.showInputDialog(null,str);
        }catch(Exception e){}

        return n;
    }

    public static int oInput(String title,String msg,String choice[]){
        int opt = JOptionPane.showOptionDialog(null,msg,title,JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,choice,0);

        return opt;
    }

    
}