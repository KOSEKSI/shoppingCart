package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
public class JdbcTransactionManagement22aug03 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException, IOException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		con.setAutoCommit(false);
		Savepoint s1=con.setSavepoint();
		PreparedStatement ps=con.prepareStatement("update bank11 set bal=bal+? where acno=? ");
		
		ps.setInt(1, +5000);
		ps.setInt(2, 1233);//receiver
		int i=ps.executeUpdate();
		
		int acno=1234;
		int receiveracno=1235;
		ps.setInt(1, -5000);
		ps.setInt(2, 1234);//sender
		int j=ps.executeUpdate();
		PreparedStatement ps2=con.prepareStatement("insert into translog values(?,?)");
		if(i==1 && j==1)
		{
			System.out.println("updated successfully");
			Translog t1=new Translog(Math.random(),new java.util.Date(),receiveracno,5000);
			File f=new File("E:\\new volume(Gdrive)\\advance java\\storelogs\\"+acno+".txt");
		    FileOutputStream fos =new FileOutputStream(f);
		    ObjectOutputStream oos=new ObjectOutputStream(fos);
		    oos.writeObject(t1);
		    FileInputStream fis=new FileInputStream(f);
		    ps2.setInt(1, 1233);
		    ps2.setBinaryStream(2,fis,(int)f.length());
			int k=ps2.executeUpdate();
			if(k==1)
			{   System.out.println("translog created");
				con.commit();
			}
			
		}
		else
		{
			con.rollback(s1);
			System.out.println("updated failed");
		}
	}

}
