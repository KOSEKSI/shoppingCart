package test;
//write a program to register the user details with scanner class 
//create table from sql command line table name "userreg4pm"
import java.sql.*;//importing the sql package to perform db operations
import java.util.Scanner;
public class JdbcUserRegistration {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to USER_Registration Form");
		Scanner sc=new Scanner(System.in);
		//requirements are uname,pword,fname,sname,address,phone,mailid
		String uname,pword,fname,sname,address,mailid;
		Long phone;
		System.out.println("please enter your username");
		uname=sc.nextLine();
		System.out.println("please enter your password");
		pword=sc.nextLine();
		System.out.println("please enter your firstname");
		fname=sc.nextLine();
		System.out.println("please enter your secondname");
		sname=sc.nextLine();
		System.out.println("please enter your address");
		address=sc.nextLine();
		System.out.println("please enter your phone");
		phone=Long.parseLong(sc.nextLine());
		System.out.println("please enter your email-id");
		mailid=sc.nextLine();
		System.out.println("your entered details are ");
		System.out.println
		("username\t-->"+uname+"\npassword\t-->"+pword+"\nfirstname\t-->"
		+fname+"\nsecondname\t-->"+sname+"\naddress\t-->"+address+
	"\nphone\t-->"+phone+"\nmailid\t-->"+mailid);
		
		//step1:load a driver
	    Class.forName("oracle.jdbc.driver.OracleDriver");//throws a ClassNotFoundException
	    //step2:creating a connection 
	    Connection con=DriverManager.getConnection
	    		("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");//throws SQLException
	    //step3:preparing a statement
	    PreparedStatement ps=con.prepareStatement("insert into userreg4pm values (?,?,?,?,?,?,?)");
	    ps.setString(1,uname);
	    ps.setString(2,pword);
	    ps.setString(3, fname);
	    ps.setString(4, sname);
	    ps.setString(5, address);
	    ps.setLong(6, phone);
	    ps.setString(7, mailid);
	    
		//step4:executing a query
	    int k=ps.executeUpdate();
	    if(k>=0)
	    {
	    	System.out.println("record created successfully");
	    }
	    else
	    {
	    	System.out.println("record creation failed");
	    }
	    
		//step5:close the connection
	    con.close();
	    sc.close();
		}//main close
	    

}//class close
