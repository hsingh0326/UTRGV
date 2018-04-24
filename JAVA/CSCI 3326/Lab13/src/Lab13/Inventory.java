package Lab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventory {
	public Object[][] getTable(String brand) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Object[][] data = new Object[100][7];
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String str1 = "104.197.183.40:3306/db37";
		
		String s = "jdbc:mysql://" + str1;
		Connection connection = DriverManager.getConnection(s, "user37", "2928");
		Statement statement = (Statement) connection.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from cars where brand='"+brand+"';");
		//System.out.println(s);
		int i = 0;
		while(rs.next())
		{
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			i++;
		}
		connection.close();
		
		return data;
	}
	
	public Object[][] getTable0() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Object[][] data = new Object[100][7];
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String str1 = "104.197.183.40:3306/db23";
		
		String s = "jdbc:mysql://" + str1;
		Connection connection = DriverManager.getConnection(s, "user23", "9329");
		Statement statement = (Statement) connection.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from cars;");
		System.out.println(s);
		int i = 0;
		while(rs.next())
		{
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			i++;
		}
		connection.close();
		
		return data;
	}
}
