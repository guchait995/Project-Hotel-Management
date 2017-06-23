package BookingFrame;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class ClientTable extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	 int i=0;
		public ClientTable(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{ "RoomNo", "Index", "Check In", "Check Out"},
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
		BookingDetails ro = new BookingDetails();
	
		ro.Readfile(s);
		try
		{
		ro.Readfile("City\\"+s+".txt");
		}
		catch(Exception e)
		{
			
		}
		
		contentPane.add(table);
		
		JLabel lblKolkataBranchRoom = new JLabel(s+" Branch Room List");
		lblKolkataBranchRoom.setForeground(Color.ORANGE);
		lblKolkataBranchRoom.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblKolkataBranchRoom.setBounds(233, 26, 332, 86);
		contentPane.add(lblKolkataBranchRoom);
		setVisible(true);
		
	}
	public class BookingDetails
	{
		String a,b,c,d;
		
		public BookingDetails()
		{
			}
		

		
	
		
		
		public void Readfile(String City)
		{
			Scanner x=null;
			int n=4;
			int i=1;
			String data[]=new String[n];
			try{
				
				x=new Scanner(new File("Booking\\"+City+"_Client.txt"));
				
			}catch(Exception e)
			{
			 JOptionPane.showMessageDialog(null,"Cant find File");
			}
			
				while(x.hasNext())
				{
					
					data[0]=x.next();
					this.a=data[0];
					data[1]=x.next();
					this.b=data[1];
					data[2]=x.next();
					this.c=data[2];
					ClientTable(i);
					i++;
					
				}
			
			
			
			
		}
		
		public void ClientTable(int i)
		{
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			Object rowData[]=new Object[4];
				rowData[0]=null;
				rowData[1]=a;
				rowData[2]=b;
				rowData[3]=c;
				model.setValueAt(rowData[0], i, 0);
				model.setValueAt(rowData[1], i, 1);
				model.setValueAt(rowData[2], i, 2);
				model.setValueAt(rowData[3], i, 3);
				
			
		}

		
		
	}
}
