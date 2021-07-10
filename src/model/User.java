package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class User 
{
	public User(String userName) throws Exception 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your issue:");
		String issue = sc.nextLine();
		
		System.out.println("Enter the issue location:");
		String issueLocation = sc.nextLine();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa", "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into issue values(?,?,?)");
			
			ps.setString(1, userName);
			ps.setString(2, issue);
			ps.setString(3, issueLocation);

			ps.executeUpdate();
			System.out.println("Your Issue will be Processed and Solved quickly...");
			
		}
		finally
		{
			System.out.println("Thank you...!!!");
		}
	}
}
