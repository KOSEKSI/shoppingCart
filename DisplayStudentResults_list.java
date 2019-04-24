package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DisplayStudentResults_list {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		ArrayList<StudentSearch_list> al1=new ArrayList<StudentSearch_list>();
		//loading a driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating a connection 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		//preparing a statement
		PreparedStatement ps=con.prepareStatement("select * from studentrecords11");
		//executing a query
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			al1.add(new StudentSearch_list(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8), rs.getInt(9), 
					rs.getInt(10), rs.getInt(11),rs.getInt(12), rs.getString(13),rs.getString(14)));
		}
		//for display
	
		al1.forEach((k)->
		{
			System.out.println(k);
		});
		
		
	}

}
