package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TutorSession 
{
	TutorSession(){}
	
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
	
	public static ArrayList<String> getSessionsByStudentName(String name) 
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
			PreparedStatement get = connection.prepareStatement("SELECT s1.firstname,  s1.lastname, t1.firstname,  t1.lastname, s.dates, s3.subjectName FROM sessions s \r\n"
					+ "LEFT JOIN students s1 ON s.StudentID = s1.StudentID\r\n"
					+ "LEFT JOIN tutors t1 ON s.TutorID = t1.TutorID\r\n"
					+ "LEFT JOIN subjects s3 ON s.SubjectID = s3.SubjectID\r\n"
					+ "WHERE s1.firstname like ? AND s1.lastname LIKE ?");
			get.setString(1, "%" + firstName + "%");
			get.setString(2, "%" + lastName + "%");
			

			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String studentFirstName = result.getString("s1.firstname");
				String studentLastName = result.getString("s1.lastname");
				String tutorFirstName = result.getString("t1.firstname");
				String tutorLastName = result.getString("t1.lastname");
				String date = result.getString("s.dates");
				String subject = result.getString("s3.subjectName");
				String studentName = studentFirstName + " " + studentLastName;
				String tutorName = tutorFirstName + " " + tutorLastName;

				arr.add(studentName);
				arr.add(tutorName);
				arr.add(date);
				arr.add(subject);
			}
		return arr;	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;	
	}

	public static ArrayList<String> getSessionsByTutorName(String name) 
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
			PreparedStatement get = connection.prepareStatement("SELECT s1.firstname, s1.lastname, t1.firstname, t1.lastname, s.dates, s3.subjectName FROM sessions s \r\n"
					+ "LEFT JOIN students s1 ON s.StudentID = s1.StudentID\r\n"
					+ "LEFT JOIN tutors t1 ON s.TutorID = t1.TutorID\r\n"
					+ "LEFT JOIN subjects s3 ON s.SubjectID = s3.SubjectID\r\n"
					+ "WHERE t1.firstname like ? AND t1.lastname like ?");
			get.setString(1, "%" + firstName + "%");
			get.setString(2, "%" + lastName + "%");
			

			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String studentFirstName = result.getString("s1.firstname");
				String studentLastName = result.getString("s1.lastname");
				String tutorFirstName = result.getString("t1.firstname");
				String tutorLastName = result.getString("t1.lastname");
				String date = result.getString("s.dates");
				String subject = result.getString("s3.subjectName");
				String studentName = studentFirstName + " " + studentLastName;
				String tutorName = tutorFirstName + " " + tutorLastName;
		
				arr.add(studentName);
				arr.add(tutorName);
				arr.add(date);
				arr.add(subject);
			}
		return arr;	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	
	public static ArrayList<String> getSessionsBySubject(String subject) 
	{
		
		
		
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT s1.firstname,s1.lastname,t1.firstname, t1.lastname, s.dates, s3.subjectName FROM sessions s \r\n"
					+ "LEFT JOIN students s1 ON s.StudentID = s1.StudentID\r\n"
					+ "LEFT JOIN tutors t1 ON s.TutorID = t1.TutorID\r\n"
					+ "LEFT JOIN subjects s3 ON s.SubjectID = s3.SubjectID\r\n"
					+ "WHERE s3.subjectName like ?");
			get.setString(1, "%" + subject + "%");
			

			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				
				String studentFirstName = result.getString("s1.firstname");
				String studentLastName = result.getString("s1.lastname");
				String tutorFirstName = result.getString("t1.firstname");
				String tutorLastName = result.getString("t1.lastname");
				String date = result.getString("s.dates");
				String subjects = result.getString("s3.subjectName");
				
				String studentName = studentFirstName + " " + studentLastName;
				String tutorName = tutorFirstName + " " + tutorLastName;
		
				arr.add(studentName);
				arr.add(tutorName);
				arr.add(date);
				arr.add(subjects);
			}
			
			
			
			
			return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
	}

	
	public static ArrayList<String> getSessionsByDate(String date) 
	{
		
		
		try
		{
			Connection connection = getConnection();
			PreparedStatement get = connection.prepareStatement("SELECT s1.firstname, s1.lastname, t1.firstname, t1.lastname, s.dates, s3.subjectName FROM sessions s \r\n"
					+ "LEFT JOIN students s1 ON s.StudentID = s1.StudentID\r\n"
					+ "LEFT JOIN tutors t1 ON s.TutorID = t1.TutorID\r\n"
					+ "LEFT JOIN subjects s3 ON s.SubjectID = s3.SubjectID\r\n"
					+ "WHERE s.dates like ?");
			get.setString(1, "%" + date + "%");

			ResultSet result = get.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String>();
			while(result.next())
			{
				String studentFirstName = result.getString("s1.firstname");
				String studentLastName = result.getString("s1.lastname");
				String tutorFirstName = result.getString("t1.firstname");
				String tutorLastName = result.getString("t1.lastname");
				String dates = result.getString("s.dates");
				String subject = result.getString("s3.subjectName");
				
				String studentName = studentFirstName + " " + studentLastName;
				String tutorName = tutorFirstName + " " + tutorLastName;
		
				arr.add(studentName);
				arr.add(tutorName);
				arr.add(date);
				arr.add(subject);
			}	
		return arr;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	
	
	public static void add(String tutorname,
						   String student,
						   String subject,
						   String month,
						   String day,
						   String year) 
	{
		
		
		String tutorid = Tutor.getID(tutorname);
		String studentid = Student.getID(student);

		String subjectid = Subject.getID(subject);
		String date = year + "-" + month + "-" + day;
		
		try
		{
			Connection connection = getConnection();
			
			PreparedStatement posted = connection.prepareStatement(
					"INSERT INTO sessions (TutorID, StudentID, SubjectID, dates) VALUES ('"+tutorid+"', '"+studentid+"',' "+subjectid+" ',' "+date+"')");
			posted.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Inserted!");
		}
		
		
		
		
	}

	public static void update(String selectedItem,
							 String tutorname,
							 String student,
							 String subject,
							 String month,
							 String day,
							 String year) 
	{
		try
		{
			String str = selectedItem.toString();
			int id = Integer.parseInt(str);
			Connection connection = getConnection();
			
			String tutorid = Tutor.getID(tutorname);
			String studentid = Student.getID(student);

			String subjectid = Subject.getID(subject);
			String date = year + "-" + month + "-" + day;
			
			
			PreparedStatement posted = connection.prepareStatement("UPDATE sessions SET TutorID = ?, StudentID = ?, SubjectID = ?, dates = ?  WHERE SessionID = ? ");
			posted.setString(1, tutorid);
			posted.setString(2, studentid);
			posted.setString(3, subjectid);
			posted.setString(4, date);
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

	public static void remove(Object selectedItem) 
	{
		try
		{
			String str = selectedItem.toString();
			
			int id =Integer.parseInt(str);
			
			Connection connection = getConnection();
			
			PreparedStatement posted = connection.prepareStatement("DELETE FROM sessions WHERE StudentID = ?");
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
	
	
	
	
	
}
