package test;
import java.io.Serializable;
public class DisplayProducts_1 {
//in these it contains 3 fields of db data in the form of variable(value) one is map variable key
	public String pname;
	public int pprice;
	public int pquantity;
	
	public DisplayProducts_1(String pname,int pprice,int pquantity) {
		this.pname=pname;
		this.pprice=pprice;
		this.pquantity=pquantity;
		
	}
	public String toString()
	{
		return pname+"\t"+pprice+"\t"+pquantity;
	}
	
	
	
}
