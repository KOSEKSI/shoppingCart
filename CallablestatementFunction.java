package test;
import java.util.Scanner;
import java.sql.*;
public class CallablestatementFunction {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int acno =sc.nextInt();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		CallableStatement cs=con.prepareCall("{call ?:=getBalanceF12(?)}");
		cs.registerOutParameter(1,Types.INTEGER);
		cs.setInt(2,acno);
		cs.execute();
		System.out.println("bal:"+cs.getInt(1));
	}

}
