package BookingFrame;


import java.io.FileWriter;

import java.io.PrintWriter;

public class Client {
	private String fName, mName,lName,Address,AdharNo,Gender,MobileNo,EmailID,Password;


	Client(String fName, String mName, String lName, String Address, String AdharNo, String Gender, String MobileNo, String EmailID,String Password)
	{
		this.fName=fName;
		this.mName=mName;
		this.lName=lName;	
		this.Address=Address;
		this.AdharNo=AdharNo;
		this.Gender=Gender;
		this.MobileNo=MobileNo;
		this.EmailID=EmailID;
		this.Password=Password;
		WriteClientDetails(this);
	}
public static void WriteClientDetails(Client obj)
{
try{
	FileWriter x = new FileWriter("Resources/Client/ClientFile.txt",true);
	PrintWriter g=new PrintWriter(x);
	g.print(obj.fName+" ");
	g.print(obj.mName+" ");
	g.print(obj.lName+" ");
	g.print(obj.Address+" ");
	g.print(obj.AdharNo+" ");
	g.print(obj.Gender+" ");
	g.print(obj.MobileNo+" ");
	g.print(obj.EmailID+" ");
	g.print(obj.Password+" ");
	g.print("0"+" ");
	g.println(" ");
	x.close();
}
catch(Exception e){e.printStackTrace();}
}


}
