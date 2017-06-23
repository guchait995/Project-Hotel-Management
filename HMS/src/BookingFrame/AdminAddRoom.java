package BookingFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminAddRoom extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_RoomNo;
	private JTextField textField_Rate;
	private JLabel lblCity;
	@SuppressWarnings("rawtypes")
	private JComboBox BedNo;
	private JLabel lblRoomType;
	@SuppressWarnings("rawtypes")
	private JComboBox RoomTyp;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblAddRoom;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddRoom frame = new AdminAddRoom();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminAddRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Room No  :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(61, 279, 118, 39);
		contentPane.add(label);
		
		textField_RoomNo = new JTextField();
		textField_RoomNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE)
				{
					JOptionPane.showMessageDialog(null, "Space isnt allowed here");
					textField_RoomNo.setText(null);
				}
			}
		});
		textField_RoomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_RoomNo.setColumns(10);
		textField_RoomNo.setBounds(221, 279, 257, 39);
		contentPane.add(textField_RoomNo);
		
		JLabel lblRoomRate = new JLabel("Room Rate  :");
		lblRoomRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRoomRate.setBounds(61, 346, 118, 39);
		contentPane.add(lblRoomRate);
		
		textField_Rate = new JTextField();
		textField_Rate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE)
				{
					JOptionPane.showMessageDialog(null, "Space isnt allowed here");
					textField_Rate.setText(null);
				}

			}
		});
		textField_Rate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Rate.setColumns(10);
		textField_Rate.setBounds(221, 346, 257, 39);
		contentPane.add(textField_Rate);
		
		JLabel lblBed = new JLabel("Bed");
		lblBed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBed.setBounds(61, 413, 118, 39);
		contentPane.add(lblBed);
		
		JComboBox City = new JComboBox();
		City.setFont(new Font("Times New Roman", Font.BOLD, 17));
		City.setModel(new DefaultComboBoxModel(new String[] {"Kolkata", "Bangalore", "Mumbai", "Chennai"}));
		City.setBounds(221, 484, 170, 39);
		contentPane.add(City);
		
		lblCity = new JLabel("City  :");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCity.setBounds(61, 484, 118, 39);
		contentPane.add(lblCity);
		
		BedNo = new JComboBox();
		BedNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BedNo.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05"}));
		BedNo.setBounds(221, 419, 46, 28);
		contentPane.add(BedNo);
		
		lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRoomType.setBounds(273, 413, 118, 39);
		contentPane.add(lblRoomType);
		
		RoomTyp = new JComboBox();
		RoomTyp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RoomTyp.setModel(new DefaultComboBoxModel(new String[] {"AC", "Non-AC"}));
		RoomTyp.setBounds(389, 419, 89, 28);
		contentPane.add(RoomTyp);
		
		btnNewButton = new JButton("Add Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_RoomNo.getText().isEmpty()==true)
				{
					JOptionPane.showMessageDialog(null, "Enter Room Number");
				}
				else if(textField_Rate.getText().isEmpty()==true)
				{
					JOptionPane.showMessageDialog(null, "Enter Rate");
					
				}
				
			else{int checked;
			checked=checkDuplicate(textField_RoomNo.getText(),"Resources/City/"+City.getSelectedItem().toString()+".txt");
			if(checked==1)
			{
				JOptionPane.showMessageDialog(null, "RoomNo already Exists...Enter Different Romno or press Update");
			}
			else
			{
				FileWriter x;
				String s=City.getSelectedItem().toString();
				String c="Resources/City/"+s+".txt";
				try {
					x=new FileWriter(c,true);
				PrintWriter g=new PrintWriter(x);
			    String d1=textField_RoomNo.getText();
			    String d2=RoomTyp.getSelectedItem().toString();
			    String d3=BedNo.getSelectedItem().toString();
			    String d4=textField_Rate.getText();
			    g.print(d1+" ");
			    g.print("0"+" ");
				g.print(d2+" ");
				g.print(d3+" ");
				g.print(d4+" ");
				
				g.println("");
				x.close();
				textField_Rate.setText(null);
				JOptionPane.showMessageDialog(null, "Room added to "+s+" Branch");
                } catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(61, 536, 129, 46);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("ADD ROOM ");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setIcon(new ImageIcon(AdminAddRoom.class.getResource("/iconImg/1486108101_User.png")));
		lblNewLabel.setBounds(0, 0, 513, 266);
		contentPane.add(lblNewLabel);
		
		lblAddRoom = new JLabel("ADD ROOM");
		lblAddRoom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblAddRoom.setBounds(261, 93, 217, 90);
		contentPane.add(lblAddRoom);
		
		btnNewButton_1 = new JButton("Show Room");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomTable(City.getSelectedItem().toString());
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(403, 492, 110, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Room");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					UpdateRoom.updateRoom("Resources/City/"+City.getSelectedItem().toString(), textField_RoomNo.getText(),RoomTyp.getSelectedItem().toString(),BedNo.getSelectedItem().toString(),textField_Rate.getText());
					JOptionPane.showMessageDialog(null, "Room Updated to "+City.getSelectedItem().toString()+" Branch");
				}
				catch(Exception e)
				{e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Can't Updated Room to "+City.getSelectedItem().toString()+" Branch");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(213, 536, 140, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnDeleteRoom = new JButton("Delete Room");
		btnDeleteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Delete1();
				try {
					int i=JOptionPane.showConfirmDialog(null,"Once Deleted Room Details Can't be recovered");
					if(i==0)
					{
					Delete1.DeleteRoom(City.getSelectedItem().toString(), textField_RoomNo.getText());
					JOptionPane.showMessageDialog(null, "Room "+textField_RoomNo.getText()+" Deleted From "+City.getSelectedItem().toString()+" Branch");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDeleteRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteRoom.setBounds(376, 536, 137, 46);
		contentPane.add(btnDeleteRoom);
	}
	
	@SuppressWarnings("unused")
	public int checkDuplicate(String RoomNo,String City)
	{
		Scanner x=null;
		try
		{
			@SuppressWarnings("resource")
			PrintWriter p=new PrintWriter(new FileWriter(City,true));
			 x=new Scanner(new File(City));
			while(x.hasNext())
			{
				String rno=x.next();
				if(rno.equals(RoomNo))
				{
					return 1;
					
				}
				else
				{
		       x.nextLine();
				}
			}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		x.close();
		return 0;
	}
	
	
	
}
