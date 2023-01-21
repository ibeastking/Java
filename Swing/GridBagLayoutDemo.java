import java.awt.*;
import javax.swing.*;

class GridBagLayoutDemo extends JFrame {
    JPanel p;
    GridBagConstraints c;

    GridBagLayoutDemo() {
        super("GridBagLayout");

        p = new JPanel();
        p.setLayout(new GridBagLayout());

        c = new GridBagConstraints();

        // * Component grow in both direction
        c.fill = GridBagConstraints.BOTH;

        // * 5 pixel margins on all sides
        c.insets = new Insets(5, 5, 5, 5);

        // * setting the dimensions of the button 1
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 4;

        // * this will provide the area to the button when the screen is maximised
        c.weightx = c.weighty = 1.0;

        // * adding the JButton to the panel
        p.add(new JButton("Button 1"), c);

        // * setting the dimensions of the button 2
        c.gridx = 4;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;

        c.weightx = c.weighty = 0;

        p.add(new JButton("Button 2"), c);

        // * setting the dimensions of the button 3
        c.gridx = 4;
        c.gridy = 1;
        p.add(new JButton("Button 3"), c);

        // * setting the dimensions of the button 4
        c.gridx = 4;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 2;

        p.add(new JButton("Button 4"), c);

        // * setting the dimensions of the button 5
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = c.gridwidth = 1;

        p.add(new JButton("Button 5"), c);

        // * setting the dimensions of the button 6
        c.gridx = 2;
        c.gridy = 4;

        p.add(new JButton("Button 6"), c);

        // * setting the dimensions of the button 7
        c.gridx = 3;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 2;

        p.add(new JButton("Button 7"), c);

        // * setting the dimensions of the button 8
        c.gridx = 1;
        c.gridy = 5;
        c.gridheight = c.gridwidth = 1;

        p.add(new JButton("Button 8"), c);

        // * setting the dimensions of the button 9
        c.gridx = 3;
        c.gridy = 5;

        p.add(new JButton("Button 9"), c);

        add(p);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void error() {
    }

    public static void main(String args[]) {
        GridBagLayoutDemo a = new GridBagLayoutDemo();
        a.error();
    }
}