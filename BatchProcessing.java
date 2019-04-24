package test;
import java.sql.*;
public class BatchProcessing {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	    Statement st=con.createStatement();
	    st.addBatch("insert into employee4pm values ('a756','raj','em',12222,22)");	
	    st.addBatch("insert into employee4pm values ('a757','raj','em',12222,22)");
	    st.addBatch("insert into userreg4pm values ('rtc123','rtc123','rnreddy','rn','8-8-8','89900','s@gmail.com')");
	    
	    int[] k=st.executeBatch();
	    int sum=0;
	    for(int i=0;i<k.length;i++)
	    {
	    	sum=i+1;
	    	
	    }
		System.out.println(sum +"records updated");
	}

}
