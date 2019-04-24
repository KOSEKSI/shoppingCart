package test;
import java.sql.*;
import java.util.Scanner;
public class JDBCMetaData {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String uname,pword;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the username");
		uname=sc.nextLine();
		System.out.println("enter the password");
		pword=sc.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		PreparedStatement ps=con.prepareStatement("select * from userreg4pm where USERNAME=? and PASSWORD=?");
		ps.setString(1, uname);
		ps.setString(2, pword);
		ResultSet rs=ps.executeQuery();
		DatabaseMetaData dmd=con.getMetaData();
		System.out.println(dmd.getDatabaseProductName());
		
		System.out.println(dmd.getDatabaseProductVersion());
		ResultSetMetaData rmd=ps.getMetaData();
		System.out.println(rmd.getColumnCount());
		System.out.println(rmd.getColumnName(3));
		System.out.println(rmd.getColumnDisplaySize(3));
		ParameterMetaData pmd=ps.getParameterMetaData();
		System.out.println(pmd.getParameterCount());
	}

}
