package test;
import java.sql.*;
import java.util.ArrayList;

public class ProductDetais_DBcon {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
     //to create a array list from Collection and to store the object details
		ArrayList<DisplayProducts> al2=new ArrayList<DisplayProducts>();
		
	//load the driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//creating a connection 
	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	//preparing  a statement
	PreparedStatement ps=con.prepareStatement("select * from products");
	//executing a query
	ResultSet rs=ps.executeQuery();
	//in these rs contains all the records of db inthe form of object
	while(rs.next())
	{
		al2.add(new DisplayProducts(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
	}
	//for retrive those values for using foreach lamda method from jdk1.8 onwords
	al2.forEach((k)->{
		
		System.out.println(k);
		
		
	});
	}

}
