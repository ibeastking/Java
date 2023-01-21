import java.rmi.*;
import java.rmi.server.*;

class RMIClient2 {
    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost/obj";
        inter2 ref = (inter2) Naming.lookup(url);
        System.out.println("Length of Number: " + ref.length(867));

        if (ref.isPrime(867) == 1) {
            System.out.println("Number is Prime");
        } else {
            System.out.println("Number is Non-Prime");
        }
    }
}
