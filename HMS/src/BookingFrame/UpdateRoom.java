package BookingFrame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class UpdateRoom {
public UpdateRoom() 
{

}

public static void updateRoom(String City,String RoomNo,String RoomType,String Bed,String Rate )
{Scanner x;
PrintWriter g;
File Original=new File(City+".txt");
File Clone=new File("UpdateClone.txt");
try
{
x=new Scanner(Original);
g=new PrintWriter(new FileWriter(Clone));
String a;
while(x.hasNext())
{	String rno=x.next();                       //reading
	if(rno.equals(RoomNo))
	{	g.print(rno+" ");
		int Index=Integer.parseInt(x.next());
	g.print(Index+" ");                        //writing
	a=x.next();
	g.print(RoomType+" ");
	a=x.next();
	g.print(Bed+" ");
	a=x.next();
	g.print(Rate+" ");
	
	for(int y=0;y<Index;y++)
	{
		a=x.next();
		g.print(a+" ");
		a=x.next();
		g.print(a+" ");
	}
	g.println(" ");	
	}
	else
		{	g.print(rno+" ");
			int Index=Integer.parseInt(x.next());
			g.print(Index+" ");                        //writing
			a=x.next();
			g.print(a+" ");
			a=x.next();
			g.print(a+" ");
			a=x.next();
			g.print(a+" ");
	
			for(int y=0;y<Index;y++)
				{
					a=x.next();
					g.print(a+" ");
					a=x.next();
					g.print(a+" ");
				}
			g.println(" ");
	}
	
}
x.close();
g.close();

Update.copyFile(Clone, Original);
Clone.delete();
}
catch(Exception e)
{
e.printStackTrace();	
}
}


}
class Update{
	
		
	
	
	static void copyFile(File source, File dest) throws IOException 
	{
		
		InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {}
	        is.close();
	        os.close();
	    
	}
	
	
	

		
		
	}

	
	
	
	
