package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Student 
{
	
	
	Student(){}
	
	
	
	
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



	public static void add(String name, String phone, String email) 
	{
		String[] strarr = name.split(" ");
		String firstName = strarr[0];
		String lastName = "";
		if(strarr.length > 1)
		{
			lastName = strarr[1];
		}
		try
		{
			
			Connection connection = getConnection();
			
			PreparedStatement posted = connection.prepareStatement(
					"INSERT INTO students (firstname, lastname, phonenumber, emailaddress) VALUES ('"+firstName+"', '"+lastName+"', '"+phone+"','"+email+"')");
			posted.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Inserted!");
		}
	}


	
	
	public static ArrayList<String> getStudentsByName(String name)
	{
		
		String[] strarr = name.split(" ");
		String firstName = strarr[0];
		String lastName = "";
		if(strarr.length > 1)
		{
			lastName = strarr[1];
		}
		
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, phonenumber, emailaddress FROM students WHERE firstname LIKE ? AND lastname LIKE ?");
			get.setString(1, "%" + firstName + "%");
			get.setString(2, "%" + lastName + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String phone = result.getString("phonenumber");
				String email = result.getString("emailaddress");
				
				String namee = firstname + " " + lastname;
				
				arr.add(namee);
				arr.add(phone);
				arr.add(email);
			}
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}


	public static ArrayList<String> getStudentsByPhone(String phone) 
	{
	

		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, phonenumber, emailaddress FROM students WHERE phonenumber LIKE ?");
			get.setString(1, "%" + phone + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String phonee = result.getString("phonenumber");
				String email = result.getString("emailaddress");
				
				String namee = firstname + " " + lastname;
				
				arr.add(namee);
				arr.add(phonee);
				arr.add(email);
			}
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}


	public static ArrayList<String> getStudentsByEmail(String email) 
	{

		
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, phonenumber, emailaddress FROM students WHERE emailaddress LIKE ?");
			get.setString(1, "%" + email + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String phonee = result.getString("phonenumber");
				String emaill = result.getString("emailaddress");
				
				String namee = firstname + " " + lastname;
				
				arr.add(namee);
				arr.add(phonee);
				arr.add(emaill);
			}
			
			
			return arr;
			
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
			PreparedStatement get = connection.prepareStatement("SELECT StudentID FROM students ");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String id = result.getString("StudentID");
				
	
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


	//Do not understand at all
	public static void update(String selectedItem, String name, String phone, String email) 
	{
		try
		{
			String str = selectedItem;
			int id = Integer.parseInt(str);
			Connection connection = getConnection();
			
			
			String[] strarr = name.split(" ");
			String firstName = strarr[0];
			String lastName = "";
			if(strarr.length > 1)
			{
				lastName = strarr[1];
			}
			
			
			
			
			
			PreparedStatement posted = connection.prepareStatement("UPDATE students SET firstname = ?, lastname = ?, phonenumber = ?, emailaddress = ?  WHERE StudentID = ? ");
			posted.setString(1, firstName);
			posted.setString(2, lastName);
			posted.setString(3, phone);
			posted.setString(4, email);
			posted.setInt(5, id);
			posted.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Updated!");
		}
	}




	
	
	public static void remove(String selectedItem) 
	{
		try
		{
			String str = selectedItem;
			
			int id =Integer.parseInt(str);
			
			Connection connection = getConnection();
			
			PreparedStatement posted = connection.prepareStatement("DELETE FROM students WHERE StudentID = ?");
			posted.setInt(1, id);
			posted.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Deleted!");
		}
		
	}




	
	public static String[] getNames() 
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname FROM students ");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				
				String name = firstname + " " + lastname;
				
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
		
		
		
	public static String getID(String name) 
	{
		String[] strarr = name.split(" ");
		String firstName = strarr[0];
		String lastName = "";
		if(strarr.length > 1)
		{
			lastName = strarr[1];
		}
		String id = "none";
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT StudentID FROM students WHERE firstname = ? AND lastname = ?");
			get.setString(1, firstName);
			get.setString(2, lastName);
			ResultSet result = get.executeQuery();
			while(result.next())
			{
		
			
			id = result.getString("StudentID");
			
			}
				
			return id;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
		
	}
		
	
	
	
		

}
