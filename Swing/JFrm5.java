import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyPanel extends JPanel {
    int x, y;

    MyPanel() {
        super();

        setBorder(BorderFactory.createLineBorder(Color.red, 5));

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x, y, x + 20, y + 20);
    }
}

class JFrm5 extends JFrame {
    MyPanel obj;

    JFrm5() {
        super("Use JPanel");

        obj = new MyPanel();
        add(obj);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void menu() {
    }

    public static void main(String args[]) {
        JFrm5 a = new JFrm5();
        a.menu();
    }
}