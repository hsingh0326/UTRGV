/*Harsimranjeet Singh
CSCI 3326 Java
*/
package Homework3;

import java.io.*;
import java.util.*;

public class Customers 
{
	int nm=0;
	Member[] Members = new Member[100];

	public void carmaxMembers() throws FileNotFoundException 
	{
		for(int i=0;i<100;i++)
		{
			Members[i]=new Member();
		}
		
		File textfile = new File("customers.txt");
		Scanner in=new Scanner(textfile);
	
		while (in.hasNextLine()) 
		{
			String line = in.nextLine();
			StringTokenizer str = new StringTokenizer(line, "/");
			while (str.hasMoreTokens()) 
			{
				Members[nm].id = str.nextToken();
				Members[nm].pwd = str.nextToken();
				Members[nm].fn = str.nextToken();
				Members[nm].ln = str.nextToken();
				Members[nm].email = str.nextToken();
			}
			nm++;
		}
	}
	

	public void display() 
	{
		System.out.println("Id" +"  " + "Password" + "  " + "First Name" + "  " + "Last Name" + "  " + "Email");
		for (int i = 0; i < nm; i++) 
		{
			System.out.println(Members[i].id + " " + Members[i].pwd + " " + Members[i].fn + " " + Members[i].ln + " "
					+ Members[i].email);
		}
		System.out.println(nm);
	}

	public void save() throws FileNotFoundException 
	{
		PrintWriter op = new PrintWriter("customers.txt");

		for (int i = 0; i < nm; i++) 
		{
			op.println(Members[i].id + "/" + Members[i].pwd + "/" + Members[i].fn + "/" + Members[i].ln + "/"
					+ Members[i].email);
		}

		op.close();

	}
	
	public void signup()
	{
		Scanner in=new Scanner(System.in);
		boolean t=false;
		while(t==false)
		{
			System.out.println("Enter id: ");
			Members[nm].id=in.next();
			System.out.println("Enter password: ");
			String password=in.next();
			System.out.println("Re enter Password: ");
			String pwdretry=in.next();
			if(password.equals(pwdretry))
			{
				Members[nm].pwd=password;
				System.out.println("Enter first name: ");
				Members[nm].fn=in.next();
				System.out.println("Enter last name: ");
				Members[nm].ln=in.next();
				System.out.println("Enter mail: ");
				Members[nm].email=in.next();
				t=true;
				nm++;
			}
			
			else
			{
				System.out.println("Unmatched password");
			}
		}
		
		if(t==true)
		{
			System.out.println("Sign up successful");
		}
	}
	
	public int login(String tempid,String temppwd)
	{
		Scanner in=new Scanner(System.in);
		int i=0;
		boolean exist=false;
			for(i=0;i<nm;i++)
			{
				if(Members[i].id.equals(tempid) && Members[i].pwd.equals(temppwd))
				{
					exist=true;
					break;
				}
			}
			
			if(exist==false)
			{
				System.out.println("The User Login or password not found in the System");
				return 1;
			}
			
			else
			{
				return i;
			}
	}
	
	public void adduser()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter id: ");
		Members[nm].id=in.next();
		System.out.println("Enter password: ");
		Members[nm].pwd=in.next();
		System.out.println("Enter first name: ");
		Members[nm].fn=in.next();
		System.out.println("Enter last name: ");
		Members[nm].ln=in.next();
		System.out.println("Enter email: ");
		Members[nm].email=in.next();
		
		System.out.println("Id" +"  " + "Password" + "  " + "First Name" + "  " + "Last Name" + "  " + "Email");
		
		System.out.println(Members[nm].id+ "/"+ Members[nm].pwd+"/"+Members[nm].fn+"/"+ Members[nm].ln+"/"+Members[nm].email);
		nm++;
		
		System.out.println("This user has been successfully added!");
	}

	public void deleteuser()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter id: ");
		String id=in.next();
		
		int postion=0;
		for(int i=0;i<nm;i++)
		{
			if(Members[i].id.equals(id))
			{
				postion=i;
				break;
			}
		}
		
		for(int i=postion;i<nm;i++)
		{
			Members[i].id=Members[i+1].id;
			Members[i].pwd=Members[i+1].pwd;
			Members[i].fn=Members[i+1].fn;
			Members[i].ln=Members[i+1].ln;
			Members[i].email=Members[i+1].email;
		}
		nm--;
		System.out.println(id+" "+ "deleted!");
	}
	
	public void updateuser()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter id: ");
		String id=in.next();
		
		int i=0;
		for(i=0;i<nm;i++)
		{
			if(Members[i].id.equals(id))
				break;
		}
		
		System.out.println("1. Update password");
		System.out.println("2. Update first name");
		System.out.println("3. Update last name");
		System.out.println("4. Update email");
		int c=in.nextInt();
		
		if(c==1)
		{
			boolean t=false;
			while(t=false)
			{
				System.out.println("Enter password: ");
				String p1=in.next();
				System.out.println("Re enter password: ");
				String p2=in.next();
				if(p1.equals(p2))
				{
					t=true;
					Members[i].pwd=p1;
					System.out.println("successfully updated");
				}
			}		
		}
		else if(c==2)
		{
			System.out.println("Enter first name: ");
			Members[i].fn=in.next();
			System.out.println("successfully updated");
		}
		else if(c==3)
		{
			System.out.println("Enter last name: ");
			Members[i].ln=in.next();
			System.out.println("successfully updated");
		}
		
		else if(c==4)
		{
			System.out.println("Enter email: ");
			Members[i].email=in.next();
			System.out.println("successfully updated");
		}
		
	}
	
	public void setw(int n)
	{
		for(int i=0;i<n;i++)
		System.out.print(" ");
	}
}

