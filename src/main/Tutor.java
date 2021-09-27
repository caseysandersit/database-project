package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Tutor 
{

	Tutor(){}
	
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
			PreparedStatement get = connection.prepareStatement("SELECT TutorID FROM tutors ");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String id = result.getString("TutorID");
				
	
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

	public static String[] getNames() 
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname FROM tutors ");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstName = result.getString("firstname");
				String lastName = result.getString("lastname");
				
	
				arr.add(firstName + " " + lastName);
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

	
	public static ArrayList<String> getTutorsByName(String name) 
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
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, emailaddress, phonenumber, status, certDate FROM tutors WHERE  firstname LIKE ? AND lastname LIKE ?");
			get.setString(1, "%" + firstName + "%");
			get.setString(2, "%" + lastName + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("emailaddress");
				String phone = result.getString("phonenumber");
				String status = result.getString("status");
				String certDate = result.getString("certDate");

				String tutorName = firstname + " " + lastname;
				
				arr.add(tutorName);
				arr.add(email);
				arr.add(phone);
				arr.add(status);
				arr.add(certDate);
			}
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}

	
	
	public static ArrayList<String> getTutorsByCertDate(String date) 
	{
		
		
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, emailaddress, phonenumber, status, certDate FROM tutors WHERE certDate like ?");
			get.setString(1, "%" + date + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("emailaddress");
				String phone = result.getString("phonenumber");
				String status = result.getString("status");
				String certDate = result.getString("certDate");
				String tutorName = firstname + " " + lastname;

				
				arr.add(tutorName);
				arr.add(email);
				arr.add(phone);
				arr.add(status);
				arr.add(certDate);
			}
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}

	
	public static ArrayList<String> getTutorsByStatus(String status) 
	{
	
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, emailaddress, phonenumber, status, certDate FROM tutors WHERE status like ?");
			get.setString(1, "%" + status + "%");
	
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("emailaddress");
				String phone = result.getString("phonenumber");
				String statuss = result.getString("status");
				String certDate = result.getString("certDate");
				String tutorName = firstname + " " + lastname;

				
				arr.add(tutorName);
				arr.add(email);
				arr.add(phone);
				arr.add(statuss);
				arr.add(certDate);
			}
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}

	
	
	public static ArrayList<String> getTutorsByPhone(String phone) 
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, emailaddress, phonenumber, status, certDate FROM tutors WHERE phonenumber like ?");
			get.setString(1, "%" + phone + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("emailaddress");
				String phonee = result.getString("phonenumber");
				String status = result.getString("status");
				String certDate = result.getString("certDate");
				String tutorName = firstname + " " + lastname;
				
				arr.add(tutorName);
				arr.add(email);
				arr.add(phonee);
				arr.add(status);
				arr.add(certDate);
			}
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}

	
	public static ArrayList<String> getTutorsByEmail(String email) 
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT firstname, lastname, emailaddress, phonenumber, status, certDate FROM tutors WHERE emailaddress like ?");
			get.setString(1, "%" + email + "%");
			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String emaill = result.getString("emailaddress");
				String phonee = result.getString("phonenumber");
				String status = result.getString("status");
				String certDate = result.getString("certDate");
				String tutorName = firstname + " " + lastname;
				
				arr.add(tutorName);
				arr.add(emaill);
				arr.add(phonee);
				arr.add(status);
				arr.add(certDate);
			}
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}

	
	public static void add(String name,
						   String certDate,
						   String status,
						   String phone,
						   String email) 
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
					"INSERT INTO tutors (firstname, lastname, emailaddress, phonenumber, status, certDate) VALUES ('"+firstName+"', '"+lastName+"',' "+email+" ',' "+phone+"',' "+status+"',' "+certDate+"')");
			posted.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Inserted!");
		}
		
	}

	
	public static void remove(Object selectedItem) 
	{
		try
		{
			String str = selectedItem.toString();
			
			int id =Integer.parseInt(str);
			
			Connection connection = getConnection();
			
			PreparedStatement posted = connection.prepareStatement("DELETE FROM tutors WHERE TutorID = ?");
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

	
	public static void update(String selectedItem,
							  String name,
							  String certDate,
							  String status,
							  String phone,
							  String email) 
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
			
			
			
			
			
			PreparedStatement posted = connection.prepareStatement("UPDATE tutors SET firstname = ?, lastname = ?, certDate = ?, status = ?, phonenumber = ?, emailaddress = ?  WHERE TutorID = ? ");
			posted.setString(1, firstName);
			posted.setString(2, lastName);
			posted.setString(3, certDate);
			posted.setString(4, status);
			posted.setString(5, phone);
			posted.setString(6, email);
			posted.setInt(7, id);
			posted.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Updated!");
		}
		
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
			PreparedStatement get = connection.prepareStatement("SELECT TutorID FROM tutors WHERE firstname = ? AND lastname = ?");
			get.setString(1, firstName);
			get.setString(2, lastName);
			ResultSet result = get.executeQuery();
			while(result.next())
			{
		
			
			id = result.getString("TutorID");
			
			}
				
			return id;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
		
	}
	
	
	
}
