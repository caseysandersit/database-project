package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractPanel extends JPanel
{
	protected JComboBox<String> criteriaBox;
	protected JTextField criteriaField;
	protected JPanel results = new JPanel(new GridLayout());
	
	public AbstractPanel(String criteria[])
	{	
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		criteriaBox = new JComboBox<String>(criteria);
		c.insets = new Insets(10, 0 , 10, 0);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.25;
		c.weighty = 0.1;
		add(criteriaBox, c);
		
		criteriaField = new JTextField();
		c.gridx = 1;
		c.weightx = 1;
		add(criteriaField, c);
		
		JButton lookupButton = new JButton("Lookup");
		lookupButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	results.removeAll();
            	for(int i = 0; i < criteria.length; i++)
        		{
        			results.add(new JLabel(criteria[i]));
        		}
            	lookupClick();
            }
        });
		c.gridx = 2;
		c.weightx = 0.25;
		add(lookupButton, c);
		
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		add(results, c);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	addClick();
            }
        });
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 150;
		c.gridwidth = 1;
		c.gridy = 2;
		c.weightx = 0.25;
		c.weighty = 0.1;
		add(addButton, c);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	editClick();
            }
        });
		c.gridx = 1;
		c.weightx = 1;
		add(editButton, c);
		
		JButton removeButton = new JButton("Remove");
		editButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	removeClick();
            }
        });
		c.gridx = 2;
		c.weightx = 0.25;
		add(removeButton, c);
		
	}
	
	protected abstract void lookupClick();
	
	protected abstract void addClick();
	
	protected abstract void editClick();
	
	protected abstract void removeClick();
}