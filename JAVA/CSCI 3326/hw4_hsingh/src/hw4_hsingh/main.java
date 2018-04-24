package hw4_hsingh;

// Harsimranjeet Singh
// CSCI 3326 JAVA

import javax.swing.*;
import java.awt.event.*;
import  java.sql.*;
import java.util.*;
public class main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Scanner in = new Scanner(System.in);
		int userchoice = 0;
				
        String userid;
        String userpass;
        String passcheck;
        String firstName;
        String lastName;
        String email;
        
        String vin;
        String brand;
        String model;
        int year;
        int mileage;
        int price;
        String color;
        
        String adminUser= "adminid";
		String adminPass = "adminpass";

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr= "104.197.183.40:3306/db37";
		
		String s1="jdbc:mysql://" + addr;
		Connection connection= DriverManager.getConnection(s1,"user37","2928");
		
		Statement st=(Statement) connection.createStatement();
		ResultSet rs;
		
		while(true)
		{
			login_display();
			userchoice= in.nextInt(); //takes the num of the main menu
			in.nextLine(); //to remove the enter 
			System.out.println();
			
			if(userchoice == 3) //exit
			{
				break;
			}
			
			
			
			else if (userchoice == 1) //login
			{
				
				String logpass;
                String login;
                
                System.out.print("ID: ");
                login = in.nextLine();
                
                System.out.print("Password: ");
                logpass = in.nextLine();
               
                if (login.equals(adminUser) && logpass.equals(adminPass))
                {
                	while (true)
                	{
                    System.out.println("Welcome back ADMIN");
                    System.out.println();
                    admin_menu();
                    
                    userchoice= in .nextInt(); 
        			in.nextLine(); 
        			
        			if (userchoice == 1)
        			{
        				System.out.println("Displaying cars...");
        				System.out.println();
 
        				 rs = st.executeQuery("select * from cars");
        					
        					while(rs.next())
        					{
        						System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
        					}
        					System.out.println();
        					
        			}
        			else if(userchoice == 2) //adding car
        			{
        				System.out.print("Vin:");
        				vin = in.nextLine();
        				System.out.print("Brand:");
        				brand = in.nextLine();
        				System.out.print("Model:");
        				model = in.nextLine();
        				System.out.print("Year:");
        				year = in.nextInt();
        				System.out.print("Mileage:");
        				mileage = in.nextInt();
        				System.out.print("Price:");
        				price = in.nextInt();
        				System.out.print("Color:");
        				color = in.nextLine();
        				System.out.println();
        				
        				String stringstr= "INSERT INTO cars (vin,brand,model,year,mileage,price,color)"+ "VALUES(?,?,?,?,?,?,?)";
        				PreparedStatement ps = connection.prepareStatement(stringstr);
        				
        				ps.setString(1, vin);
						ps.setString(2, brand);
						ps.setString(3, model);
						ps.setInt(4, year);
						ps.setInt(5, mileage);
						ps.setInt(6, price);
						ps.setString(7,color);
						ps.executeUpdate();
						
						
						System.out.println("VIN\tBrand\tModel\tYear\tMileage\tPrice\tColor");
						System.out.println(vin + "\t" + brand + "\t" + model + "\t" + year + "\t" + mileage + "\t" + price + "\t" + color ); 
						System.out.println("The car " + brand+ " was added.");
						System.out.println();
     					
     					
        			}
        			else if (userchoice ==3)   //delete car
        			{
        				String vininput;
        				System.out.print("Please input the VIN : ");
						vininput = in.nextLine();
						System.out.println(vininput);
        					
						PreparedStatement ps = connection.prepareStatement("delete from cars where vin = ?");
						ps.setString(1, vininput);
						ps.executeUpdate();
						
						System.out.println("This car has been succesfully deleted.");
						System.out.println();
						
        			}
                    else if (userchoice == 4)//update car
                    {
                    	
                    	
                    	rs=st.executeQuery("SELECT * from cars;");
                    	while(rs.next())
						{
							System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
						}
                    	
                    	System.out.println();
                    	
                    	
                    	String vininput;
                    	System.out.print("Please input VIN:");
                    	vininput= in.nextLine();
                    	
                    	updateCars(); //display menu
                    	
                    	userchoice= in.nextInt(); 
            			in.nextLine();
            			
            			if(userchoice ==1) //update brand
            			{
            				
            				System.out.print("Please input brand:");
            				brand=in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE cars SET brand = ? where vin = ?;");
							ps.setString(1, brand);
							ps.setString(2, vininput);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            				
							rs=st.executeQuery("SELECT * from cars;");
							while(rs.next())
							{
								System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
							}
							System.out.println();
            			}
            			else if (userchoice == 2) // update model
            			{
            				
            				System.out.print("Please input model:");
            				model=in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE cars SET model = ? where vin = ?;");
							ps.setString(1, model);
							ps.setString(2, vininput);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            			
							while(rs.next())
							{
								System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
							}
							System.out.println();
            			}
            			else if (userchoice == 3) // update year
            			{
            				int year1;
            				System.out.print("Please input year:");
            				year1=in.nextInt();
            				PreparedStatement ps = connection.prepareStatement("UPDATE cars SET year = ? where vin = ?;");
							ps.setInt(1, year1);
							ps.setString(2, vininput);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            			
            			}
            			else if (userchoice == 4) // update mileage
            			{
            				int mileage1;
            				System.out.print("Please input mileage:");
            				mileage1=in.nextInt();
            				PreparedStatement ps = connection.prepareStatement("UPDATE cars SET mileage = ? where vin = ?;");
							ps.setInt(1, mileage1);
							ps.setString(2, vininput);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            			
            			}
            			else if (userchoice == 5) // update price
            			{
            				int price1;
            				System.out.print("Please input price:");
            				price1=in.nextInt();
            				PreparedStatement ps = connection.prepareStatement("UPDATE cars SET price = ? where vin = ?;");
							ps.setInt(1, price1);
							ps.setString(2, vininput);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            			
            			}
            			else if (userchoice == 6) // update color
            			{
            				String color1;
            				System.out.print("Please input color:");
            				color1=in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE cars SET color = ? where vin = ?;");
							ps.setString(1, color1);
							ps.setString(2, vininput);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            			
            			}
                    }	            			
            		else if (userchoice == 5) //display users
            		{
            			System.out.println("Displaying users...");
        				System.out.println();
        				
        				System.out.println("ID\tPassword\tFirst Name\tLast Name\tEmail");
        				 rs = st.executeQuery("SELECT * from users");
        					
        					while(rs.next())
        					{
        						System.out.println(rs.getString("userid") + "\t" + rs.getString("password") + "\t\t" + rs.getString("firstname") + "\t\t" + rs.getString("lastname") +"\t\t"+ rs.getString("email"));
        					}
        					System.out.println();
        					
            		}
            		else if (userchoice == 6) //add user
            		{
            			System.out.print("ID:");
        				userid = in.nextLine();
        				System.out.print("Password:");
        				userpass = in.nextLine();
        				System.out.print("First Name:");
        				firstName = in.nextLine();
        				System.out.print("Last Name:");
        				lastName = in.nextLine();
        				System.out.print("Email:");
        				email = in.nextLine();

        				System.out.println();
        			
        				PreparedStatement ps = connection.prepareStatement("INSERT INTO users (userid,password,firstname,lastname,email)"+ "VALUES(?,?,?,?,?)");
        				
        				ps.setString(1, userid);
						ps.setString(2, userpass);
						ps.setString(3, firstName);
						ps.setString(4, lastName);
						ps.setString(5, email);
						ps.executeUpdate();
						
						
						System.out.println("ID\tPASS\tName\tLastN\tEmail");
						System.out.println(userid + "\t" + userpass + "\t" + firstName + "\t" + lastName + "\t" + email ); 
						System.out.println("User " + firstName+ " was added.");
						System.out.println();
            		}
            		else if (userchoice == 7) //delete user
            		{
            			String userdelete;
        				System.out.print("Please input the ID of the user that you want to delete: ");
						userdelete = in.nextLine();
						System.out.println(userdelete);
        					
						PreparedStatement ps = connection.prepareStatement("delete from users where userid = ?");
						ps.setString(1, userdelete);
						ps.executeUpdate();
						
						System.out.println("This user has been succesfully deleted.");
						System.out.println();
            		}
            		else if (userchoice == 8)//update user
            		{
            			rs=st.executeQuery("SELECT * from users;");
                    	while(rs.next())
						{
                    		System.out.println(rs.getString("userid") + "\t" + rs.getString("password") + "\t" + rs.getString("firstname") + "\t\t" + rs.getString("lastname") +"\t\t"+ rs.getString("email"));
						}
                    	
                    	System.out.println();
                    	
                    	
                    	String userupdate;
                    	System.out.print("Please input ID:");
                    	userupdate= in.nextLine();
                    	
                    	updateUsers(); //display menu
                    	
                    	userchoice= in.nextInt(); 
            			in.nextLine();
            			if (userchoice == 1) //update password
            			{
            				
            				System.out.print("Please input password: ");
            				userpass= in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE users SET password = ? where id = ?;");
							ps.setString(1, userpass);
							ps.setString(2, userupdate);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            				
            			}
            			else if (userchoice == 2) //update first name
            			{
            				
            				System.out.print("Please input First Name: ");
            				firstName=in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE users SET firstname = ? where userid = ?;");
							ps.setString(1, firstName);
							ps.setString(2, userupdate);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            				
            			}
            			else if (userchoice == 3) //update last name
            			{
            			
            				System.out.print("Please input Last Name:");
            				lastName=in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE users SET lastname = ? where userid = ?;");
							ps.setString(1, lastName);
							ps.setString(2, userupdate);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            				
            			}
            			else if (userchoice == 4) //update email
            			{
            				String emailupdate;
            				System.out.print("Please input email:");
            				emailupdate=in.nextLine();
            				PreparedStatement ps = connection.prepareStatement("UPDATE users SET email = ? where userid = ?;");
							ps.setString(1, emailupdate);
							ps.setString(2, userupdate);
							ps.executeUpdate();
							System.out.println("It has been updated. Thank you!");
							System.out.println();
            			}
            		}
                    else if (userchoice == 9)
                    {
                    	break;
                    }
                    else
                    {
                    	System.out.println("Wrong Input...");
                    }
                	}
                }                
                	
               //// THIS IS THE END OF ADMIN FUNTION 
			
                else if(!(login.equals(adminUser) && logpass.equals(adminPass)))
                    {
                    	while (true)
                    	{
                        System.out.println("Welcome back ");
                        System.out.println();
                        user_menu();
                        
                        userchoice= in.nextInt(); 
            			in.nextLine(); 
            			
    	        			if (userchoice == 1) //display inventory
    	        			{
    	        				System.out.println("Displaying cars...");
    	        				System.out.println();
    	 
    	        				 rs = st.executeQuery("select * from cars");
    	        					
    	        					while(rs.next())
    	        					{
    	        						System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    	        					}
    	        					System.out.println();
    	        			}
    	        			else if(userchoice == 2) //sort cars
    	        			{
    	        				 Sort_Cars();
    	        				 userchoice= in.nextInt(); 
    	             			in.nextLine(); 
    	             			
    	             			if (userchoice == 1) //sort by vin
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY vin DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			}
    	             			else if (userchoice == 2) //sort by brand
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY brand DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			}
    	             			else if (userchoice == 3) //sort by model
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY model DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			} 
    	             			else if (userchoice == 4) //sort by year
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY year DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			}
    	             			else if (userchoice == 5) //sort by mileage
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY mileage DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			}
    	             			else if (userchoice == 6) //sort by price
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY price DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			}
    	             			else if (userchoice == 7) //sort by color
    	             			{
    	             				rs = st.executeQuery("select * from cars ORDER BY color DESC;");
    	             				
    	             				while(rs.next())
    								{
    									System.out.println(rs.getString("vin") + "\t" + rs.getString("brand") + "\t" + rs.getString("model") + "\t" + rs.getString("year") +"\t"+ rs.getString("mileage") + "\t" + rs.getString("price") + "\t" + rs.getString("color"));
    								}
    	             			}
    	             			else
    	             			{
    	             				System.out.println("Wrong input...");
    	             			}
    	        			}
    	        			else if(userchoice == 3) //log out
    	        			{
    	        				break;
    	        			}
    	        			else
    	        			{
    	        				System.out.println("Wrong input ....");
    	        			}
                    	} 	//CLOSE WHILE
                    	
                   } //CLOSE IF
			
			}
		
		    
                
		
	
			else if (userchoice == 2) //sign up
			{
                System.out.print("ID: ");
                userid = in.nextLine();

                System.out.print("Password: ");
                userpass = in.nextLine();

                System.out.print("Password again: ");
                passcheck = in.nextLine();
    
                System.out.print("First Name: ");
                firstName = in.nextLine();

                System.out.print("Last Name: ");
                lastName = in.nextLine();

                System.out.print("Email: ");
                email = in.nextLine();
                
                PreparedStatement ps = connection.prepareStatement("INSERT INTO users (userid,password,firstname,lastname,email)"+ "VALUES(?,?,?,?,?)");
				
				ps.setString(1, userid);
				ps.setString(2, passcheck);
				ps.setString(3, firstName);
				ps.setString(4, lastName);
				ps.setString(5, email);
				ps.executeUpdate();
				
				
				System.out.println("ID\tPASS\tName\tLastN\tEmail");
				System.out.println(userid + "\t" + passcheck + "\t" + firstName + "\t" + lastName + "\t" + email ); 
				System.out.println( firstName+ ", you were added.");
				System.out.println();
                
                
			}
        			
			else
			{
				System.out.println("Wrong input....");
			}
			
			
      	
		
			
			
		}
		
	}
                        	
		
	//menus
	public static void Sort_Cars() {
	    System.out.println("Sort Cars");
	    System.out.println("1. Sort by VIN");
	    System.out.println("2. Sort by Brand");
	    System.out.println("3. Sort by Model");
	    System.out.println("4. Sort by Year");
	    System.out.println("5. Sort by Mileage ");
	    System.out.println("6. Sort by Price ");
	    System.out.println("7. Sort by Color ");
	    
	    System.out.print("Please input:");
	}

	public static void admin_menu() {
	    System.out.println("1. Display inventory");
	    System.out.println("2. Add Car");
	    System.out.println("3. Delete Car");
	    System.out.println("4. Update Car");
	    System.out.println("5. Display Users");
	    System.out.println("6. Add User");
	    System.out.println("7. Delete User");
	    System.out.println("8. Update User");
	    System.out.println("9. Logout");
	    System.out.print("Please enter input: ");
	}

	  public static void login_display() {
	        System.out.println("Welcome to Carmax!");
	        System.out.println("1.Login");
	        System.out.println("2.Signup");
	        System.out.println("3.Exit");
	        System.out.print("Please enter input: ");
	    }
	  
	  public static void updateCars() {
	        System.out.println("1. Update brand:");
	        System.out.println("2. Update model:");
	        System.out.println("3. Update year:");
	        System.out.println("4. Update mileage:");
	        System.out.println("5. Update price:");
	        System.out.println("6. Update color:");
	        System.out.print("Please enter input: ");
	    }
	  public static void updateUsers() {
	        System.out.println("1. Update password:");
	        System.out.println("2. Update first name:");
	        System.out.println("3. Update last name:");
	        System.out.println("4. Update email:");
	        System.out.print("Please enter input: ");
	    }
	  public static void user_menu() {
	        System.out.println("Welcome to Carmax!");
	        System.out.println("1. Display inventory");
	        System.out.println("2. Sort cars");
	        System.out.println("3. Log out");
	        System.out.print("Please enter input: ");
	    }
	
}