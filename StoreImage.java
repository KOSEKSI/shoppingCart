package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
public class StoreImage {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException, IOException {
		// TODO Auto-generated method stub
		java.util.Scanner sc=new java.util.Scanner(System.in);
		String sid;
		System.out.println("please enter your id");
		sid=sc.nextLine();
		System.out.println("please enter your filepath");
		String fpath;
		fpath=sc.nextLine();
		//load a driver
		File f=new File(fpath);
		FileInputStream fis=new FileInputStream(f);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating a connection 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		//preparing a statement
		PreparedStatement ps=con.prepareStatement("insert into sstore4pm values(?,?)");
		ps.setString(1, sid);
		ps.setBinaryStream(2,fis,(int)f.length());
		int k=ps.executeUpdate();
		if(k>=0) {
			System.out.println("record insereted successfully");
		}
		else
		{
			System.out.println("record insertion failure");
		}
	}

}
