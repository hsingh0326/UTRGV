package Lab8_1;

public class Lab8_1 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		person p = new person("Junio", 20, 'F');
		p.displayName();
		p.displaAge();
		p.displayGender();
		
		p.setName("Reubelle");
		p.setAge(19);
		p.setGender('F');
		
		p.displayName();
		p.displaAge();
		p.displayGender();

	}
}


