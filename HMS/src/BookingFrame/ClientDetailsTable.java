package BookingFrame;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
//import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class ClientDetailsTable extends JFrame {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String Fname,Mname,Lname,Address,AdharNo,Gender,MobileNo,Emailid,Visited;
	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientDetailsTable frame = new ClientDetailsTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientDetailsTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"First Name", "Middle Name", "Last Name", "Address", "AdharNo", "Gender", "Mobile Number", "Email-ID","Visited"},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null,null},
			},
			new String[] {
					"First Name", "Middle Name", "Last Name", "Address", "AdharNo", "Gender", "Mobile Number", "Email-ID","Visited"
			}
		));
		table.setBounds(10, 78, 657, 235);
		
		ReadClientFile();

		contentPane.add(table);
		
		JLabel lblClientDetails = new JLabel("CLIENT DETAILS");
		lblClientDetails.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 20));
		lblClientDetails.setBounds(273, 11, 236, 26);
		contentPane.add(lblClientDetails);
		
		setVisible(true);
	}
	
	public void ReadClientFile(){
		Scanner x=null;
		 String data[]=new String[90];
		 int i=1;
		 try{
			 
			 
			 x=new Scanner(new File("Resources/Client/ClientFile.txt"));
			 
			
		 }
		catch(Exception e)
		 {
			e.printStackTrace();}
		 while(x.hasNext())
		 {
			 
			 data[0]=x.next();
			 this.Fname=data[0];
			 data[1]=x.next();
			 this.Mname=data[1];
			 data[2]=x.next();
			 this.Lname=data[2];
			 data[3]=x.next();
			 this.Address=data[3];
			 data[4]=x.next();
			 this.AdharNo=data[4];
			 data[5]=x.next();
			 this.Gender=data[5];
			 data[6]=x.next();
			 this.MobileNo=data[6];
			 data[7]=x.next();
			 this.Emailid=data[7];
			 x.next();
			 data[8]=x.next();
			 this.Visited=data[8];
			 
			
			 PrintClientDetails( i);
			
			 i++;
			 
		 }
		
		
	}
	public void PrintClientDetails(int i)
	
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
	Object rowdata[]=new Object[9];
	
	rowdata[0]=Fname;
	rowdata[1]=Mname;	
	rowdata[2]=Lname;
	rowdata[3]=Address;
	rowdata[4]=AdharNo;
	rowdata[5]=Gender;
	rowdata[6]=MobileNo;
	rowdata[7]=Emailid;
	rowdata[8]=Visited;
	model.setValueAt(rowdata[0], i, 0);
	model.setValueAt(rowdata[1], i, 1);
	model.setValueAt(rowdata[2], i, 2);
	model.setValueAt(rowdata[3], i, 3);
	model.setValueAt(rowdata[4], i, 4);
	model.setValueAt(rowdata[5], i, 5);
	model.setValueAt(rowdata[6], i, 6);
	model.setValueAt(rowdata[7], i, 7);
	model.setValueAt(rowdata[8], i, 8);
	}
}

