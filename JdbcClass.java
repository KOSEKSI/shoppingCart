package test;
import java.io.*;
import java.sql.*;
public class JdbcClass {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	PreparedStatement ps=con.prepareStatement("select * from srikanth");
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
	System.out.println(rs.getString(1)+"	"+rs.getString(2));
	}
	
}
}
