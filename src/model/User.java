package model;

import java.util.Scanner;

import service.IssueDelete;
import service.IssueRaiser;
import service.IssueView;

public class User 
{
	int userId;
	public User(int userId)
	{
		this.userId=userId;
	}
	public void issue() throws Exception
	{
		Scanner scan = new Scanner(System.in);
			
		System.out.println("Enter 1 to raise issue\nEnter 2 to view previous issues\nEnter 3 to delete issues");
		byte choice = scan.nextByte();
		
		if(choice == 1)
		{
			IssueRaiser raise = new IssueRaiser(userId);
			issue();
		}
		else if(choice == 3)
		{
			IssueView view = new IssueView(userId);
			view.show();
			
			System.out.println("Enter the issue Id:");
			int issueId = scan.nextInt();
			
			IssueDelete delete = new IssueDelete(issueId);
			delete.delete();
			
			issue();
		}
		else
		{
			IssueView view = new IssueView(userId);
			view.show();
		}
		
	}
}
