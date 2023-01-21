import java.io.*;

class Kbd1 {
    public static void main(String args[]) {
        InputStreamReader isr = null;
        BufferedReader br = null;

        try

        {

            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        } catch (Exception e) {
        }
        System.out.println("Message: ");
        String str = "";

        try {
            str = br.readLine();
        } catch (Exception e) {
        }
        System.out.println("String: " + str);
    }
}
