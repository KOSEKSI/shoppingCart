package test;
import java.sql.*;
public class BatchProcess2 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		PreparedStatement ps=con.prepareStatement("insert into employee4pm values (?,?,?,?,?)");
		ps.setString(1, "a139");
		ps.setString(2, "nani");
		ps.setString(3, "software");
		ps.setInt(4, 12300);
		ps.setInt(5, 22);
		ps.addBatch();
		
		
		ps.setString(1, "a134");
		ps.setString(2, "nani");
		ps.setString(3, "software");
		ps.setInt(4, 12300);
		ps.setInt(5, 22);
		ps.addBatch();
		
		
		int[] k=ps.executeBatch();
		int sum=0;
		for(int i=0;i<k.length;i++)
		{
			sum = i+1;
		}
		System.out.println("("+sum+")records inserted");
	}

}
