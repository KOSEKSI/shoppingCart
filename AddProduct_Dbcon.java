package test;
import java.sql.*;
import java.util.Scanner;

public class AddProduct_Dbcon {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
	Scanner sc=new Scanner(System.in);
	System.out.println("welcome admin ");
	System.out.println("please add the product by following below");
	String pcode,pname;
	int pprice,pquantity;
	System.out.println("please enter the product code");
	pcode=sc.nextLine();
	System.out.println("please enter the product name");
	pname=sc.nextLine();
	System.out.println("please enter the product price");
	pprice=sc.nextInt();
	System.out.println("please enter the product quantity");
	pquantity=sc.nextInt();
	
	System.out.println("<----------YOU ARE ENTERED PRODUCT DETAILS------------>");
	System.out.println("pcode = "+pcode);
	System.out.println("pname = "+pname);
	System.out.println("pprice = "+pprice);
	System.out.println("pquantity = "+pquantity);
	
	//load a driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//create a connection
	Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "srikanth");
	//preparing a statement
	PreparedStatement ps=con.prepareStatement("select * from products where pcode=?");
	ps.setString(1, pcode);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		System.out.println(pcode+" this product code is already existed");
	}
	
	else {
	PreparedStatement ps1=con.prepareStatement("insert into products values (?,?,?,?)");
	ps1.setString(1, pcode);
	ps1.setString(2, pname);
	ps1.setInt(3, pprice);
	ps1.setInt(4, pquantity);
	//executing a query
	int k=ps1.executeUpdate();
	if(k>=0) {
		System.out.println("record created successfully");
	}
	
	
	else
	{
		System.out.println("record creation failed");
	}
	}
		
	}

}
