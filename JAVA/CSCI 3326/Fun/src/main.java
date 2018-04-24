import java.util.*;

public class main {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number: ");
	 int n = in.nextInt();
	 
	 System.out.print(sum(n));
	}
	private static int sum(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		else 
		{
			return n + sum(n-1);
		}
	
	}
	
	
}
