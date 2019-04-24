package test;
//to display student details
//import sql package
import java.sql.*;
import java.util.Scanner;
public class JdbcStudentSearch {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int id;
		System.out.println("please enter id:");
		id=sc.nextInt();
		System.out.println("you entered id is"+id);
		//load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		//preparing a statement 
		PreparedStatement ps=con.prepareStatement("select * from studentrecords11 where rollno=?");
		ps.setInt(1, id);
		//executing a query 
		ResultSet rs=ps.executeQuery();
		System.out.println("your details are ");
		if(rs.next()) {
			
		
			System.out.println("name\t\t"+rs.getString(2));
			System.out.println("address\t\t"+rs.getString(3));
			System.out.println("branch\t\t"+rs.getString(4));
			System.out.println("subject1\t\t"+rs.getString(5));
			System.out.println("subject2\t\t"+rs.getString(6));
			System.out.println("subject3\t\t"+rs.getString(7));
			System.out.println("subject4\t\t"+rs.getString(8));
			System.out.println("subject5\t\t"+rs.getString(9));
			System.out.println("subject6\t\t"+rs.getString(10));
			System.out.println("totalmarks\t\t"+rs.getString(11));
			System.out.println("per\t\t"+rs.getString(12));
			System.out.println("result\t\t"+rs.getString(13));
			System.out.println("status\t\t"+rs.getString(14));
			
		}
		else
		{
			System.out.println("you are entered wrong id ");
		}
		//closing connection
		con.close();
		sc.close();
        
	}

}
