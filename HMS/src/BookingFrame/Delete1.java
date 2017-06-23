package BookingFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Delete1 {
@SuppressWarnings("unused")
public static void DeleteRoom(String City,String Roomno)
{
	File Original=new File("Resources/City/"+City+".txt");
	File Clone=new File("Resources/City/Deleted.txt");
	Scanner x=null;	

try{
	Update.copyFile(Original,Clone);
	x=new Scanner(Clone);
	@SuppressWarnings("resource")
	PrintWriter d=new PrintWriter(new FileWriter("Resources/City/"+City+".txt"));
	d.flush();
	PrintWriter g;
    

while(x.hasNext())
{
	g=new PrintWriter(new FileWriter("Resources/City/"+City+".txt",true));
String rno=x.next();

if(rno.equals(Roomno))
{
	int Index=Integer.parseInt(x.next());
for(int z=0;z<3;z++)
{
String a=x.next();

}
for(int z=0;z<Index;z++)
{
	String b=x.next();
	String c=x.next();
	

	}
	}
	
else
{	

	g.print(rno+" ");
	int Index=Integer.parseInt(x.next());
	g.print(Index+" ");
	
	for(int z=0;z<3;z++)
	{
	String a=x.next();
	
	g.print(a+" ");
	}
	
	
	for(int z=0;z<Index;z++)
	{String b=x.next();
		g.print(b+" ");
		String c=x.next();
		g.print(c+" ");
		
		}
	
	g.println("");
}
g.close();
	
}

}
catch(Exception e)
{
e.printStackTrace();

}
x.close();


}

}
