package Homework3;

import java.util.*;

public class Member 
{
	Scanner in=new Scanner(System.in);
	String id;
	String pwd;
	String fn;
	String ln;
	String email;
	
	public String getid()
	{
		System.out.println("Enter id: ");
		return in.next();
	}
	
	public String getpwd()
	{
		System.out.println("Enter password: ");
		return in.next();
	}
	
	public String getfn()
	{
		System.out.println("Enter first name: ");
		return in.next();
	}
	
	public String getln()
	{
		System.out.println("Enter last name: ");
		return in.next();
	}
	
	public String getemail()
	{
		System.out.println("Enter email: ");
		return in.next();
	}
}
