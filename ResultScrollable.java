package test;
import java.sql.*;
public class ResultScrollable {

	public static void main(String[] args) throws ClassNotFoundException , SQLException {
		// TODO Auto-generated method stub
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
      Statement cs=con.createStatement(1004,1007);
      
      ResultSet rs=cs.executeQuery("select * from employee4pm");
      rs.afterLast();
      while(rs.previous())
      {
    	  System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
      }
      PreparedStatement ps=con.prepareStatement("select * from employee4pm");
      ResultSet rs1=ps.executeQuery();
      rs.absolute(3);
      System.out.println("------>prepared statement <--------");
      System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
      
     
	}

}
