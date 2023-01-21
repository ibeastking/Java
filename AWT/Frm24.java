import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frm24 extends Frame implements ActionListener {

	Checkbox c1, c2, c3, c4, c5, c6, c7, c8;
	CheckboxGroup cg1, cg2;
	Button b1, b2;

	Frm24() {
		super("Radio Button");

		cg1 = new CheckboxGroup();

		c1 = new Checkbox("BSc", cg1, true);
		c2 = new Checkbox("BCom", cg1, false);
		c3 = new Checkbox("BA", cg1, false);
		c4 = new Checkbox("BCA", cg1, false);

		cg2 = new CheckboxGroup();

		c5 = new Checkbox("FY", cg2, true);
		c6 = new Checkbox("SY", cg2, false);
		c7 = new Checkbox("TY", cg2, false);
		c8 = new Checkbox("FE", cg2, false);

		b1 = new Button("OK");
		b2 = new Button("Exit");

		b1.addActionListener(this);
		b2.addActionListener(this);

		setLayout(new FlowLayout());

		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(c5);
		add(c6);
		add(c7);
		add(c8);
		add(b1);
		add(b2);

		setSize(400, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();

		if (b == b2) {
			System.exit(0);
		}

		if (b == b1) {
			String s = "Trade: " + (cg1.getSelectedCheckbox()).getLabel() + "\nYear: "
					+ (cg2.getSelectedCheckbox()).getLabel();
			JOptionPane.showMessageDialog(null, s);
		}
	}

	public void error() {
	}

	public static void main(String args[]) {
		Frm24 a = new Frm24();
		a.error();
	}
}