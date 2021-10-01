package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	int files;
	int lastFile;
	ArrayList<String> tasks;
	JFrame f;
	JPanel p;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public void ToDo() {
		tasks = new ArrayList<String>();
		load(lastFile);
		getFiles();
		f = new JFrame();
		p = new JPanel();
		add = new JButton("Add");
		view = new JButton("View");
		remove = new JButton("Remove");
		load = new JButton("Load");
		save = new JButton("Save");
		f.add(p);
		p.add(add);
		p.add(view);
		p.add(remove);
		p.add(load);
		p.add(save);
		f.setVisible(true);
		f.pack();
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void getFiles() {
		int trys = 0;
		try {
			while(true) {
			FileReader fr = new FileReader("src/_03_To_Do_List/SavedList"+trys);
			trys++;
			files++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(files);
		}
	}

	public void load(int file) {

		for (int i = tasks.size() - 1; i >= 0; i--) {
			tasks.remove(i);
		}
		lastFile = file;
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/SavedList" + file));
			String line = br.readLine();
			while (line != null) {
				tasks.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			tasks.add(JOptionPane.showInputDialog("What task would you like to add?"));
		} else if (e.getSource() == view) {
			String temp = "";
			for (int i = 0; i < tasks.size(); i++) {
				if (i == 0) {
					temp += tasks.get(i);
				} else {
					temp += "\n" + tasks.get(i);
				}
			}
			JOptionPane.showMessageDialog(null, temp);
		} else if (e.getSource() == remove) {
			String temp = "";
			temp = JOptionPane.showInputDialog("Please write down a task to remove.");
			if (tasks.contains(temp)) {
				for (int i = 0; i < tasks.size(); i++) {
					if (tasks.get(i).equalsIgnoreCase(temp)) {
						tasks.remove(i);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "That task doesn't exist!!!");
			}
		} else if (e.getSource() == save) {

			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/SavedList" + files);
				for (int i = 0; i < tasks.size(); i++) {
					fw.write(tasks.get(i) + "\n");
				}
				fw.close();
				files++;
				lastFile = files;
				System.out.println(files);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			load(Integer.parseInt(JOptionPane.showInputDialog("What file would you like to open? (Number)")));
		}
	}
}

//Copyright © 2021 Derek Arce