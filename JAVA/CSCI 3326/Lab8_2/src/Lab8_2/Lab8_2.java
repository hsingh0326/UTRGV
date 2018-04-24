package Lab8_2;


import java.util.*;

public class Lab8_2 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Menu m = new Menu();
		
		Scanner in = new Scanner(System.in);
		int uc;
		while (true)
		{
			m.mainMenu();
			uc = in.nextInt();
			
			if (uc == 4)
			{
				System.out.println("Bye~");
				break;
			}
			else if (uc == 1)
			{
				//game menu
				while (true)
				{
					m.gameMenu();
					uc = in.nextInt();
					if (uc == 3)
						break;
					else if (uc == 1 || uc == 2)
						System.out.println("I'm sorry. It's not ready yet");
					else
						System.out.println("Please input correctly.");
				}
			}
			else if (uc == 2)
			{
				//utility menu
				while (true)
				{
					m.utilityMenu();
					uc = in.nextInt();
					if (uc == 4)
						break;
					else if (uc == 1 || uc == 2 || uc == 3)
						System.out.println("I'm sorry. It's not ready yet");
					else
						System.out.println("Please input correctly.");
				}
			}
			else if (uc == 3)
			{
				//multimedia
				while (true)
				{
					m.multimediaMenu();
					uc = in.nextInt();
					if (uc == 4)
						break;
					else if (uc == 1 || uc == 2 || uc == 3)
						System.out.println("I'm sorry. It's not ready yet");
					else
						System.out.println("Please input correctly.");
				}
			}
		}
		in.close();
	}

}

