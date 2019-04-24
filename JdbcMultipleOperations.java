package test;
//importing sql package
import java.sql.*;
import java.util.Scanner;
public class JdbcMultipleOperations {
	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
		// TODO Auto-generated method stub
		System.out.println("Jdbc Program For Create | Insert  | Drop the table");
      //Step1:load the driver
		String str;
		System.out.println("please enter the query");
	    Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		System.out.println("you entered query"+str);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//thorows the exception
	  //step2:create connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");//throws exception
	  //step3:preparing Statement
		Statement stm=con.createStatement();
	  //Step4:execute query

		
		int k=stm.executeUpdate(str);
	  //validating the query for popup
		if(k>=0)
		{
		System.out.println("Database updated Successfully");	
		}
		else
		{
		System.out.println("Database updated Failed");
		}
	  }//main close
}//class close
