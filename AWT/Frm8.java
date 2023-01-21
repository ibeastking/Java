//! Use of windows listener

import java.awt.*;
import java.awt.event.*;

class Frm8 extends Frame implements WindowListener {

  Frm8(String str) {
    super(str);
    addWindowListener(this);
    setSize(400, 400);
    setVisible(true);
  }

  public void windowOpened(WindowEvent e) {
    System.out.println("Opened:");
  }

  public void windowClosed(WindowEvent e) {
    System.out.println("Closed.");
  }

  public void windowClosing(WindowEvent e) {
    System.out.print("Closing");
    System.exit(0);
  }

  public void windowActivated(WindowEvent e) {
    System.out.println("Activated.");
  }

  public void windowDeactivated(WindowEvent e) {
    System.out.println("Deactivated");
  }

  public void windowIconified(WindowEvent e) {
    System.out.print("Iconified");
  }

  public void windowDeiconified(WindowEvent e) {
    System.out.print("Deiconified");
  }

  void menu() {
  }

  public static void main(String[] args) {
    Frm8 a = new Frm8("Window");
    a.menu();
  }
}
