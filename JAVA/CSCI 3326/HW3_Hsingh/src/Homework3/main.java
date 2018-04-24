/*Harsimranjeet Singh
CSCI 3326 Java
*/
package Homework3;

import java.io.*;
import java.util.*;

public class main 
{
	public static void main(String args[]) throws IOException
	{
		Customers c=new Customers();
		Inventory iv=new Inventory();
		String adminusername="admin";
		String adminpassword="adminpass";
		Scanner in=new Scanner(System.in);
		System.out.println("Welcome to Carmax!");
		c.carmaxMembers();
		iv.inv_cars();
		int userchoice=0; //user first display choice
		while(userchoice!=3) // while user does not choose 3 Exit keep going
		{
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit");
			userchoice=in.nextInt();
			
			if(userchoice==1) // if user choice log in 
			{
					String signinId="";
					String signinPwd="";
					System.out.println("User id: ");
					signinId=in.next(); 			// get id 
					System.out.println("Password: ");
					signinPwd=in.next(); // get password
					if(signinId.equals(adminusername) && signinPwd.equals(adminpassword)) // if id & pasword is equal to admin 
					{
						System.out.println("Welcome Back Admin!");
						int adminchoice=0;           
							
						while(adminchoice!=9) // as long as user uses out of the 9 option run the loop
						{
							System.out.println("1. Display inventory");
							System.out.println("2. Add cars");
							System.out.println("3. Delete Car");
							System.out.println("4. Update Car");
							System.out.println("5. Display users");
							System.out.println("6. Add user");
							System.out.println("7. Update user");
							System.out.println("8. Delete user");
							System.out.println("9. logout");
							adminchoice=in.nextInt();
							// call functions to perform listed tasks
							if(adminchoice==1)
							{
								iv.display();
							}
							else if(adminchoice==2)
							{
								iv.addcar();
							}
							else if(adminchoice==3)
							{
								iv.deletecar();
							}
							else if(adminchoice==4)
							{
								iv.updatecar();
							}
							else if(adminchoice==5)
							{
								c.display();
							}
							else if(adminchoice==6)
							{
								c.adduser();
							}
							else if(adminchoice==7)
							{
								c.updateuser();
							}
							else if(adminchoice==8)
							{
								c.deleteuser();
							}
								
						}
					}
					else	// otherwise give customer option sort , display and exit
					{		
						int custdisplay=c.login(signinId,signinPwd);
						if(custdisplay!=100)
						{
							System.out.println("Welcome back "+ c.Members[custdisplay].fn+c.Members[custdisplay].fn);
							int userchoice2=0;
							while(userchoice2!=3)
							{
								System.out.println("1. Display inventory");
								System.out.println("2. Sort Cars");
								System.out.println("3. Exit");
								userchoice2=in.nextInt();
								// call customer functions
								if(userchoice2==1)
								{
									iv.display();
								}
								
								else if(userchoice2==2)
								{
									iv.sort();
									iv.display(); 
								}
							}
						}
					}
			}
			else if(userchoice==2) // call sign up func
			{
				c.signup();
			}
		}
		
		c.save();
		iv.save();
	}
}

