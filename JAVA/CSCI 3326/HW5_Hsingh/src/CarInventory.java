// Harsimranjeet Singh
import java.sql.*;

public class CarInventory
{
	public CarInventory()
	{
		
	}
	
	public Object[][] getTable0() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://104.197.183.40:3306/db37","user37", "2928");// 
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from cars");

		Object[][] data = new Object[100][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		connection.close();
		return data;
	}
	
	public Object[][] getTable1(String bn) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://104.197.183.40:3306/db37","user37", "2928");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from cars where brand='"+bn+"'"); // This is for example.

		rs.last();
		int numRows = rs.getRow();
		rs.beforeFirst();
		
		Object[][] data = new Object[numRows][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		connection.close();
		return data;
	}
	
	public Object[][] getTable2(String vin, String bn, String md, int yr, int mi, int pr, String co) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://104.197.183.40:3306/db37","user37", "2928");
		Statement statement = connection.createStatement();
		String str1 = "select * from cars where";
		boolean first = true;
		
		if(!vin.equals("")){
			first = false;
			str1 += " vin = '"+vin+"'";
		}			
		if(!bn.equals("")){
			if(first != true){
				str1 += " and";				
			}
			str1 += " brand = '"+bn+"'";
			first = false;
		}			
		if(!md.equals("")){
			if(first != true){
				str1 += " and";				
			}
			str1 += " model = '"+md+"'";
			first = false;
		}			
		if(yr != -1){
			if(first != true){
				str1 += " and";				
			}
			str1 += " year = '"+yr+",";
			first = false;
		}			
		if(mi != -1){
			if(first != true){
				str1 += " and";				
			}
			str1 += " mileage = '"+mi+",";
			first = false;
		}			
		if(pr != -1){
			if(first != true){
				str1 += " and";				
			}
			str1 += " price = '"+pr+",";
			first = false;
		}			
		if(!co.equals("")){
			if(first != true){
				str1 += " and";				
			}
			str1 += " color = '"+co+"'";
			first = false;
		}
		
		if (first == true){
			str1 = "select * from cars";
		}			
		
		ResultSet rs = statement.executeQuery(str1);

		rs.last();
		int numRows = rs.getRow();
		rs.beforeFirst();
		
		Object[][] data = new Object[numRows][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		connection.close();
		return data;
	}	
	
	public void deleteEntry(String vin) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://104.197.183.40:3306/db37","user37", "2928");
		Statement statement = connection.createStatement();
		
		String sql1 = "delete from cars where vin = '"+vin+"'";
		statement.executeUpdate(sql1);
		connection.close();
	}
	
	public void updateEntry(String vin, String bn, String md, int yr, int mi, int pr, String co) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://104.197.183.40:3306/db37","user37", "2928");
		Statement statement = connection.createStatement();
		String str1;
			
		if(!bn.equals("")){
			str1 = "update cars set brand = '"+bn+"' where vin = '"+vin+"'";
			statement.executeUpdate(str1);
		}			
		if(!md.equals("")){
			str1 = "update cars set model = '"+md+"' where vin = '"+vin+"'";
			statement.executeUpdate(str1);
		}			
		if(yr != -1){
			str1 = "update cars set year = "+yr+" where vin = '"+vin+"'";
			statement.executeUpdate(str1);
		}			
		if(mi != -1){
			str1 = "update cars set mileage = "+mi+" where vin = '"+vin+"'";
			statement.executeUpdate(str1);
		}			
		if(pr != -1){
			str1 = "update cars set price = "+pr+" where vin = '"+vin+"'";
			statement.executeUpdate(str1);
		}			
		if(!co.equals("")){
			str1 = "update cars set color = '"+co+"' where vin = '"+vin+"'";
			statement.executeUpdate(str1);
		}		
		connection.close();
	}
	
	public void addEntry(String vin, String bn, String md, int year, int mi, int pr, String co) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://104.197.183.40:3306/db37","user37", "2928");
		Statement statement = connection.createStatement();
		
		String sql1 = "insert into cars values('"+vin+"','"+bn+"','"+md+"',"+year+","+mi+","+pr+",'"+co+"');";
		statement.executeUpdate(sql1);
		connection.close();
	}
	
}
