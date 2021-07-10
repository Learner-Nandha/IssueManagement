package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SignIn 
{
	public String user() 
	{
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String userName = in.nextLine();
		
		System.out.println("Enter Password:");
		String userPass = in.nextLine();
		
		
		
		if(userName.equalsIgnoreCase("admin") && userPass.equals("1234"))
		{
			System.out.println("Welcome Admin...!!!");
			return null;
			
		}
		else if(CheckUser(userName,userPass)) 
		{
			System.out.println("Login Successfully...");
			return userName;
		}
		else 
		{
			System.out.println("Enter the email and password correctly...");
			return user();
		}
		
	}
	
	private boolean CheckUser(String userName, String userPass) 
	{
		boolean st = false;
		try 
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("select * from registeruser where username=? and pass=?");
			
			ps.setString(1, userName);
			ps.setString(2, userPass);
			
			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return st;
		
	}
	
}
