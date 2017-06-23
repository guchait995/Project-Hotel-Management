package BookingFrame;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class Billing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f=new JFrame();
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Billing frame = new Billing(null,null,null,0,0,0,0,0,0,0);
					
				  frame.setVisible(true);
				  getFrame(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static int p=0;
	
	JFrame frame;
	static JFrame getFrame(JFrame frame)
	{
		
		
		return frame;
	}
	
	int RoomRent=0;
	
	String getRoomRent()
	{
		return(String.valueOf(RoomRent));
	}
	/**
	 * Create the frame.
//	 *///public Billing() {
	
	
		int day=0;
	public Billing(String City,String UserName,String Booked_Food,int Food_Index,int Room_Price,int No_of_Room,int days,int plate,int Room_days,int Visited) {
		setTitle("Hotel Taj");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Billing.class.getResource("/iconImg/1486107437_home_blue.png")));
		
		if(Room_days==0)
		{
			Room_days=1;
		
		}
		
		
		
		
		//....................................................................
		int Discount=0;
		int Food_p=0,Food=0,Room_Rate=0;
		double g=0,vat=0,Total=0,Discount_Price=0,Grand_Total=0;
		String Food1=null;
		
		if(Visited>=2 && Visited <=3)
		{
			Discount=10;
			Food_p=Bill(Food_Index);
			Food=Food_p*days*plate;
			if(Food==0)
			{
				Food1=null;
			}
			else
				{Food1=String.valueOf(Food);}
			Room_Rate=Room_Price*Room_days;
			g=(Food+Room_Rate);
			vat=g*14.5/100;
			Total=Food+Room_Rate+vat;
			Discount_Price=Total*10/100;
			Grand_Total=Total-Discount_Price;
		}
		else if(Visited>3)
		{
			Discount=20;
			Food_p=Bill(Food_Index);
			Food=Food_p*days*plate;
			if(Food==0)
			{
				Food1=null;
			}
			else
				{Food1=String.valueOf(Food);}
			Room_Rate=Room_Price*Room_days;
			g=(Food+Room_Rate);
			vat=g*14.5/100;
			Total=Food+Room_Rate+vat;
			Discount_Price=Total*20/100;
			
			Grand_Total=Total-Discount_Price;
		}
		else if(Visited<2)
		{
				Food_p=Bill(Food_Index);
				Food=Food_p*days*plate;
				if(Food==0)
				{
					Food1=null;
				}
				else
					{Food1=String.valueOf(Food);}
				Room_Rate=Room_Price*Room_days;
				g=(Food+Room_Rate);
				vat=g*14.5/100;
				Total=Food+Room_Rate+vat;
				Grand_Total=Total-Discount_Price;
		}		
		if(Visited>=2)
		{JOptionPane.showMessageDialog(null, "Congrats You got a"+Discount+"% Discount coz u Visted "+Visited+" Times");
		}
		//...............................................
				
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 539);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setForeground(Color.PINK);
		lblFood.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFood.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFood.setBounds(100, 30, 112, 55);
		contentPane.add(lblFood);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.PINK);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrice.setBounds(258, 41, 76, 33);
		contentPane.add(lblPrice);
		
		JLabel label_Food_Name = new JLabel(Booked_Food);
		label_Food_Name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Food_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_Food_Name.setBounds(100, 99, 112, 21);
		contentPane.add(label_Food_Name);
		
		
		
		
		
		
		JLabel label_Food = new JLabel(Food1);
		label_Food.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Food.setBounds(258, 98, 112, 21);
		contentPane.add(label_Food);
		
		JLabel label_Vat = new JLabel(String.valueOf(vat));
		label_Vat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Vat.setBounds(258, 220, 112, 21);
		contentPane.add(label_Vat);
		
		JLabel lblVat = new JLabel("Vat:+14.5%");
		lblVat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVat.setBounds(136, 223, 76, 21);
		contentPane.add(lblVat);
        getContentPane().setLayout(null);
		
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//JFrame f=new JFrame();
				Point p=contentPane.getLocationOnScreen();
			
				BufferedImage bi=robot.createScreenCapture(new Rectangle((int)p.getX(),100,contentPane.getWidth(),contentPane.getHeight()));
                try {
					ImageIO.write(bi, "jpg", new File("Resources\\Bill\\image.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				JOptionPane.showMessageDialog(null, "Bill Created");
				File path=new File("Resources\\Bill\\image.jpg");
				try {
					Desktop.getDesktop().open(path);
				} catch (IOException e) {
					}
			}
		});
		btnPrint.setBounds(170, 454, 97, 25);
		getContentPane().add(btnPrint);
		
		JLabel lblGrandTotal = new JLabel("Grand Total :");
		lblGrandTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrandTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGrandTotal.setBounds(111, 332, 101, 16);
		contentPane.add(lblGrandTotal);
		
		JLabel label_FoodTotal = new JLabel(String.valueOf(Grand_Total));
		label_FoodTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_FoodTotal.setBounds(258, 316, 97, 38);
		contentPane.add(label_FoodTotal);
		
		JLabel lblRoomRent = new JLabel("Room Rent");
		lblRoomRent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomRent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRoomRent.setBounds(100, 139, 112, 21);
		contentPane.add(lblRoomRent);
		
		JLabel label_Room = new JLabel(String.valueOf(Room_Rate));
		label_Room.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Room.setBounds(258, 138, 112, 21);
		contentPane.add(label_Room);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setForeground(new Color(60, 179, 113));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(20, 11, 101, 25);
		contentPane.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel(UserName);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(123, 11, 301, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblCustomerRequestedTo = new JLabel("Customer is Requested to bring a copy of the bill to reception");
		lblCustomerRequestedTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerRequestedTo.setBounds(12, 410, 408, 38);
		contentPane.add(lblCustomerRequestedTo);
		
		JLabel lblDiscount = new JLabel("Discount("+String.valueOf(Discount)+"%)");
		lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiscount.setBounds(100, 294, 112, 21);
		contentPane.add(lblDiscount);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(100, 257, 112, 21);
		contentPane.add(lblTotal);
		
		JLabel label = new JLabel(String.valueOf(Discount_Price));
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(258, 293, 112, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(String.valueOf(Total));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(258, 256, 112, 21);
		contentPane.add(label_1);
		
		JLabel lblThankYouVisit = new JLabel("Thank You, Visit Us Again");
		lblThankYouVisit.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouVisit.setBounds(12, 383, 408, 38);
		contentPane.add(lblThankYouVisit);
	}
	
	
	
	
	//................................................ReadFile...................................................
	
	

	public int Bill(int price)
	{
		
		int Food_Bill=0;
		switch(price)
		{
		case 0:{
			Food_Bill=150;
			
			break;
		}

		case 1:{
			Food_Bill=150;
			break;
		}
		case 2:{
			Food_Bill=100;
			break;
		}
		case 3:{
			Food_Bill=100;
			break;
		}
		case 4:{
			Food_Bill=150;
			break;
		}
		case 5:{
			Food_Bill=150;
			break;
		}
		}
		
		return Food_Bill;
		
	}
}
