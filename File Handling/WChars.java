//! Program to create a file using character stream classes

import java.io.*;

class WChars {
	public static void main(String args[]) {
		int val = 0;

		FileWriter fw = null;
		try {
			fw = new FileWriter("abc.txt");
		} catch (Exception e) {
		}

		System.out.println("Type Characters: ");

		while (true) {
			try {
				val = System.in.read();
				System.in.skip(5);

				if ((char) val == '*') {
					break;
				}
				fw.write(val);
			} catch (Exception e) {
			}
		}

		try {
			fw.close();
		} catch (Exception e) {
		}
	}
}