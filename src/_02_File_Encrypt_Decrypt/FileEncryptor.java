package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;

import javax.swing.JOptionPane;

public class FileEncryptor {

	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("insert message");
		int key = Integer.parseInt(JOptionPane.showInputDialog("insert key"));
		String encrypted = "";
		for (int i = 0; i < message.length(); i++) {
			char c = (char) (message.charAt(i) + key);
			if ((int) c >= 123 && (int) c-key < 123) {
				c -= 26;
			}
			encrypted += c;
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			fw.write(encrypted);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

//Copyright ? 2021 Derek Arce