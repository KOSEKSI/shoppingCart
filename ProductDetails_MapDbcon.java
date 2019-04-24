package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProductDetails_MapDbcon {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		HashMap<String,DisplayProducts_1> hm1=new HashMap<String,DisplayProducts_1>();
		//load a driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//creating a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "srikanth");
		//preparing a statement
		PreparedStatement ps=con.prepareStatement("Select * from products");
		//executing a query
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			hm1.put(rs.getString(1),new DisplayProducts_1(rs.getString(2), rs.getInt(3),rs.getInt(4)));
		}
		//for display
		hm1.forEach((k,v)->
		{
			
		System.out.println(k+"\t"+v);
			
		});
	}

}
