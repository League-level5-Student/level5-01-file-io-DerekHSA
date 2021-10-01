package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class CopyrightEnforcer {
public static void main(String[] args) {
	
		File src = new File("src/");
		itterate(src);
		
	}
public static void itterate(File file) {
	File[] files = file.listFiles();
	if(files != null) {
		for(File f : files) {
		  System.out.println(f.getAbsolutePath());
		  if (f.getAbsolutePath().contains(".java")) {
			edit(f);
		  }else {
			  itterate(f);
		  }
		  
		}
	}
}
public static void edit(File file) {
	try {
		FileWriter fw = new FileWriter(file, true);
		fw.write("\n//Copyright © 2021 Derek Arce");
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}


//Copyright © 2021 Derek Arce