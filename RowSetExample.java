package test;
import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class RowSetExample {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         JdbcRowSet jrs=RowSetProvider.newFactory().createJdbcRowSet();
         jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
         jrs.setUsername("system");
         jrs.setPassword("srikanth");
         jrs.setCommand("select * from bank11");
         jrs.execute();
         System.out.println("----Normal Process------");
         while(jrs.next())
         {
        	 System.out.println(jrs.getString(1));
         }
         jrs.afterLast();
         System.out.println("------previous process------");
         while(jrs.previous())
         {
        	 System.out.println(jrs.getString(1));
         }
		

	}

}
