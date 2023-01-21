import java.awt.*;

class Frm1 extends Frame {
    Frm1(String str) {
        super(str); // * heading / title of the window
        setSize(400, 400);
        setVisible(true); // * this method prints the window
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm1 a = new Frm1("My First Window");
        a.menu();
    }
}