import mypkg.Util;

class UseUtil {
    public static void main(String args[]) {
        int n = Util.iInput("Roll Number: ");
        String nm = Util.sInput("Name");
        Double mrk = Util.dInput("Marks: ");

        Util.display("Roll Number: " + n + "\nName: " + nm + "\nMarks: " + mrk);

        String s[] = new String[] { "a", "b", "c", "d" };
        int opt = Util.oInput("Om", "Choose One", s);

        Util.display("Option Choosed is " + opt);
    }
}