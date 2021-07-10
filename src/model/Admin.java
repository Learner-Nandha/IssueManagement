package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin 
{
	public Admin() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa", "root", "root");
			
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select * from issue where status='new'");
			System.out.println("--------------------NEW ISSUES--------------------");
			System.out.println("  username  |  issue  |  issuelocation  ");
			while (rs.next()) 
			{
				System.out.println(rs.getString("username")+" "+rs.getString("issue")+" "+rs.getString("issuelocation"));
			}
			
			
			Statement qs = con.createStatement();
			qs.executeUpdate("update issue set status='processing' where status='new'");
			
			rs.close();
			
		}
		finally
		{
			
		}
	}
}