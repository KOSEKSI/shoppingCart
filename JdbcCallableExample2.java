package test;
import java.sql.*;
import java.util.Scanner;
public class JdbcCallableExample2 {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
		int rno;
		String name,branch,hno,sname,city,pincode,name1;
		int tmarks,per;
		String result="",status="";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter all the student details in below form\n\n");

		System.out.println("enter rollno in form of (integer)");
		rno=sc.nextInt();
		System.out.println("enter name");
		name=sc.nextLine();
		name1=sc.nextLine();
		System.out.println("enter branch");
		branch=sc.nextLine();

		System.out.println("enter house-no");
		hno=sc.nextLine();

		System.out.println("enter Street-name");
		sname=sc.nextLine();
		System.out.println("enter city-name");
		city=sc.nextLine();

		System.out.println("enter pincode");
		pincode=sc.nextLine();
		System.out.println("enter total marks out of 600");
        tmarks =sc.nextInt();
        per=(int)(tmarks/6);
        if(per<45 && per>=35)
        {
        	result="pass";
        	status="third";
        }
        else if(per<=60 && per>=45)
        {
        	result="pass";
        	status="second";
        }
        else if(per<70 && per>=60)
        {
        	result="pass";
        	status="first";
        }
        else if(per<=100&&per>=71)
        {
        	result="pass";
        	status="first";
        }
        else
        {
        	result="fail";
        	status="nill";
        }
        System.out.println("percentage"+per);
        System.out.println("result"+result);
        System.out.println("status"+status);
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","srikanth");
		CallableStatement cs=con.prepareCall("{call storestudent(?,?,?,?,?,?,?,?,?,?,?)}");
		cs.setInt(1, rno);
		cs.setString(2, name1);
		cs.setString(3, branch);
		cs.setString(4, hno);
		cs.setString(5, sname);
		cs.setString(6, city);
		cs.setString(7, pincode);
		cs.setInt(8, tmarks);
		cs.setInt(9, per);
		cs.setString(10, result);
		cs.setString(11, status);
		
		  
	      boolean k= cs.execute();
	       if(k=true) {
	    	   System.out.println("task completed");
	       }
	       else
	       {
	    	   System.out.println("task is failure");
	       }
	}

}
