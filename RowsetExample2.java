package test;
import java.sql.*;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class RowsetExample2 {

	public static void main(String[] args) throws SQLException,ClassNotFoundException{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the acno");
	int acno=sc.nextInt();
	JdbcRowSet jrs1=RowSetProvider.newFactory().createJdbcRowSet();
	jrs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	jrs1.setUsername("system");
	jrs1.setPassword("srikanth");
	jrs1.setCommand("select * from bank11 where acno=?");
	jrs1.setInt(1, acno);
	jrs1.execute();
	System.out.println("----Normal Process----");
	if(jrs1.next())
	{
		System.out.println(jrs1.getString(1)+"\t"+jrs1.getString(2)+"\t"+jrs1.getString(3)+"\t"+jrs1.getString(4));
	}
	else
	{
		System.out.println("invalid acno");
		}
		

	}

}
