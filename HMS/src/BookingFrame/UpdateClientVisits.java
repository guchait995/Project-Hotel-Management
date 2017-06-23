package BookingFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class UpdateClientVisits {
	public static int UpdateVisits(String Username)
	{
		File Original=new File("Resources/Client/ClientFile.txt");
		File Clone=new File("Resources/Client/CloneClientFile.txt");
		PrintWriter g;
		int Visits=0;
		Scanner x;
		try{
			x=new Scanner(Original);
			g=new PrintWriter(new FileWriter(Clone));
			while(x.hasNext())
			{
				for(int i=0;i<4;i++)
				{
					String s=x.next();
					g.print(s+" ");
				}
				String Usr=x.next();
				g.print(Usr+" ");
				if(Usr.equals(Username))
				{
					for(int j=0;j<4;j++)
					{
						String s=x.next();
						g.print(s+" ");
					}
					Visits=Integer.parseInt(x.next());
					Visits++;
					g.print(Visits+" ");
					g.println(" ");
					
				}
				else
				{
					String s=x.nextLine();
					g.println(s);
				}
			}
			g.close();
			x.close();
			Update.copyFile(Clone, Original);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Visits;
	}

}
