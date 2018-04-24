import java.sql.*;

public class Main  {
		public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException,SQLException{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String s1 = "jdbc:mysql://localhost:3306/carmax";
			Connection connection = DriverManager.getConnection(s1,"root","Gillboy93");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cars");
			while(rs.next())
			{
			 System.out.print(rs.getString(1)+ "   " + rs.getString(2)+"   " + rs.getString(3)+"   " + rs.getString(4)+"   " + rs.getString(5) + " " + rs.getString(6) +"   " + rs.getString(7));
			System.out.println();
			 
			}
			connection.close();
		}

}
