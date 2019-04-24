package test;
import java.sql.*;

import java.util.Scanner;
public class CallableStatement4 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the account number");
		int acno=sc.nextInt();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "srikanth");
		CallableStatement cs=con.prepareCall("{call getResult13(?,?)}");
		cs.setInt(1, acno);
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.execute();
		System.out.println("balance is:"+cs.getInt(2));
		
		
	}

}
