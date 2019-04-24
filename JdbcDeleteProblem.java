package test;
//import sql package
import java.sql.*;
import java.util.Scanner;
public class JdbcDeleteProblem {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException{
	    System.out.println("jdbc delete operation");
	    Scanner sc=new Scanner(System.in);
	    System.out.println("please enter employee id");
	    String empid=sc.nextLine();
	    //load a driver
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    //creating a connection 
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	    //preparing a statement
	    PreparedStatement ps=con.prepareStatement("select * from employee4pm where empid=?");
		ps.setString(1, empid);
		//execute a query
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			//System.out.println("you entered valid details");
			System.out.println("Delete operation performed here");
		    //create one more PreparedStatement
			PreparedStatement ps1=con.prepareStatement("delete from employee4pm where empid=?");
			ps1.setString(1, empid);
			int k=ps1.executeUpdate();
			if(k>0)
			{
				System.out.println("record deleted successfully");
			}
			
		}
		else
		{
			System.out.println("you are entered invalid credentials");
		}
		con.close();
		sc.close();

	}

}
