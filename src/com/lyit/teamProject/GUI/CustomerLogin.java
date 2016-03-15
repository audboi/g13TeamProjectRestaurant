package com.lyit.teamProject.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.lyit.teamProject.restaurant.Customers;
import com.lyit.teamProject.GUI.Reservations;

import javax.swing.AbstractButton;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Customers dbUpdater;
	private JPasswordField custPW;
	private JTextField custNameTF;
	public Customers loginCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerLogin dialog = new CustomerLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerLogin() {
		dbUpdater = new Customers();
		
		setTitle("Welcome Back! We Missed You!");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCustomerName = new JLabel("Customer Name:");
			lblCustomerName.setForeground(new Color(255, 255, 255));
			lblCustomerName.setBounds(14, 123, 99, 14);
			contentPanel.add(lblCustomerName);
		}
		{
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBounds(14, 154, 84, 14);
			contentPanel.add(lblPassword);
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(204, 51, 51));
			panel.setBackground(new Color(204, 51, 51));
			panel.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(123, 92, 205, 99);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				custPW = new JPasswordField();
				custPW.setBounds(6, 59, 166, 20);
				panel.add(custPW);
				custPW.setText("Password");
			}
			{
				custNameTF = new JTextField();
				custNameTF.setBounds(6, 28, 166, 20);
				panel.add(custNameTF);
				custNameTF.setColumns(10);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Images\\bannerBookTable.png"));
			lblNewLabel.setBounds(-96, 11, 424, 50);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 0, 0));
			buttonPane.setForeground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					AbstractButton getCName = null;
						JPasswordField getPasswd = null;
						if(!getCName.getText().equals("") || !String.valueOf(getPasswd.getPassword()).equals(""))
			            	loginCustomer = dbUpdater.getCustomer(custNameTF.getText(), String.valueOf(custPW.getPassword()));
						
						if(loginCustomer != null)
						{
							String username = loginCustomer.getCName();
							String password = loginCustomer.getCustPassword();
							
							if(loginCustomer.getCustPassword() != getPasswd())
								JOptionPane.showMessageDialog(null,  "Unauthorised", "Warning", JOptionPane.WARNING_MESSAGE);
							else
							{
								Reservations bookNow = new Reservations(loginCustomer);
								bookNow.setVisible(true);
								dispose();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Unknown user credentials entered", "Error", JOptionPane.ERROR_MESSAGE);
						}
						Reservations bookNow = new Reservations(loginCustomer);
						bookNow.setVisible(true);
						dispose();
					}

					private String getPasswd() {
						// TODO Auto-generated method stub
						return "";
					}
				});
				btnLogin.setBackground(new Color(255, 255, 255));
				btnLogin.setActionCommand("OK");
				buttonPane.add(btnLogin);
				getRootPane().setDefaultButton(btnLogin);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected Customers getCustomer(String text, String valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

}
