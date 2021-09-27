package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Tutor Scheduler");
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Sessions", new SessionPanel());
		tabs.addTab("Tutors", new TutorPanel());
		tabs.addTab("Students", new StudentPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(tabs);
        frame.setVisible(true);
	}

}