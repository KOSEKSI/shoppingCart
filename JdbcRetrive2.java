package test;
//import sql package
import java.sql.*;
public class JdbcRetrive2 {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
		// TODO Auto-generated method stub
		System.out.println("Title Retrive Data From Database Table:Book4pm");
		//step1:load Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");//throws exception
		//step2:create Connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");//throws exception
		//step3:preparing a statement
		Statement stm=con.createStatement();
		//step4:executing a query
		ResultSet rs=stm.executeQuery("select * from Book4pm");
		//to gaining a output using next() method
		System.out.println("bode		bname	 	bAuthor			bprice		 bQuantity");
		
		while(rs.next())
		{
			//System.out.println("hello");
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
			
			
		}
		//step5:closing a connection
		con.close();
		

	}

}
