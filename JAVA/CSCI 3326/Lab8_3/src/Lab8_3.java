import java.io.*;
import java.util.Scanner;

public class Lab8_3 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter id  = new PrintWriter("ID.txt");
		PrintWriter pw = new PrintWriter("Password.txt");
		String ID, PW;
		char c = 'y';
		while(c == 'y')
		{
			System.out.print("ID: ");
			ID = in.next();
			System.out.print("Pass: ");
			PW = in.next();
			
			//write to file.
			id.println(ID);
			pw.println(PW);
			
			System.out.println("Successfully stored!");
			System.out.println("Do you want to continue? ");
			c = in.next().charAt(0);
			
		}
		id.close(); 
		pw.close();
		
		//print out IDs and PWs
		File id_read = new File("ID.txt");
		File pw_read = new File("Password.txt");
		Scanner s1 = new Scanner(id_read);
		Scanner s2 = new Scanner(pw_read);
		String id_, pw_;
		
		System.out.println("Member ID and Password List: ");
		while (s1.hasNext() && s2.hasNext())
		{
			id_ = s1.nextLine();
			pw_ = s2.nextLine();
			System.out.println("ID: " + id_ + " Pass: " + pw_);
		}
		System.out.println("Thank you!" );
		in.close();
		s1.close();
		s2.close();
	}

}
