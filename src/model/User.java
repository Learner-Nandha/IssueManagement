package model;

import java.util.Scanner;

import service.IssueRaiser;
import service.IssueView;

public class User 
{
	int val;
	public User(int val)
	{
		this.val=val;
	}
	public void issue() throws Exception
	{
		Scanner scan = new Scanner(System.in);
			
		System.out.println("Enter 1 to raise issue\nEnter 2 to view previous issues");
		byte choice = scan.nextByte();
		
		if(choice == 1)
		{
			IssueRaiser raise = new IssueRaiser(val);
			issue();
		}
		else
		{
			IssueView view = new IssueView(val);
			view.show();
		}
		
	}
}
