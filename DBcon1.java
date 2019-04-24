package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcon1 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		//System.out.println("Title:Retrive Data From Database");
		//step1:load Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");//simply i thorow the exception above after throws
		//step2:create connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");//here also one exception simply am throw the exeption
		//step3:preparing a statement
		Statement stm=con.createStatement();
		//step4:executing a query what you are written
		ResultSet rs=stm.executeQuery("select * from Employee4pm");
		//using next() method to gain output
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
		}
		
        //Step5:closing a connection;
		con.close();
	}

}
