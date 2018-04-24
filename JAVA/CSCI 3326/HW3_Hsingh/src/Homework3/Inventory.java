/*Harsimranjeet Singh
CSCI 3326 Java
*/
package Homework3;

import java.io.*;
import java.util.*;
import java.util.Formatter;
public class Inventory 
{
	int nc=0; // number of car
	Car [] cars=new Car[100];
	
	public void inv_cars() throws FileNotFoundException 
	{
		for(int i=0;i<100;i++)
			cars[i]=new Car();	//  car array
		
		File textfile=new File("inventory.txt");
		Scanner in=new Scanner(textfile);
		
		while(in.hasNextLine())
		{
			String line=in.nextLine();
			StringTokenizer st=new StringTokenizer(line,"/");
			while(st.hasMoreTokens())
			{
				cars[nc].vin=st.nextToken();
				cars[nc].brand=st.nextToken();
				cars[nc].model=st.nextToken();
				cars[nc].year=Integer.parseInt(st.nextToken());
				cars[nc].mileage=Integer.parseInt(st.nextToken());
				cars[nc].price=Double.parseDouble(st.nextToken());
				cars[nc].colour=st.nextToken();
			}
			nc++;
		}
	}
	
	
	public void display() //Display car inventory
	{
		System.out.println("VIN" + "        " +"Brand"+"  "+ "Model"+"  "+"Year"+"   "+"Mileage"+ "  " +"Price"+"  "+"Colour");
		for(int i=0;i<nc;i++) // print car category of all car nc
		{
			System.out.println(cars[i].vin+"  "+ cars[i].brand+ "    "+ cars[i].model+"  " + cars[i].year+"  "+cars[i].mileage+"  "+cars[i].price+"  "+cars[i].colour);
		}
			System.out.println(nc);
		
		
	}
	
	public void updatecar() //Update Cars
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter vin: ");
		String v=in.next();
		
		int i=0;
		for(i=0;i<nc;i++)             // car vin is same 
		{
			if(cars[i].vin.equals(v))
				{
				
				break;
				}
	
		}
		// update vehicle options
		System.out.println("1. Update brand");
		System.out.println("2. Update model");
		System.out.println("3. Update year");
		System.out.println("4. Update mileage");
		System.out.println("5. Update price");
		System.out.println("6. Update colour");
		int choice=in.nextInt();
		
		if(choice==1)
		{
			System.out.println("Input brand: ");
			cars[i].brand=in.next();
		}
		
		if(choice==2)
		{
			System.out.println("Input model: ");
			cars[i].model=in.next();
		}
		
		if(choice==3)
		{
			System.out.println("Input year: ");
			cars[i].year=in.nextInt();
		}
		
		if(choice==4)
		{
			System.out.println("Input mileage: ");
			cars[i].mileage=in.nextInt();
		}
		
		if(choice==5)
		{
			System.out.println("Input price: ");
			cars[i].price=in.nextDouble();
		}
		
		if(choice==6)
		{
			System.out.println("Input colour: ");
			cars[i].colour=in.next();
		}
		
		System.out.println("Information is updated");
		
	}
	
	public void swap(int j)        // swap the vehicle
	{
		String swap1=cars[j+1].vin;
		cars[j+1].vin=cars[j].vin;			// swap vin numbers
		cars[j].vin=swap1;
		
		String swap2=cars[j+1].brand;
		cars[j+1].brand=cars[j].brand;			// swap brands
		cars[j].brand=swap2;
		
		String swap3=cars[j+1].model;
 		cars[j+1].brand=cars[j].model;   // swap model
		cars[j].model=swap3;
		
		int swap4=cars[j+1].year;
		cars[j+1].year=cars[j].year;		// swap year
		cars[j].year=swap4;
		
		int swap5=cars[j+1].mileage;
		cars[j+1].mileage=cars[j].mileage;			// swap mileage
		cars[j].mileage=swap5;
		
		double car6=cars[j+1].price;
		cars[j+1].price=cars[j].price;			//swap price
		cars[j].price=car6;
		
		String car7=cars[j+1].colour;
		cars[j+1].colour=cars[j].colour;		// swap colour
		cars[j].colour=car7;
		 		
	}
	
	
	//sort refered to sort books function 
	// stackflow.com
	public void sort()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("1. Sort by vin");
		System.out.println("2. Sort by brand");
		System.out.println("3. Sort by model");
		System.out.println("4. Sort by year");
		System.out.println("5. Sort by mileage");
		System.out.println("6. Sort by price");
		System.out.println("7. Sort by colour");
		int choice=in.nextInt();
		if(choice==1)		// sort by vin
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[i].vin.compareTo(cars[j+1].vin);     
					if(ct>0)
					{
						swap(j);
						 		
					}
				}
			}
		}
		
		else if(choice==2)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[j].brand.compareTo(cars[j+1].brand);
					if(ct>0)
					{
						swap(j);
					}
				}
			}
		}
		else if(choice==3)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[j].model.compareTo(cars[j+1].model);
					if(ct>0)
					{
						swap(j);
					}
				}
			}
		}
		
		else if(choice==4)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					if(cars[j].year>cars[j+1].year)
					{
						swap(j); 		
					}
				}
			}
		}
		
		else if(choice==5)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					if(cars[j].mileage>cars[j+1].mileage)
					{
						swap(j); 		
					}
				}
			}
		}
		
		else if(choice==6)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					if(cars[j].price>cars[j+1].price)
					{
						swap(j); 		
					}
				}
			}
		}
		
		else if(choice==7)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[j].colour.compareTo(cars[j+1].colour);
					if(ct>0)
					{
						swap(j); 		
					}
				}
			}
		}
	}
	
	public void save() throws FileNotFoundException // save inventory
	{
		PrintWriter op=new PrintWriter("inventory.txt");
		
		for(int i=0;i<nc;i++)
		{
			op.println(cars[i].vin+"/"+ cars[i].brand+ "/"+ cars[i].model+"/" + cars[i].year+"/"+cars[i].mileage+"/"+cars[i].price+"/"+cars[i].colour);
		}
		
		op.close();
		
	}
	
	public void addcar()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter vin: ");
		cars[nc].vin=in.next();
		System.out.println("Enter brand: ");
		cars[nc].brand=in.next();
		System.out.println("Enter model: ");
		cars[nc].model=in.next();
		System.out.println("Enter year: ");
		cars[nc].year=in.nextInt();
		System.out.println("Enter mileage: ");
		cars[nc].mileage=in.nextInt();
		System.out.println("Enter price: ");
		cars[nc].price=in.nextDouble();
		System.out.println("Enter colour: ");
		cars[nc].colour=in.next();
		
		System.out.println("VIN" + "  " +"Brand"+"  "+ "Model"+"  "+"Year"+"  "+"Mileage"+ "  " +"Price"+"  "+"Colour");
		
		System.out.println(cars[nc].vin+" "+ cars[nc].brand+ " "+ cars[nc].model+" " + cars[nc].year+" "+cars[nc].mileage+" "+cars[nc].price+" "+cars[nc].colour);
		nc++;
		
		System.out.println("This car has been successfully added!");
	}
	
	public void deletecar()  //delete car from the file
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter vin: ");
		String v=in.next();
		
		int postion=0;
		for(int i=0;i<nc;i++)
		{
			if(cars[i].vin.equals(v))
			{
				postion=i;
				break;
			}
		}
		
		for(int i=postion;i<nc;i++)
		{
			cars[i].vin=cars[i+1].vin;
			cars[i].brand=cars[i+1].brand;
			cars[i].model=cars[i+1].model;
			cars[i].year=cars[i+1].year;
			cars[i].mileage=cars[i+1].mileage;
			cars[i].price=cars[i+1].price;
			cars[i].colour=cars[i+1].colour;
		}
		nc--;
		System.out.println("Car successfully deleted");
	}
		
}

