class MyThread implements Runnable
{
    int n;
    MyThread(int a)
    {
        n = a;
    }
    public void run()
    {
        int i = 1;
        while(i <= 10)
        {
            System.out.println(" " + n*i);
            i++;
        }
    }
}


public class Thread5
{
    public static void main(String [] args)
    {
        MyThread a = new MyThread(17);
        // Thread5 x = new Thread(a);
        Thread x = new Thread(a);
        x.start();
    }
}