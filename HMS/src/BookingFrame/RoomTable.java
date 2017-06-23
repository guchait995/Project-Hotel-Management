package BookingFrame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class RoomTable extends JFrame {
	private static final long serialVersionUID = 1L;
    private static String cin,cout;
	private JPanel contentPane;
	private static JTable table;
	private static JTable table1;
	 int i=0;
	 String g;
	 static int num=0;
	 static int Room_Price=0;
		
	/**
	 * @wbp.parser.constructor
	 */
	@SuppressWarnings("static-access")
	public RoomTable(String chkin,String chkout,String City,String UserName,String Booked_Food,int Price,int days,int plate,int d1) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.cin=chkin;
		this.cout=chkout;
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{ "Room No.", "Room Type", "Bed", "Rate"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Room No.", "Room Type", "Bed", "Rate"
			}
		));
		table.setBounds(49, 125, 700, 304);
		RoomDetails.Readfile("Resources/City/"+City+".txt");
		
		contentPane.add(table);
		@SuppressWarnings("unused")
		int  y;
		JButton btnBookroom = new JButton("Book Room");
		btnBookroom.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBookroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			RoomDetails.Select("Resources/City/"+City+".txt", UserName,num);
			
			
			
			
			reset(chkin,chkout,City,UserName,Booked_Food,Price,num,days,plate,d1);
			}
		});
	
		btnBookroom.setBounds(299, 467, 142, 49);      
		contentPane.add(btnBookroom);
		
		lblNewLabel = new JLabel(City+" Branch Available Room List");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(49, 13, 700, 72);
		contentPane.add(lblNewLabel);
		setVisible(true);
		
	}
	static int z=0;
	private JLabel lblNewLabel;
	@SuppressWarnings("static-access")
	void reset(String d1,String d2,String City, String UserName,String Booked_Food,int Price,int num,int days,int plate,int d3)
	{
		
		num=this.num;
		this.dispose();
		
		
			i=JOptionPane.showConfirmDialog(null,"Want to book more rooms?");
			
			z=z+Integer.parseInt(RoomDetails.Room);
			
			if(i==0){
			
				@SuppressWarnings("unused")
			RoomTable r1=new RoomTable(d1,d2,City,UserName,Booked_Food,Price,days,plate,d3);
			
		
		
			}
			else
			{
			
				int k1=UpdateClientVisits.UpdateVisits(UserName);
				Billing Billing_Food=new Billing(City,UserName,Booked_Food,Price,z,num,days,plate,d3,k1);
				Billing_Food.setVisible(true);
			}
	}
	
	public RoomTable(String City) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{ "Room No.", "Room Type", "Bed", "Rate"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Room No.", "Room Type", "Bed", "Rate"
			}
		));
		table1.setBounds(49, 125, 700, 304);
		
		RoomDetails.Readfile1("Resources/City/"+City+".txt");
		
		contentPane.add(table1);
		setVisible(true);
		
	}
	public static class RoomDetails
	{
		String Roomno,RoomType,Bed,Rate;
		String a,b,c,d;
		static String Room=null;
		public RoomDetails()
		{
			
		}
		
		
				public static void Readfile1(String City)
		{
			
			Scanner x=null;
			Scanner g=null;
			int n=5;
			int i=1;
			String data[]=new String[n];
			try{
				x=new Scanner(new File(City));
				g=new Scanner(new File(City));
				while(g.hasNextLine())
				{g.nextLine();
					
				}
            
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Couldnt find a file named... "+City+".txt");
			} 
			
			
				while(x.hasNext())
				{
					
					data[0]=x.next();
				int Index=	Integer.parseInt(x.next());
					data[1]=x.next();
					data[2]=x.next();
					data[3]=x.next();
					for(int x1=0;x1<Index;x1++)
					{
						x.next();
						x.next();
					}
					RoomTable( i,data[0],data[1],data[2],data[3]);
					i++;}
						}
		public static void RoomTable(int i,String a,String b,String c,String d)
		{
			
			DefaultTableModel model=(DefaultTableModel)table1.getModel();
			Object rowData[]=new Object[4];
			
				rowData[0]=a;
				rowData[1]=b;
				rowData[2]=c;
				rowData[3]=d;
				model.setValueAt(rowData[0], i, 0);
				model.setValueAt(rowData[1], i, 1);
				model.setValueAt(rowData[2], i, 2);
				model.setValueAt(rowData[3], i, 3);
				
	}

		
		public static void Readfile(String City)
		{
			
			Scanner x;
			int n=5;
			int count=0;
			int i=1;
			String data[]=new String[n];
			try{
				

				x=new Scanner(new File(City));		
				while(x.hasNext())
				{
					data[0]=x.next();
					int Index=	Integer.parseInt(x.next());
					data[1]=x.next();
					data[2]=x.next();
					data[3]=x.next();
					int y=0;
					for(int x1=0;x1<Index;x1++)
					{
						String date1,date2;
						date1=x.next();
						date2=x.next();
						final LocalDate lastday,firstday,checkindate,checkoutdate;	
						String t[]=new String[3];
						date1.split(":");
						t= date1.split(":");
						checkindate=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
						t=date2.split(":");
						checkoutdate=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
						t=cin.split(":");
						firstday=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
						t=cout.split(":");
						lastday=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
						
						if(firstday.compareTo(checkindate)<=0&&lastday.compareTo(checkindate)>=0)
						{
							y=1;
						}
						else if(firstday.compareTo(checkoutdate)<=0&&lastday.compareTo(checkoutdate)>=0)
						{
							y=1;
						}
						else if(checkindate.compareTo(firstday)<=0&&checkoutdate.compareTo(firstday)>=0)
						{
							y=1;
						}
						else if(checkindate.compareTo(lastday)<=0&&checkoutdate.compareTo(lastday)>=0)
						{
							y=1;
						}
						
					}
					if(y==0 ){
					RoomTable( i,count,City,data[0],data[1],data[2],data[3]);
					i++;}
					count--;
			}
			}catch(Exception e)
			{e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Couldnt find a file named... "+City+".txt");
			}
			
			
			
		}
		
		public static void RoomTable(int i,int count,String City,String a,String b,String c,String d)
		{
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			
			Object rowData[]=new Object[4];
			
				rowData[0]=a;
				rowData[1]=b;
				rowData[2]=c;
				rowData[3]=d;
				model.setValueAt(rowData[0], i, 0);
				model.setValueAt(rowData[1], i, 1);
				model.setValueAt(rowData[2], i, 2);
				model.setValueAt(rowData[3], i, 3);
				}
		
		
		
		
				@SuppressWarnings("unused")
				public static String Select(String City,String UserName,int num1)
				{	
					num++;
				
					DefaultTableModel model=(DefaultTableModel)table.getModel();
				int index=RoomTable.table.getSelectedRow();
				String Room_Price=RoomTable.table.getValueAt(index,3).toString();
				Room=Room_Price;
				String rno=model.getValueAt(index, 0).toString();
				File Original=new File(City);
				
				File Clone=new File("Resources/City/clone2.txt");
				
				Scanner x;
				PrintWriter g;
				try{
					x=new Scanner(Original);
					 g=new PrintWriter(new FileWriter(Clone));
					 String a;
					 while(x.hasNext())
						{
							String Roomno=x.next();
	
						g.print(Roomno+" ");
				
						int Index;
								if(Roomno.equals(rno))
								{
	
									Index=Integer.parseInt(x.next());
									
										g.print((Index+1)+" ");
										for(int x1=0;x1<3;x1++)
											{
											a=x.next();
											
											g.print(a+" ");
											}
										for(int x1=0;x1<Index;x1++)
										{a=x.next();
											g.print(a+" ");
											a=x.next();
											g.print(a+" ");
													
										}
										g.print(cin+" ");
										g.print(cout+" ");
										g.println(" ");
							
								}
								else{
									

								Index=Integer.parseInt(x.next());
								g.print(Index+" ");

								for(int x1=0;x1<3;x1++)
								{
									a=x.next();
									g.print(a+" ");
								}
								for(int x1=0;x1<Index;x1++)
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
					
				}
				catch(Exception e){
					e.printStackTrace();
					
				}
				

				try {		
					PrintWriter p=new PrintWriter(Original);
					p.flush();
					p.close();
					copyFile(Clone,Original);
					Clone.delete();
				} catch (Exception e) {
				}	
				
				
				
				//Now we will write the  username and the roomno into a file called userBOookrooms using the index num
				Scanner x1,x2;
				PrintWriter g1,g2;
				
				File User_Room=new File("Resources/City/CloneUserBooked.txt");
				File Clone_User_Room=new File("Resources/City/UserBookRooms.txt");
				
				try {
					
					//copyFile(Clone_User_Room,User_Room);
					
				} catch (Exception e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try{ 
					
					PrintWriter d=new PrintWriter(new FileWriter(User_Room,true));
					d.close();
					 x1=new Scanner(User_Room);
					
					 g1=new PrintWriter(new FileWriter(Clone_User_Room));
					int i=1;
					while(x1.hasNext())
					{
						String Usr=x1.next();
						
						if(Usr.equals(UserName)==true)
						{
							
						
							
							i=0;
							g1.print(Usr+" ");
							for(int h=0;h<num1;h++)
							{
								
								String a=x1.next();
								g1.print(a+" ");
							}
							String y=x1.nextLine();
							g1.print(rno+" ");
							g1.println(" ");
							
						}
						else
						{
							g1.print(Usr+" ");
							String a=x1.nextLine();
							 g1.println(a);
						}
					}
					if(i==1)
					{
						g1.print(UserName+" ");
						
						g1.print(rno+" ");
						g1.println(" ");
					}
					g1.close();
					x1.close();					
					
					g1.flush();
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			return rno;
				}
				
	}
	private static void copyFile(File source, File dest) throws IOException 
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
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally {
	        is.close();
	        os.close();
	    }
	}
}
