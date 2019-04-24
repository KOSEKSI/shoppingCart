package test;
import java.sql.*;
import java.util.Scanner;
public class CallableStatement3 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee-id");
		int eid=sc.nextInt();
		System.out.println("enter employee-name");
		String ename=sc.nextLine();
		String ename1=sc.nextLine();
		System.out.println("enter employee-desg");
		String edesg=sc.nextLine();
		System.out.println("enter employee-housenum");
		String hno=sc.nextLine();
		System.out.println("enter employee-streename");
		String sname=sc.nextLine();
		System.out.println("enter employee-city");
		String city=sc.nextLine();
		System.out.println("enter employee-pincode");
		String pinc=sc.nextLine();
		System.out.println("enter employee-bsalery");
		int bsal=sc.nextInt();
		System.out.println("enter employee-tsalery");
		int tsal=sc.nextInt();
		System.out.println("enter employee-isalery");
		int isal=sc.nextInt();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		CallableStatement cs=con.prepareCall("{ call empdstored1(?,?,?,?,?,?,?,?,?,?)}");
		cs.setInt(1,eid);
		cs.setString(2, ename1);
		cs.setString(3,edesg);
		cs.setString(4,hno);
		cs.setString(5,sname);
		cs.setString(6, city);
		cs.setString(7, pinc);
		cs.setInt(8, bsal);
		cs.setInt(9, tsal);
		cs.setInt(10, isal);
		
		boolean k=cs.execute();
		if(k=true)
		{
			System.out.println("record inserted ");
		}
		else
		{
			System.out.println("record insertion failure");
		}
		
	}

}
