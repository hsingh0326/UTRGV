import java.sql.*;

public class main {
		public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException,SQLException{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String addr = "104.197.183.40:3306/db37";
			String s1 = "jdbc:mysql://" + addr;
			Connection connection = DriverManager.getConnection(s1,"user37","2928");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cars");
			while(rs.next())
			{
			 System.out.print(rs.getString(1)+ "\t" + rs.getString(2)+"\t" + rs.getString(3)+"\t" + rs.getString(4)+"\t" + rs.getString(5) + "\t" + rs.getString(6) +"\t" + rs.getString(7));
			System.out.println();
			 
			}
			connection.close();
			
		}

}