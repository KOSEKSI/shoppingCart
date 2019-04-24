package test;
//import sql package
import java.sql.*;
import java.util.Scanner;
public class JdbcUpdateProblem {

	public static void main(String[] args) throws ClassNotFoundException , SQLException{
		System.out.println("update details in table Employee4pm");
		//load a driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create a connection 
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system" ,"srikanth");
		//preparing a statement
		Scanner sc=new Scanner(System.in);
		System.out.println("enter username");
		String uname=sc.nextLine();
		System.out.println("enter password");
		String pword=sc.nextLine();
		PreparedStatement ps=con.prepareStatement
				("select * from userreg4pm where username=? and password=?");
		ps.setString(1, uname);
		ps.setString(2, pword);
		//executing a query
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("if you want to update address");
			System.out.println("the previous address is"+rs.getString(5));
			System.out.println("enter new address");
			String addr=sc.nextLine();
			PreparedStatement ps1=con.prepareStatement("update userreg4pm set address=? where username=? and password=?");
			ps1.setString(1, addr);
			ps1.setString(2, uname);
			ps1.setString(3, pword);
			
			int k=ps1.executeUpdate();
			if(k>=0)
			{
				System.out.println("record updated successfully");
			}
			
			
		}
		else
		{
			System.out.println("invalid username and password");
		}
		

	}

}
