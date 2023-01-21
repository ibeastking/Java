import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

class Frm18 extends Frame {
    Image img;
    Color cr;

    Frm18() {
        super("Image");
        File f = new File("D:\\VSCODE\\JAVA\\AWT\\chart.jpeg");

        try {
            img = (Image) ImageIO.read(f);
        } catch (Exception e) {
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {
        cr = new Color(255, 0, 0);

        g.drawImage(img, 0, 0, 300, 300, cr, this);
    }

    void menu() {
    }

    public static void main(String args[]) {
        Frm18 a = new Frm18();
        a.menu();
    }
}