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

public class TutorPanel extends AbstractPanel {
	
	private static String[] criteria = {"Name", "Cert Date", "Status", "Phone", "Email"};
	
	public TutorPanel()
	{
		super(criteria);
		results.setLayout(new GridLayout(0, 5));
	}

	@Override
	protected void lookupClick() {
		// TODO Auto-generated method stub
		ArrayList<String> resultsList = new ArrayList<String>();
		if(criteriaBox.getSelectedItem().equals("Name"))
		{
			//gets a list of every entry from a query of from tutors where the field is in tutorfirstname + ' ' + tutorlastname
			resultsList = Tutor.getTutorsByName(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Cert Date"))
		{
			//gets a list of every entry from a query from tutors where the field is in certdate
			resultsList = Tutor.getTutorsByCertDate(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Status"))
		{
			//gets a list of every entry from a query from tutors where the field is in status
			resultsList = Tutor.getTutorsByStatus(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Phone"))
		{
			//gets a list of every entry from a query from tutors where the field is in phone
			resultsList = Tutor.getTutorsByPhone(criteriaField.getText());
		}
		if(criteriaBox.getSelectedItem().equals("Email"))
		{
			//gets a list of every entry from a query from tutors where the field is in email
			resultsList = Tutor.getTutorsByEmail(criteriaField.getText());
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
		addDialog.setTitle("Add Tutor");
		addDialog.setLayout(new GridLayout(0,2));
		addDialog.setSize(300, 300);
		
		addDialog.add(new JLabel("Name"));
		JTextField nameField = new JTextField();
		addDialog.add(nameField);
		
		addDialog.add(new JLabel("Cert Date"));
		JTextField certDateField = new JTextField();
		addDialog.add(certDateField);
		
		addDialog.add(new JLabel("Status"));
		JTextField statusField = new JTextField();
		addDialog.add(statusField);
		
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
            	Tutor.add(nameField.getText(), certDateField.getText(), statusField.getText(), phoneField.getText(), emailField.getText());
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
		// gets array of tutor ids
		String[] idOptions = Tutor.getIDs();
		JComboBox<String> idOptionsBox = new JComboBox<String>(idOptions);
		editDialog.add(idOptionsBox);
		
		editDialog.add(new JLabel("Name"));
		JTextField nameField = new JTextField();
		editDialog.add(nameField);
		
		editDialog.add(new JLabel("Cert Date"));
		JTextField certDateField = new JTextField();
		editDialog.add(certDateField);
		
		editDialog.add(new JLabel("Status"));
		JTextField statusField = new JTextField();
		editDialog.add(statusField);
		
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
            	Tutor.update(idOptionsBox.getSelectedItem().toString(),
            				 nameField.getText(),
            				 certDateField.getText(),
            				 statusField.getText(),
            				 phoneField.getText(),
            				 emailField.getText());
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
		// gets array of tutor ids
		String[] idOptions = Tutor.getIDs();
		JComboBox<String> idOptionsBox = new JComboBox<String>(idOptions);
		removeDialog.add(idOptionsBox);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	Tutor.remove(idOptionsBox.getSelectedItem());
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