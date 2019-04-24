package test;
import java.io.Serializable;
public class StudentSearch_list {
//here we take all the details of student db data in the form of variables

	public String name,address,branch,result,status;
	public int roll_no,subject1,subject2,subject3,subject4,subject5,subject6,total_marks,per;
	public StudentSearch_list(int roll_no,String name,String address,String branch,int subject1,int subject2,
			int subject3,int subject4,int subject5,int subject6,int total_marks,int per,String result,String status) {
			   this.roll_no=roll_no;
			   this.name=name;
			   this.address=address;
			   this.branch=branch;
			   this.subject1=subject1;
			   this.subject2=subject2;
			   this.subject3=subject3;
			   this.subject4=subject4;
			   this.subject5=subject5;
			   this.subject6=subject6;
			   this.total_marks=total_marks;
			   this.per=per;
			   this.result=result;
			   this.status=status;
		
	}
	
	public String toString() {
		return roll_no+" "+name+" "+branch+"\t"+subject1+"\t"+subject2+"\t"+subject3+"\t"+subject4+"\t"
				+subject5+"\t"+subject6+"\t"+total_marks+"\t"+per+"\t"+result+"\t"+status;
	}
	
	
}
