package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetriveImage {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException,IOException{
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	String id;
	System.out.println("please enter the id:");
	id=sc.nextLine();
	//loading driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//creating connection
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "srikanth");
	//preparing a statement
	PreparedStatement ps=con.prepareStatement("select * from sstore4pm where id=?");
	ps.setString(1, id);
	//executing query
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		Blob b=rs.getBlob(2);//it will take bits of data stored in the blob object
		byte by[]=b.getBytes(1,(int)b.length());//it converts bits of data into bytes
		String fpath;
		System.out.println("please enter the file path to store the image");
		fpath=sc.nextLine();
		File f=new File(fpath);//it is used to taking a path and creating a one temperory file
		FileOutputStream fos=new FileOutputStream(f);//it will take the file path path from file
		fos.write(by);
	    System.out.println("you are file is retrieved successfully");
		
		
	}
	else
	{
		System.out.println("you are entered invalid id:");
	}
	
	}

}
