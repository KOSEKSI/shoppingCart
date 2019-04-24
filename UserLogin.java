package test;
//write a jdbc program to user login with help of Scanner
//import sql package for writing db operations 
import java.sql.*;
import java.util.Scanner;
public class UserLogin {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
	   System.out.println("welcome to User_Login Form");
	   System.out.println("plese login here!");
	   Scanner sc=new Scanner(System.in);
	   System.out.println("please enter username");
	   String uname=sc.nextLine();
	   System.out.println("please enter password");
	   String pword=sc.nextLine();
	   //step1:load a driver
	   Class.forName("oracle.jdbc.driver.OracleDriver");//throws ClassNotFoundException
	   //step2:creating a connection 
	   Connection con=DriverManager.getConnection
			   ("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");//thorows SQLException
	   //step3:preparing a statement
	   PreparedStatement ps=con.prepareStatement("select * from userreg4pm where username=? and password= ?");
	   ps.setString(1, uname);
	   ps.setString(2,pword);
	   //step4:Executing a query
	   ResultSet rs=ps.executeQuery();
	   if(rs.next())
	   {
		 System.out.println("login successfully");
		 System.out.println("Your details are below--->");
		 System.out.println("FirstName\t"+rs.getString(3));
		 System.out.println("SecondName\t"+rs.getString(4));
		 System.out.println("Address\t"+rs.getString(5));
		 System.out.println("Phone\t"+rs.getString(6));
		 System.out.println("Email-id\t"+rs.getString(7)); 
		 
	   }
	   
	   else
	   {
			 System.out.println("you are entered wrong details");   
	   }
	//step5:close the connection
	   con.close();
	   sc.close();

	}//main close

}//class close
