package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerPortal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPortal frame = new ManagerPortal();
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
	public ManagerPortal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\images.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 383);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(11, 287, 588, 59);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton viewMenuBtn = new JButton("View Menu");
		viewMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuItemsTable menuTable = new ViewMenuItemsTable();
				menuTable.setBounds(600, 300, 800, 300);
				menuTable.setVisible(true);
			}
		});
		viewMenuBtn.setBounds(0, 0, 196, 30);
		panel.add(viewMenuBtn);
		viewMenuBtn.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\menu_icon1.png"));
		viewMenuBtn.setForeground(new Color(255, 255, 255));
		viewMenuBtn.setBackground(new Color(153, 0, 0));

		JButton cancelBookBtn = new JButton("Staff Administration!");
		cancelBookBtn.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\newCustomer1x1.png"));
		cancelBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerAdmin ma = new ManagerAdmin();
				ma.setVisible(true);
			}
		});
		cancelBookBtn.setBounds(392, 29, 196, 30);
		panel.add(cancelBookBtn);
		cancelBookBtn.setForeground(new Color(255, 255, 255));
		cancelBookBtn.setBackground(new Color(153, 0, 0));

		JButton viewBookBtn = new JButton("View Bookings");
		viewBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBookingsTable bookTable = new ViewBookingsTable();
				bookTable.setBounds(600, 300, 800, 300);
				bookTable.setVisible(true);
			}
		});
		viewBookBtn.setBounds(0, 29, 196, 30);
		panel.add(viewBookBtn);
		viewBookBtn.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\changeBooking.png"));
		viewBookBtn.setForeground(new Color(255, 255, 255));
		viewBookBtn.setBackground(new Color(153, 0, 0));

		JButton viewCustBtn = new JButton("View Customers");
		viewCustBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerViewCustomerTable MgrCustTable = new ManagerViewCustomerTable();
				MgrCustTable.setBounds(600, 300, 800, 300);
				MgrCustTable.setVisible(true);
			}
		});
		viewCustBtn.setBounds(196, 0, 196, 30);
		panel.add(viewCustBtn);
		viewCustBtn.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\family2.png"));
		viewCustBtn.setForeground(new Color(255, 255, 255));
		viewCustBtn.setBackground(new Color(153, 0, 0));

		JButton delCustBtn = new JButton("Delete Customer");
		delCustBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		delCustBtn.setBounds(392, 0, 196, 30);
		panel.add(delCustBtn);
		delCustBtn.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\deleteCustomer.png"));
		delCustBtn.setForeground(new Color(255, 255, 255));
		delCustBtn.setBackground(new Color(153, 0, 0));

		JButton chngBookBtn = new JButton("Change Booking");
		chngBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chngBookBtn.setBounds(196, 29, 196, 30);
		panel.add(chngBookBtn);
		chngBookBtn.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\changeBooking.png"));
		chngBookBtn.setForeground(new Color(255, 255, 255));
		chngBookBtn.setBackground(new Color(153, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Gifs\\manager.gif"));
		lblNewLabel.setBounds(5, 11, 600, 338);
		contentPane.add(lblNewLabel);
	}

}
