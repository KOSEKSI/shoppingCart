package test;
import java.sql.*;
public class JdbcTransactionProcess {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		con.setAutoCommit(false);
		Savepoint s1=con.setSavepoint();
		PreparedStatement ps=con.prepareStatement("update bank11 set bal=bal+? where acno=?");
		
		//receiver
		ps.setInt(1,5000);
		ps.setInt(2, 1234);
		int k=ps.executeUpdate();
		
		//sender 
		ps.setInt(1, -5000);
		ps.setInt(2, 1233);
		int j=ps.executeUpdate();
		
		if(k==1 && j==1)
		{
			con.commit();
			System.out.println("trasactions are updated");
		}
		else
		{
			con.rollback();
			System.out.println("trasaction are failed");
		}
		
	}

}
