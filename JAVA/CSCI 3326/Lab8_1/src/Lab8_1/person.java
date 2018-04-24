package Lab8_1;

public class person 
{
	String name;
	int age;
	char gender;
	public person(String a, int b, char c)
	{
		name = a;
		age = b;
		gender = c;
		
	}
	public void displayName()
	{
		System.out.println(name);
	}
	
	public void displaAge()
	{
		System.out.println(age);
	}
	public void displayGender()
	{
		System.out.println(gender);
	}
	
	public void setName(String str)
	{
		name = str;
	}
	
	public void setAge(int num)
	{
		age = num;
	}
	public void setGender(char g)
	{
		gender = g;
	}
}
