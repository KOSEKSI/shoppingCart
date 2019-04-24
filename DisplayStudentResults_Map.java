package test;
import java.sql.*;
import java.util.HashMap;
public class DisplayStudentResults_Map {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int id;
		System.out.println("please enter student rollno");
		id=sc.nextInt();
		HashMap<Integer,StudentSearch_map> hm2=new HashMap<Integer,StudentSearch_map>();
		//loading a driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		//preparing a statement 
		PreparedStatement ps=con.prepareStatement("select * from studentrecords11 where rollno=?");
		ps.setInt(1,id);
		//executing a query
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			hm2.put(rs.getInt(1),new StudentSearch_map(rs.getString(2),rs.getString(3),
					rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8), rs.getInt(9), 
					rs.getInt(10), rs.getInt(11),rs.getInt(12), rs.getString(13),rs.getString(14)) );
		}
		else
		{
			System.out.println("invalid idno:");
		}
		//for displaying
		hm2.forEach((k,v)->{
			
			
			System.out.println(k+"\t"+v);
			
		}
				
				
				
				
				);
		
		
		

	}

}
