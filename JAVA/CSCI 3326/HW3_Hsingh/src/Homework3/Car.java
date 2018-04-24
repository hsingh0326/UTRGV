/*Harsimranjeet Singh
CSCI 3326 Java
*/
package Homework3;
import java.io.*;
import java.util.*;
// set car get info
public class Car 
{
	Scanner in=new Scanner(System.in);
	String vin;
	String brand;
	String model;
	int year;
	int mileage;
	double price;
	String colour;
	
	public void setvin()
	{
		System.out.println("Enter vin: ");
		vin=in.next();
	}
	
	public void setbrand()
	{
		System.out.println("Enter brand: ");
		brand=in.next();
	}
	
	public void setmodel()
	{
		System.out.println("Enter model: ");
		vin=in.next();
	}
	
	public void setyear()
	{
		System.out.println("Enter year: ");
		year=in.nextInt();
	}
	
	public void setmil()
	{
		System.out.println("Enter mileage: ");
		mileage=in.nextInt();
	}
	
	public void setprice()
	{
		System.out.println("Enter price: ");
		price=in.nextDouble();
	}
	
	public void setcolour()
	{
		System.out.println("Enter colour: ");
		colour=in.next();
	}
}
