package test;
import java.util.*;
import java.sql.*;
public class EmpDataMapDbexcecution {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException{
        HashMap<String,EmpData1> hm=new HashMap<String,EmpData1>();
        //load a driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //creating a connection
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "srikanth");
        //preparing a statement 
        PreparedStatement ps=con.prepareStatement("select * from employee4pm");
        //executing a query
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	hm.put(rs.getString(1),new EmpData1(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
        }
        //display
        hm.forEach((p,l)->{
        	
        	System.out.println(p+"\t"+l);
        	
        	
        });
	}

}
