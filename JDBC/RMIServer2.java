import java.rmi.*;
import java.rmi.server.*;

interface inter2 extends Remote {
    public int isPrime(int n) throws Exception;

    public int length(int n) throws Exception;
}

class InterImpl2 extends UnicastRemoteObject implements inter2 {
    InterImpl2() throws Exception {
        super();
    }

    public int length(int n) throws Exception {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    public int isPrime(int n) throws Exception {
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                break;
            } else {
                i++;
            }
        }

        return (i == n ? 1 : 0);
    }
}

class RMIServer2 {
    public static void main(String[] args) throws Exception {
        InterImpl2 a = new InterImpl2();
        Naming.rebind("obj", a);
        System.out.println("Server Started");
    }
}
