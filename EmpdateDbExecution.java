package test;
import java.sql.*;
import java.util.ArrayList;
public class EmpdateDbExecution {

	public static void main(String[] args) throws ClassNotFoundException,SQLException  {
	ArrayList<EmpData> al=new ArrayList<EmpData>();//here we passing the object values through arraylist of CFW
	//load the driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//creating connection 
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	//preparing a statement 
	PreparedStatement ps=con.prepareStatement("select * from employee4pm");
	//executing a query
	ResultSet rs=ps.executeQuery();
	//in these result set containing all the values of db data
    //this data must be stored in the form of object and display that object by using arraylist
	//processing the next method
	while(rs.next())
	{
		al.add(new EmpData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
	}
	//using foreach method to display the values
	//this is from jdk1.8 onwards
	al.forEach((k)->{
		System.out.println(k);
		
	}
	
	);
	
	con.close();
	}

}
