package test;

import java.io.Serializable;

public class EmpData1 implements Serializable {
 public String Ename;
 public String Desc;
 public int bsal;
 public int age;
	public EmpData1(String Ename,String Desc,int bsal,int age) {

		this.Ename=Ename;
		this.Desc=Desc;
		this.bsal=bsal;
		this.age=age;
      }
	public String toString() {
		return Ename+"\t"+Desc+"\t"+bsal+"\t"+age;
		
	}
	
	
	
}
