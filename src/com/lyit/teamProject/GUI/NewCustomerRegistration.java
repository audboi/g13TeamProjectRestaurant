package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lyit.teamProject.restaurant.Customers;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class NewCustomerRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField fNameTF;
	private JTextField surnameTF;
	private JTextField address1TF;
	private JTextField address2TF;
	private JTextField cityTF;
	private JTextField countyTF;
	private JTextField phoneTF;
	private JTextField emailTF;
	private JPasswordField passwordField;
	private JPasswordField reTypePassField;
	private JLabel lblRTPassword;
	private static boolean insert;
	private Customers dbUpdater;
	private static Customers customerDB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NewCustomerRegistration frame = new NewCustomerRegistration(customerDB, insert);
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
	public NewCustomerRegistration(Customers custIn, final boolean insert) {
		customerDB = custIn;
		this.insert = insert;
		dbUpdater = new Customers();
		
		final Scanner kbIn = new Scanner(System.in);
		
		setResizable(false);
		setTitle("New Customers");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\newCustomer2.png"));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheGWelcomes = new JLabel("The G13 Welcomes You!");
		lblTheGWelcomes.setForeground(new Color(255, 255, 255));
		lblTheGWelcomes.setFont(new Font("Trajan Pro 3", Font.PLAIN, 10));
		lblTheGWelcomes.setBounds(284, 0, 157, 34);
		contentPane.add(lblTheGWelcomes);
		
		fNameTF = new JTextField();
		fNameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	               String custName=kbIn.nextLine();
			}
		});
		fNameTF.setToolTipText("First Name");
		fNameTF.setBounds(136, 8, 143, 20);
		contentPane.add(fNameTF);
		fNameTF.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setBounds(15, 10, 110, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblNewLabel = new JLabel("Surname:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(15, 34, 110, 14);
		contentPane.add(lblNewLabel);
		
		surnameTF = new JTextField();
		surnameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String custSurname=kbIn.nextLine();
			}
		});
		surnameTF.setToolTipText("Surname");
		surnameTF.setBounds(136, 31, 143, 20);
		contentPane.add(surnameTF);
		surnameTF.setColumns(10);
		
		address1TF = new JTextField();
		address1TF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addLine1 =kbIn.nextLine();
			}
		});
		address1TF.setToolTipText("First Line of Address");
		address1TF.setBounds(136, 54, 143, 20);
		contentPane.add(address1TF);
		address1TF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address Line 1:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(15, 57, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddressLine = new JLabel("Address Line 2:");
		lblAddressLine.setForeground(new Color(255, 255, 255));
		lblAddressLine.setBounds(15, 78, 110, 14);
		contentPane.add(lblAddressLine);
		
		address2TF = new JTextField();
		address2TF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addLine2 =kbIn.nextLine();
			}
		});
		address2TF.setToolTipText("Second Line of Address");
		address2TF.setColumns(10);
		address2TF.setBounds(136, 77, 143, 20);
		contentPane.add(address2TF);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setBounds(15, 102, 110, 14);
		contentPane.add(lblCity);
		
		cityTF = new JTextField();
		cityTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city =kbIn.nextLine();
			}
		});
		cityTF.setToolTipText("Your City");
		cityTF.setColumns(10);
		cityTF.setBounds(136, 100, 143, 20);
		contentPane.add(cityTF);
		
		JLabel lblNewLabel_2 = new JLabel("County:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(15, 127, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		countyTF = new JTextField();
		countyTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String countyIn =kbIn.nextLine();
			}
		});
		countyTF.setToolTipText("Your County");
		countyTF.setColumns(10);
		countyTF.setBounds(136, 123, 143, 20);
		contentPane.add(countyTF);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(15, 148, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		phoneTF = new JTextField();
		phoneTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneIn =kbIn.nextLine();
			}
		});
		phoneTF.setToolTipText("Valid Phone & Area Code");
		phoneTF.setColumns(10);
		phoneTF.setBounds(136, 146, 143, 20);
		contentPane.add(phoneTF);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(new Color(255, 255, 255));
		lblEmailAddress.setBounds(15, 171, 110, 14);
		contentPane.add(lblEmailAddress);
		
		emailTF = new JTextField();
		emailTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailIn =kbIn.nextLine();
			}
			
		});
		emailTF.setToolTipText("Valid E-Mail Address");
		emailTF.setColumns(10);
		emailTF.setBounds(136, 169, 143, 20);
		contentPane.add(emailTF);
		
		JLabel lblPassword;
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(15, 195, 110, 14);
		contentPane.add(lblPassword);
			
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password2 =kbIn.nextLine();
			}
		});
		passwordField.setToolTipText("Password must contain combination of UPPER, lower, 0-9,Special Characters");
		passwordField.setBounds(136, 192, 143, 20);
		contentPane.add(passwordField);
		
		JLabel lblRTPassword = new JLabel("Retype-Password:");
		lblRTPassword.setForeground(new Color(255, 255, 255));
		lblRTPassword.setBounds(15, 219, 110, 14);
		contentPane.add(lblRTPassword);
		
		reTypePassField = new JPasswordField();
		reTypePassField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reTypePassword =kbIn.nextLine();
			}
		});
		reTypePassField.setToolTipText("Must be the same as password");
		reTypePassField.setBounds(136, 215, 143, 20);
		contentPane.add(reTypePassField);
		
		JLabel Picture = new JLabel("");
		Picture.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\chef_icon.png"));
		Picture.setBounds(291, -19, 207, 300);
		contentPane.add(Picture);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 0));
		panel.setBounds(86, 255, 243, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton signUpBtn = new JButton("SIGN UP!");
		signUpBtn.setBounds(0, 0, 112, 30);
		panel.add(signUpBtn);
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fNameTF.getText().equals("")
						|| surnameTF.getText().equals("")
						|| address1TF.getText().equals("")
						|| address2TF.getText().equals("")
						|| cityTF.getText().equals("")
						|| countyTF.getText().equals("")
						|| phoneTF.getText().equals("")
						|| emailTF.getText().equals("")
						|| passwordField.getText().equals("")
						|| reTypePassField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Sign-Up Invalid", "Error", JOptionPane.ERROR_MESSAGE);
				else{
					if (!insert)
						addCustomerToDB();
					else
						updateCustomerDB();
					dispose();
					
				}
			}

			private void updateCustomerDB() {
				// TODO Auto-generated method stub
				
			}
		});
		signUpBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		signUpBtn.setForeground(new Color(255, 255, 255));
		signUpBtn.setBackground(new Color(102, 102, 102));
		
		JButton cancelSignBtn = new JButton("CANCEL");
		cancelSignBtn.setBounds(122, 0, 121, 30);
		panel.add(cancelSignBtn);
		cancelSignBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelSignBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		cancelSignBtn.setForeground(new Color(255, 255, 255));
		cancelSignBtn.setBackground(new Color(102, 102, 102));
	}
	
	public void addCustomerToDB() {
		
		String firstname = fNameTF.getText();
		String lastName = surnameTF.getText();
		String addressLine1 = address1TF.getText();
		String addressLine2 = address2TF.getText();
		String city = cityTF.getText();
		String county = cityTF.getText();
		String phone = phoneTF.getText();
		String email = cityTF.getText();
		String password = passwordField.getText();
		String reTypePassword = reTypePassField.getText();

		dbUpdater.getLastCustomerID();
		Customers customer = new Customers(firstname, lastName, addressLine1,
				addressLine2,city,county,phone,email,password,reTypePassword);

		dbUpdater.add(customer);
		customerDB.insertRow(customer);
	}
}
