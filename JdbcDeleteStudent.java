package test;
//import sql package
import java.sql.*;
import java.util.Scanner;
public class JdbcDeleteStudent {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException{
		Scanner scn=new Scanner(System.in);
		int rollno;
		System.out.println("enter the rollno of student");
		rollno=scn.nextInt();
		System.out.println("you are entered rollno is:"+rollno);
		//load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		//preparing a statement
		PreparedStatement ps=con.prepareStatement("select * from studentrecords11 where rollno=?");
		ps.setInt(1,rollno);
		//executing a query
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("you are entered valid details");
			//creating a one more query 
			PreparedStatement ps1=con.prepareStatement("delete from studentrecords11 where rollno=?");
			ps1.setInt(1, rollno);
			int k=ps1.executeUpdate();
			if(k>=0)
			{
				System.out.println("deleted successfully");
			}
		}
		else
		{
			System.out.println("you are entered invalid details");
		}
		
		
		
	}

}
