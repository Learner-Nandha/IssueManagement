package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class SignUp 
{
	public void user() throws Exception
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String userName = in.nextLine();
		
		System.out.println("Enter Email:");
		String userEmail = in.nextLine();
		
		System.out.println("Enter Password:");
		String userPass = in.nextLine();
		
		if(CheckUser(userName,userEmail) ) 
		{
			System.out.println("Username and Useremail already exists...");
			System.out.println("Enter another username and email..");
			user();
		}
		else 
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa", "root", "root");

				PreparedStatement ps = con.prepareStatement("insert into registeruser values(?,?,?)");

				ps.setString(1, userName);
				ps.setString(2, userEmail);
				ps.setString(3, userPass);

				ps.executeUpdate();

			} 
			finally 
			{
				System.out.println("You are successfully registered...");
			}
		}
	}

	private boolean CheckUser(String userName,String userEmail) throws Exception
	{
		boolean st = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("select * from registeruser where username=? and email=?");
			ps.setString(1, userName);
			ps.setString(1, userEmail);
			
			
			ps.executeQuery();
			
		} 
		finally
		{
		return st;
		}
	}
}
