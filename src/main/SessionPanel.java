package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SessionPanel extends AbstractPanel 
{
	
	private static String[] criteria = {"Tutor", "Student", "Date", "Subject"};
	
	public SessionPanel()
	{
		super(criteria);
		results.setLayout(new GridLayout(0, 4));
	}

	@Override
	protected void lookupClick() {
		// TODO Auto-generated method stub
		ArrayList<String> resultsList = new ArrayList<String>();
		if(criteriaBox.getSelectedItem().equals("Tutor"))
		{
			//gets a list of every entry from a query of from sessions where the field is in tutorfirstname + ' ' + tutorlastname
			//query should include tutorname, studentname, subject, date
			resultsList = TutorSession.getSessionsByTutorName(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Student"))
		{
			//gets a list of every entry from a query from sessions where the field is in studentfirstname + ' ' + studentlastname
			//query should include tutorname, studentname, subject, date
			resultsList = TutorSession.getSessionsByStudentName(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Subject"))
		{
			//gets a list of every entry from a query from sessions where the field is in subject
			//query should include tutorname, studentname, subject, date
			resultsList = TutorSession.getSessionsBySubject(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Date"))
		{
			//gets a list of every entry from a query from sessions where the field is in date
			//query should include tutorname, studentname, subject, date
			resultsList = TutorSession.getSessionsByDate(criteriaField.getText());
		}
		for(String entry:resultsList)
		{
			results.add(new JLabel(entry));
		}
		results.revalidate();
	}

	@Override
	protected void addClick() {
		// TODO Auto-generated method stub
		JDialog addDialog = new JDialog();
		addDialog.setTitle("Add Session");
		addDialog.setLayout(new GridLayout(0,2));
		addDialog.setSize(300, 300);
		
		addDialog.add(new JLabel("Tutor"));
		// gets array of tutor names
		String[] tutorOptions = Tutor.getNames();
		JComboBox<String> tutorOptionsBox = new JComboBox<String>(tutorOptions);
		addDialog.add(tutorOptionsBox);
		
		addDialog.add(new JLabel("Student"));
		//gets array of student names
		String[] studentOptions = Student.getNames();
		JComboBox<String> studentOptionsBox = new JComboBox<String>(studentOptions);
		addDialog.add(studentOptionsBox);
		
		addDialog.add(new JLabel("Subject"));
		//gets array of subjects
		String[] subjectOptions = Subject.getSubjects();
		JComboBox<String> subjectOptionsBox = new JComboBox<String>(subjectOptions);
		addDialog.add(subjectOptionsBox);
		
		addDialog.add(new JLabel("Month"));
		JTextField monthField = new JTextField();
		addDialog.add(monthField);
		
		addDialog.add(new JLabel("Day"));
		JTextField dayField = new JTextField();
		addDialog.add(dayField);
		
		addDialog.add(new JLabel("Year"));
		JTextField yearField = new JTextField();
		addDialog.add(yearField);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	TutorSession.add(tutorOptionsBox.getSelectedItem().toString(),
            					studentOptionsBox.getSelectedItem().toString(),
            					subjectOptionsBox.getSelectedItem().toString(), 
            					monthField.getText(),
            					dayField.getText(),
            					yearField.getText());
            	addDialog.dispose();
            }
        });
		addDialog.add(submitButton);
		
		JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() 
			{
	            public void actionPerformed(ActionEvent e) 
	            {
	            	addDialog.dispose();
	            }
	        });
		addDialog.add(cancelButton);
		
		addDialog.setVisible(true);
	}

	@Override
	protected void editClick() {
		// TODO Auto-generated method stub
		JDialog editDialog = new JDialog();
		editDialog.setTitle("Edit Session");
		editDialog.setLayout(new GridLayout(0,2));
		editDialog.setSize(300, 300);
		
		editDialog.add(new JLabel("ID"));
		// gets array of session ids
		String[] idOptions = TutorSession.getIDs();
		JComboBox<String> idOptionsBox = new JComboBox<String>(idOptions);
		editDialog.add(idOptionsBox);
		
		editDialog.add(new JLabel("Tutor"));
		// gets array of tutor names
		String[] tutorOptions = Tutor.getNames();
		JComboBox<String> tutorOptionsBox = new JComboBox<String>(tutorOptions);
		editDialog.add(tutorOptionsBox);
		
		editDialog.add(new JLabel("Student"));
		//gets array of student names
		String[] studentOptions = Student.getNames();
		JComboBox<String> studentOptionsBox = new JComboBox<String>(studentOptions);
		editDialog.add(studentOptionsBox);
		
		editDialog.add(new JLabel("Subject"));
		//gets array of subjects
		String[] subjectOptions = Subject.getSubjects();
		JComboBox<String> subjectOptionsBox = new JComboBox<String>(subjectOptions);
		editDialog.add(subjectOptionsBox);
		
		editDialog.add(new JLabel("Month"));
		JTextField monthField = new JTextField();
		editDialog.add(monthField);
		
		editDialog.add(new JLabel("Day"));
		JTextField dayField = new JTextField();
		editDialog.add(dayField);
		
		editDialog.add(new JLabel("Year"));
		JTextField yearField = new JTextField();
		editDialog.add(yearField);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	TutorSession.update(idOptionsBox.getSelectedItem().toString(),
            						tutorOptionsBox.getSelectedItem().toString(),
            						studentOptionsBox.getSelectedItem().toString(),
            						subjectOptionsBox.getSelectedItem().toString(), 
            						monthField.getText(),
            						dayField.getText(),
            						yearField.getText());
            	editDialog.dispose();
            }
        });
		editDialog.add(submitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	editDialog.dispose();
            }
        });
		editDialog.add(cancelButton);
		
		editDialog.setVisible(true);
	}

	@Override
	protected void removeClick() {
		// TODO Auto-generated method stub
		JDialog removeDialog = new JDialog();
		removeDialog.setTitle("Remove Session");
		removeDialog.setLayout(new GridLayout(0,2));
		removeDialog.setSize(300, 300);
		
		removeDialog.add(new JLabel("ID"));
		// gets array of session ids
		String[] idOptions = TutorSession.getIDs();
		JComboBox<String> idOptionsBox = new JComboBox<String>(idOptions);
		removeDialog.add(idOptionsBox);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	TutorSession.remove(idOptionsBox.getSelectedItem());
            	removeDialog.dispose();
            }
        });
		removeDialog.add(submitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	removeDialog.dispose();
            }
        });
		removeDialog.add(cancelButton);
		
		removeDialog.setVisible(true);
	}
}