package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import service.IssueProcessor;

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
			
			System.out.println("-------------------------NEW  ISSUES-------------------------");
			System.out.println(" IssueId | UserId |      Issue      | IssueLocation | Status ");
			System.out.println("-------------------------------------------------------------");
			
			while (rs.next()) 
			{
				System.out.println(rs.getInt("issueid")+" | "+rs.getInt("userid")+" | "+rs.getString("issue")+" | "+rs.getString("issuelocation")+" | "+rs.getString("status"));
			}
			
			
			Statement qs = con.createStatement();
			qs.execute("update issue set status='processing...' where status='new'");
			
			rs.close();
			
			IssueProcessor issueprocessor = new IssueProcessor();
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}