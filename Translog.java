package test;

import java.io.Serializable;
import java.util.Date;

public final class Translog implements Serializable{

	private final double refid;
	private final Date d;
	private final int acno1;
	private final int amt;
public Translog(double refid,Date d,int acno1,int amt) {
	// TODO Auto-generated constructor stub
	this.refid=refid;
	this.d=d;
	this.acno1=acno1;
	this.amt=amt;
}

public final String toString ()
{
	return refid+""+d+" "+acno1+" "+amt;
}

}
