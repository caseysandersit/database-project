package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Subject 
{
	
	Subject(){}
	
	
	public static Connection getConnection() throws Exception
	{
		try 
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tutoringprogram"; 
			String username = "root";
			String password = "password";
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username,password);
			
			return connection;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	public static String[] getSubjects() 
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT subjectName FROM subjects ");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String name = result.getString("subjectName");
				
	
				arr.add(name);
			}
			String[] array = new String[arr.size()];
			
			array = arr.toArray(array);
			
			return array;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
		
	}


	public static String getID(String subject) 
	{
		String id = "none";
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT SubjectID FROM subjects WHERE subjectName = ?");
			get.setString(1, subject);
			ResultSet result = get.executeQuery();
			
			while(result.next())
			{
			
			id = result.getString("SubjectID");
			}
				
			return id;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}
	
	
	

}
