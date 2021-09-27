package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Session 
{
	Session(){}

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
	
	
	
	public static String[] getIDs() 
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT SessionID FROM sessions ");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String id = result.getString("SessionID");
				
	
				arr.add(id);
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
	
	
	
	
	
	
}
