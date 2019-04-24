package test;
import java.sql.*;
import java.util.Scanner;
public class JdbcCallableExample {

	public static void main(String[] args)throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
       Scanner sc=new Scanner(System.in);
       String cusname,actype,addr,phno;
       int accno,amt;
       System.out.println("enter the account number");
       accno=Integer.parseInt(sc.nextLine());
       System.out.println("enter the customer name");
       cusname=sc.nextLine();
       System.out.println("enter the amount");
       amt=Integer.parseInt(sc.nextLine());
       System.out.println("enter the account-type");
       actype=sc.nextLine();
       System.out.println("enter the address");
       addr=sc.nextLine();
       System.out.println("enter the phone no");
       phno=sc.nextLine();
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","srikanth");
       CallableStatement cs=con.prepareCall("{call addaccount(?,?,?,?,?,?)}");
       cs.setInt(1, accno);
       cs.setString(2, cusname);
       cs.setInt(3, amt);
       cs.setString(4, actype);
       cs.setString(5, addr);
       cs.setString(6, phno);
       
      boolean b= cs.execute();
       if(b=true) {
    	   System.out.println("task completed");
       }
       else
       {
    	   System.out.println("task is failure");
       }
          
      
       
	}

}
