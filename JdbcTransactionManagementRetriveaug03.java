package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
public class JdbcTransactionManagementRetriveaug03  {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		PreparedStatement ps=con.prepareStatement("select * from translog where accno=?");
		int acno=1233;
		ps.setInt(1, 1233);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Blob b=rs.getBlob(2);
			byte by[]=b.getBytes(1,(int)b.length());
			FileOutputStream fos=new FileOutputStream("E:\\new volume(Gdrive)\\advance java\\retrivelog\\"+acno+".txt");
			fos.write(by);
		    FileInputStream fis=new FileInputStream("E:\\new volume(Gdrive)\\advance java\\retrivelog\\"+acno+".txt");
		    ObjectInputStream ois=new ObjectInputStream(fis);
		    Translog ob=(Translog)ois.readObject();
		    System.out.println(ob);
		    
		    
		}
		
	}

}
