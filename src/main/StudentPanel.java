package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentPanel extends AbstractPanel {
	
	private static String[] criteria = {"Name", "Phone", "Email"};
	
	public StudentPanel()
	{
		super(criteria);
		results.setLayout(new GridLayout(0, 3));
	}

	@Override
	protected void lookupClick() {
		// TODO Auto-generated method stub
		ArrayList<String> resultsList = new ArrayList<String>();
		if(criteriaBox.getSelectedItem().equals("Name"))
		{
			//gets a list of every entry from a query of from students where the field is in studentfirstname + ' ' + studentlastname
			resultsList = Student.getStudentsByName(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Phone"))
		{
			//gets a list of every entry from a query from students where the field is in phone
			resultsList = Student.getStudentsByPhone(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Email"))
		{
			//gets a list of every entry from a query from students where the field is in email
			resultsList = Student.getStudentsByEmail(criteriaField.getText());
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
		addDialog.setTitle("Add Student");
		addDialog.setLayout(new GridLayout(0,2));
		addDialog.setSize(300, 300);
		
		addDialog.add(new JLabel("Name"));
		JTextField nameField = new JTextField();
		addDialog.add(nameField);
		
		addDialog.add(new JLabel("Phone"));
		JTextField phoneField = new JTextField();
		addDialog.add(phoneField);
		
		addDialog.add(new JLabel("Email"));
		JTextField emailField = new JTextField();
		addDialog.add(emailField);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	Student.add(nameField.getText(), phoneField.getText(), emailField.getText());
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
		editDialog.setTitle("Edit Tutor");
		editDialog.setLayout(new GridLayout(0,2));
		editDialog.setSize(300, 300);
		
		editDialog.add(new JLabel("ID"));
		// gets array of student ids
		String[] idOptions = Student.getIDs();
		JComboBox<String> idOptionsBox = new JComboBox<String>(idOptions);
		editDialog.add(idOptionsBox);
		
		editDialog.add(new JLabel("Name"));
		JTextField nameField = new JTextField();
		editDialog.add(nameField);
		
		editDialog.add(new JLabel("Phone"));
		JTextField phoneField = new JTextField();
		editDialog.add(phoneField);
		
		editDialog.add(new JLabel("Email"));
		JTextField emailField = new JTextField();
		editDialog.add(emailField);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	//Dont get it
            	Student.update(idOptionsBox.getSelectedItem().toString(), nameField.getText(), phoneField.getText(), emailField.getText());
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
		removeDialog.setTitle("Remove Tutor");
		removeDialog.setLayout(new GridLayout(0,2));
		removeDialog.setSize(300, 300);
		
		removeDialog.add(new JLabel("ID"));
		// gets array of student ids
		String[] idOptions = Student.getIDs();
		JComboBox<String> idOptionsBox = new JComboBox<String>(idOptions);
		removeDialog.add(idOptionsBox);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	Student.remove(idOptionsBox.getSelectedItem().toString());
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