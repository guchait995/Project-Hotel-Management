package BookingFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JPasswordField passwordField_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setResizable(true);
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
	public LoginPage() {
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 24));
		setTitle("Hotel Taj");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/reception/iconImg/1486107437_home_blue.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 596);
		JPanel panel_2 = new JPanel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 203, 369, 242);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	
		JRadioButton rdbtnAdminLogin = new JRadioButton("Admin LogIn");
		rdbtnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		rdbtnAdminLogin.setBounds(85, 164, 109, 23);
		contentPane.add(rdbtnAdminLogin);
		
		panel_2.setBounds(441, 203, 369, 242);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		//panel_2.setVisible(aFlag);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 14, 73, 23);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 11, 163, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserPassword = new JLabel("User Password");
		lblUserPassword.setForeground(Color.WHITE);
		lblUserPassword.setFont(new Font("Dialog", Font.BOLD, 17));
		lblUserPassword.setBounds(10, 55, 141, 23);
		panel_2.add(lblUserPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(147, 52, 163, 26);
		panel_2.add(passwordField_2);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()==true)
				{
					JOptionPane.showMessageDialog(null, "Enter UserName");
					
				}
				else if(passwordField_2.getText().isEmpty()==true)
				{
				JOptionPane.showMessageDialog(null, "Enter Password");

				}
				else
				{String pass=chkPass(textField.getText());
				if(passwordField_2 .getText().equals(pass))
				{
				new Booking(textField.getText());
			
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid USER NAME or PASSWORD");
					textField.setText(null);
					passwordField_2.setText(null);
				}
			}
			}
		});
		btnOk_1.setBounds(128, 89, 89, 23);
		panel_2.add(btnOk_1);
		panel_2.setVisible(false);
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ClientDetails p=new ClientDetails();
			p.setVisible(true);
			}
		});
		btnRegister.setBounds(128, 123, 89, 23);
		panel_2.add(btnRegister);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(LoginPage.class.getResource("/reception/hotelpics/background012.jpg")));
		lblNewLabel_3.setBounds(-66, -76, 488, 368);
		panel_2.add(lblNewLabel_3);
		
		JRadioButton rdbtnUserLogin = new JRadioButton("User LogIn");
		rdbtnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		
		rdbtnUserLogin.setBounds(517, 164, 109, 23);
		contentPane.add(rdbtnUserLogin);
		ButtonGroup rgrp=new ButtonGroup();
		rgrp.add(rdbtnAdminLogin);
		rgrp.add(rdbtnUserLogin);
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(203, 11, 156, 27);
		panel_1.add(passwordField_1);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setForeground(Color.WHITE);
		lblEnterPassword.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblEnterPassword.setBounds(10, 11, 169, 33);
		panel_1.add(lblEnterPassword);
		panel_1.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(73, 123, 190, 55);
		panel_1.add(panel);
		panel.setLayout(null);
		JButton btnNewButton = new JButton("Edit Room");
		panel.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminAddRoom h=new AdminAddRoom();
				h.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 0, 190, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Client Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientDetailsTable d=new ClientDetailsTable();
				d.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(0, 32, 190, 23);
		panel.add(btnNewButton_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				
				if(passwordField_1 .getText().equals("1234"))
				panel.setVisible(true);
				else
				{JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD!!!!!");
				passwordField_1 .setText(null);}
			}
		});
		btnOk.setBounds(109, 66, 89, 23);
		panel_1.add(btnOk);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setIcon(new ImageIcon(LoginPage.class.getResource("/reception/hotelpics/background012.jpg")));
		lblNewLabel_2.setBounds(-119, -147, 663, 492);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/reception/hotelpics/hotel-renovations12.jpg")));
		lblNewLabel_1.setBounds(0, 0, 980, 600);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}	
		
	@SuppressWarnings("resource")
	public String chkPass(String UserName)
	{	PrintWriter wr;
		Scanner x;
		String pass;
					try{
						wr=new PrintWriter(new FileWriter("Resources/Client/ClientFile.txt",true));
						wr.close();
						x=new Scanner(new File("Resources/Client/ClientFile.txt"));
					while(x.hasNext())
					{for(int j=0;j<4;j++)
					{
						x.next();
						
					}
					String User=x.next();
						if(User.equals(UserName))
						{
							for(int ni=0;ni<3;ni++)
							{
								x.next();
								
							}
							 pass=x.next();
							
							 return pass;
					
						}
						else{
						x.nextLine();
						}
					}
					x.close();
			
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		
		return "invalid";
		
	}
}
