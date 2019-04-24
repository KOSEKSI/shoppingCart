package test;

import java.util.Scanner;
import java.sql.*;//import sql package
//write a program to register the student details 
public class JdbcStudentRegistration {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
       /*requirements are
        * 
        *  rollno:,name,branch ,address,subject1,
	    *  subject2,subject3,subject4,subject5,subject6;,
	    *  totalmarks,percentage
	    */
		System.out.println("welcome to Student Registration");
		Scanner scr=new Scanner(System.in);
		
		System.out.println("please enter student rollno");
		int rollno=scr.nextInt();
		System.out.println("please enter student name");
		String name=scr.nextLine();
		String name1=scr.nextLine();
		System.out.println("please enter student address");
		String address=scr.nextLine();
		System.out.println("please enter student branch");
		String branch=scr.nextLine();
		System.out.println("please enter subject1 marks");
		int  subject1=scr.nextInt();
		System.out.println("please enter subject2 marks");
		int  subject2=scr.nextInt();
		System.out.println("please enter subject3 marks");
		int subject3=scr.nextInt();
		System.out.println("please enter subject4 marks");
		int subject4=scr.nextInt();
		System.out.println("please enter subject5 marks");
		int subject5=scr.nextInt();
		System.out.println("please enter subject6 marks");
		int subject6=scr.nextInt();
		if((subject1>100 || subject2>100 || subject3>100||subject4>100||subject4>100||subject4>100)) {
			System.out.println("marks must between o to 100 only");
		}
		else if( subject1<0 || subject2<0||subject3<0||subject4<0||subject5<0||subject6<0) {
			System.out.println("marks must between o to 100 only");
		}
			
		else {
			
		
		System.out.println("You Are Entered Details Are");
		System.out.println("RollNo\t"+rollno);
		System.out.println("Name\t"+name1);
		System.out.println("Address\t"+address);
		System.out.println("branch\t"+branch);
		System.out.println("subject1\t"+subject1);
		System.out.println("subject2\t"+subject2);
		System.out.println("subject3\t"+subject3);
		System.out.println("subject4\t"+subject4);
		System.out.println("subject5\t"+subject5);
		System.out.println("subject6\t"+subject6);
		
		int totalmarks=subject1+subject2+subject3+subject4+subject5+subject6;

		System.out.println("TotalMarks"+totalmarks);
		int per;
		per=totalmarks/6;
		String result="",status="";
		System.out.println("percentage:"+per);
		if(subject1<35 || subject2<35 || subject3<35|| subject4<35|| subject5<35|| subject6<35) {
			result="fail";
			status="no class";
			/*
			System.out.println("Result"+result);
			System.out.println("Status"+status);
			*/
		}
		else if(per<=35) {
			//to check the status he is fail or pass
			result="fail";
			status="no class";
/*
			System.out.println("Result"+result);
			System.out.println("Status"+status);
			*/
			
		}
		else if(per>70 && per<=100)
		{
		    result="pass";
		    status="Distinction";
/*
			System.out.println("Result"+result);
			System.out.println("Status"+status);
			*/
		    
		}
		else if(per>=60 && per<=70)
		{
			result="pass";
			status="Firstclass";
/*
			System.out.println("Result"+result);
			System.out.println("Status"+status);
			*/
		}
		else if(per>=50 && per<60)
		{
			result="pass";
			status="ThirdClass";
/*
			System.out.println("Result"+result);
			System.out.println("Status"+status);
			*/
        }
		else if(per>=35 && per<50)
		{
			result="pass";
			status="fourth calss";
/*
			System.out.println("Result"+result);
			System.out.println("Status"+status);
			*/
		}
		else
		{
			
		}
		System.out.println("Result"+result);
		System.out.println("Status"+status);
		//step1:load Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");//throws ClassNotFoundException
		//step2:Creating a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		//step3:preparing a statement
		PreparedStatement ps=con.prepareStatement("insert into studentrecords11 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,rollno);
		ps.setString(2,name1);
		ps.setString(3,address);
		ps.setString(4,branch);
		ps.setInt(5,subject1);
		ps.setInt(6,subject2);
		ps.setInt(7,subject3);
		ps.setInt(8,subject4);
		ps.setInt(9,subject5);
		ps.setInt(10,subject6);
		ps.setInt(11,totalmarks);
		ps.setInt(12,per);
		ps.setString(13,result);
		ps.setString(14,status);
		//step4:execute query
		int k=ps.executeUpdate();
		if(k>=0)
		{
			System.out.println("record created successfully");
		}
		else
		{
			System.out.println("record creation failed");
		}
		//close connection
		con.close();
		scr.close();
		}
		
		}//main close

	
}