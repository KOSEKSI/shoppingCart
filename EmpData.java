package test;

public class EmpData {
	public String Empid;
	public String Ename;
	public String Desc;
	public int bsal;
	public int age;
	
	public EmpData(String Empid,String Ename,String Desc,int bsal,int age)
	{
	//for initialization purpose we use constructor	
		this.Empid=Empid;
		this.Ename=Ename;
		this.Desc=Desc;
		this.bsal=bsal;
		this.age=age;
		
	}
	public String toString()
	{
		return "  "+Empid+"\t"+Ename+"\t"+Desc+"\t"+bsal+"\t"+age;
	}
}
