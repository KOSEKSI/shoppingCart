package test;

import java.io.Serializable;

public class DisplayProducts implements Serializable{
	//in this class initialize the db/table variables and initialization and return
	String pcode,pname;
	int pprice,pquantity;
	public DisplayProducts(String pcode,String pname,int pprice,int pquantity) {
	
		this.pcode=pcode;
		this.pname=pname;
		this.pprice=pprice;
		this.pquantity=pquantity;
		
	}
	public String toString()
	{
		return pcode+"   "+pname+"   "+pprice+"   "+pquantity;
	}

}
