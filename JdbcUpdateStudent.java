
package test;
//write a program for change the address in studentrecords using rollno
import java.sql.*;
import java.util.Scanner;
public class JdbcUpdateStudent {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		System.out.println("change address in student records");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the rollno");
		int rollno=sc.nextInt();
		//load a driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "srikanth");
		//preparing a statement
		PreparedStatement ps=con.prepareStatement("select * from studentrecords11 where rollno=?");
		ps.setInt(1, rollno);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("you are entered valid id");
			//here we create another prepared statement
			System.out.println("the previous address is:   "+rs.getString(3));
			
			PreparedStatement ps2=con.prepareStatement("update studentrecords11 set address=? where rollno=?");
			System.out.println("please enter the new address");
			//String address=sc.nextLine();
			Scanner sc1=new Scanner(System.in);
			String address1=sc1.nextLine();
			ps2.setString(1, address1);
			ps2.setInt(2, rollno);
			
			int k=ps2.executeUpdate();
			if(k>=0)
			{
				System.out.println("updated successfully");
			}
			
			
		}
		else
		{
			System.out.println("you are entered invalid id");
		}
		con.close();

		
	}

}

