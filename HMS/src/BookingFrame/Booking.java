package BookingFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.time.temporal.ChronoUnit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class Booking extends JFrame{
private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable table_Food;
	int i;
	int city;
	int  Date_in;
	int Month_in;
	int Year_in;
	int o;
	JDateChooser dateChooser_chkin = new JDateChooser();
	JDateChooser dateChooser_chkout = new JDateChooser();
	JRadioButton rdbtnLodging = new JRadioButton("Lodging");
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_Plate = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_Days = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_Cuisine = new JComboBox();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking window = new Booking("Guest_User");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Booking(String UserName) {
		initialize(UserName);
	}
	
	
	
	void seto(int i)
	{
		
		this.o=i;
	}


@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(String UserName) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Booking.class.getResource("/reception/iconImg/1486107437_home_blue.png")));
	int o=0;
	
		frame.setBounds(100, 100, 944, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JRadioButton rdbtnFoodingAndLodging = new JRadioButton("Fooding And Lodging");
		Panel panel = new Panel();
		panel.setBounds(10, 10, 906, 306);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHotelTaj = new JLabel("HOTEL TAJ");
		lblHotelTaj.setForeground(new Color(64, 224, 208));
		lblHotelTaj.setFont(new Font("Courier New", Font.BOLD, 91));
		lblHotelTaj.setBounds(0, -66, 647, 256);
		panel.add(lblHotelTaj);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Booking.class.getResource("/hotelpics/140596_275_z.jpg")));
		lblNewLabel.setBounds(0, 0, 906, 306);
		panel.add(lblNewLabel);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 351, 421, 293);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox_City = new JComboBox();
		comboBox_City.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				city=comboBox_City.getSelectedIndex();
			
			}
		});
		comboBox_City.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_City.setModel(new DefaultComboBoxModel(new String[] {"Kolkata", "Bangalore", "Mumbai", "Chennai"}));
		comboBox_City.setBounds(186, 13, 98, 28);
		panel_1.add(comboBox_City);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCity.setBounds(12, 16, 69, 22);
		panel_1.add(lblCity);
		
		JLabel lblCheckInDate = new JLabel("Check In Date:");
		lblCheckInDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckInDate.setBounds(12, 72, 137, 41);
		panel_1.add(lblCheckInDate);
		
		JLabel lblCheckOutDate = new JLabel("Check Out Date:");
		lblCheckOutDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckOutDate.setBounds(12, 150, 162, 22);
		panel_1.add(lblCheckOutDate);
		
		JButton btnCheckRooms = new JButton("Check Rooms");
		btnCheckRooms.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		btnCheckRooms.setIcon(null);
		btnCheckRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String City=comboBox_City.getSelectedItem().toString();
					SimpleDateFormat dFormat=new SimpleDateFormat("YYYY:MM:dd");
					String d1=dFormat.format(dateChooser_chkin.getDate());
				    SimpleDateFormat dFormat1=new SimpleDateFormat("YYYY:MM:dd");
					String d2=dFormat1.format(dateChooser_chkout.getDate());
					/*LocalDate d3=LocalDate.parse(d1);
					LocalDate d4=LocalDate.parse(d2);
					long daysBetween =ChronoUnit.DAYS.between(d3, d4);
					JOptionPane.showConfirmDialog(null, "daysBetween");
					*/
					int days=comboBox_Days.getSelectedIndex();
					int plate=comboBox_Plate.getSelectedIndex();
					
					
					String t[]=new String[3];
					t=d1.split(":");
					final LocalDate chkindate,chkoutdate;
					chkindate=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
					t=d2.split(":");
					chkoutdate=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
					if(chkindate.compareTo(chkoutdate)<=0)
						{
						long d=ChronoUnit.DAYS.between(chkindate,chkoutdate);
						int g=(int)d;
						if(rdbtnLodging.isSelected()==true)
						{
						new RoomTable(d1,d2,City,UserName,null,0,0,0,g);	
						}
						else
						{
							new RoomTable(d1,d2,City,UserName,comboBox_Cuisine.getSelectedItem().toString(),comboBox_Cuisine.getSelectedIndex(),days+1,plate+1,g);	
							
						}
						}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID CHECKIN DATE AND CHECKOUT DATE!!!!");
					}
					

					
					}
				catch(Exception e)
				{e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Could Not Found");
				}
				
			}
		});
		btnCheckRooms.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCheckRooms.setBounds(121, 213, 217, 67);
		panel_1.add(btnCheckRooms);
		
		
		
		dateChooser_chkin.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser_chkin.setDateFormatString("d,M,yyyy");
		dateChooser_chkin.setBounds(186, 83, 126, 22);
		panel_1.add(dateChooser_chkin);
		
		
		dateChooser_chkout.setDateFormatString("d,M,yyyy");
		dateChooser_chkout.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser_chkout.setBounds(186, 150, 126, 22);
		panel_1.add(dateChooser_chkout);
		
		
		
		
		
	
			
		
		
		
		
		
		
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(437, 351, 467, 293);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		comboBox_Cuisine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=comboBox_Cuisine.getSelectedIndex();
			}
		});
		comboBox_Cuisine.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox_Cuisine.setModel(new DefaultComboBoxModel(new String[] {"Chinese-Veg", "Chinese Non-Veg", "Indian-Veg", "Indian Non-Veg", "Continental-Veg", "Continental Non-Veg"}));
		comboBox_Cuisine.setBounds(268, 17, 187, 35);
		panel_2.add(comboBox_Cuisine);
		
		JLabel lblCuisine = new JLabel("Prefered Cuisine :");
		lblCuisine.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCuisine.setBounds(32, 22, 187, 22);
		panel_2.add(lblCuisine);
		
		table_Food = new JTable();
		table_Food.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_Food.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_Food.setModel(new DefaultTableModel(
			new Object[][] {
				{"Price" , "Food Type(Rs)"},
				{"Chinese-Veg", "150"},
				{"Indian-Veg", "100"},
				{"Continental-Veg", "150"},
				{"Chinese Non-Veg", "150"},
				{"Indian Non-Veg", "100"},
				{"Continental Non-Veg", "150"},
				
			},
			new String[] {
				"Food Type", "Price"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_Food.setEnabled(false);
		table_Food.setBounds(32, 65, 424, 112);
		panel_2.add(table_Food);
		
		JLabel lblNoofDays = new JLabel("No.of Days :");
		lblNoofDays.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoofDays.setBounds(97, 201, 143, 22);
		panel_2.add(lblNoofDays);
		
		JLabel lblNoofPlatesday = new JLabel("No.of Plates/Day :");
		lblNoofPlatesday.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoofPlatesday.setBounds(97, 237, 176, 22);
		panel_2.add(lblNoofPlatesday);
		
		comboBox_Days.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_Days.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_Days.setBounds(300, 200, 56, 25);
		panel_2.add(comboBox_Days);
		
		comboBox_Plate.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_Plate.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_Plate.setBounds(300, 237, 56, 25);
		panel_2.add(comboBox_Plate);
		
		
		rdbtnLodging.setSelected(true);
		if(rdbtnLodging.isSelected())
		{
			panel_1.setVisible(true);
			panel_2.setVisible(false);
			rdbtnFoodingAndLodging.setSelected(false);
			
		}
	
		rdbtnLodging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnLodging.isSelected())
				{
					panel_1.setVisible(true);
					panel_2.setVisible(false);
					rdbtnFoodingAndLodging.setSelected(false);
					seto(0);
					
				}
				else
				{
					panel_1.setVisible(true);
					panel_2.setVisible(true);
					rdbtnFoodingAndLodging.setSelected(true);
					seto(1);
					
				}
				}
		});
		rdbtnLodging.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnLodging.setBounds(139, 322, 127, 25);
		frame.getContentPane().add(rdbtnLodging);
		
		
		rdbtnFoodingAndLodging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFoodingAndLodging.isSelected())
				{
					panel_1.setVisible(true);
					panel_2.setVisible(true);
					rdbtnLodging.setSelected(false);
					
				}
				else
				{
					panel_1.setVisible(true);
					panel_2.setVisible(false);
					rdbtnLodging.setSelected(true);
				}
				}
		});
		rdbtnFoodingAndLodging.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnFoodingAndLodging.setBounds(579, 322, 199, 25);
		frame.getContentPane().add(rdbtnFoodingAndLodging);
		frame.setVisible(true);
		
		
	
	}




void reset(String username)
{
	this.dispose();
	initialize(username);
}
}
