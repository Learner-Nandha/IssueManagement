package controller;

import model.Admin;
import model.User;
import service.SignUp_Or_SignIn;

public class MainControl 
{
	public static void main(String[] args) throws Exception 
	{
		SignUp_Or_SignIn sign = new SignUp_Or_SignIn();
		String val = sign.value();
		if(val == null)
		{
			Admin admin = new Admin();
		}
		else
		{
			User user = new User(val);
		}
		System.out.println("s");
	}

}
