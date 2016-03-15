package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.applet.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WelcomePage extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws NoPlayerException
	 */
	public WelcomePage() throws NoPlayerException, IOException {

		setResizable(false);
		setFont(new Font("Arial", Font.BOLD, 14));
		setTitle("Customer Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\staffIcon.png"));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 560);
		getContentPane().setLayout(null);
		
		File f = new File(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Audio\\interior_bar_1.wav");
		
		
		// If Manager logs in they will be taken to managers portal 
		// else if chef logs in they will be taken to the chefs portal
		// When a staff member logs in they will be taken to a page where they can 
		// view todays bookings and the days duties assigned to them
		JButton adminLoginBtn = new JButton("Login");
		adminLoginBtn.setForeground(new Color(102, 51, 0));
		adminLoginBtn.setBackground(new Color(255, 255, 255));
		adminLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLogin adminIn = new AdminLogin();
				adminIn.setVisible(true);

			}
		});
		adminLoginBtn.setBounds(873, 26, 72, 23);
		getContentPane().add(adminLoginBtn);
		
		
		// Plays audio loop when welcome frame opens up
		MediaLocator ml = new MediaLocator(f.toURL());
		Player p = (Player) Manager.createPlayer(ml);
		((javax.media.Player) p).start();

		
		// Customers will be taken to the CustomerLogin frame
		JButton btnCustLogin = new JButton("Login");
		btnCustLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin custLogin = new CustomerLogin();
				custLogin.setVisible(true);
			}
		});
		btnCustLogin.setForeground(new Color(102, 51, 0));
		btnCustLogin.setBackground(new Color(255, 255, 255));
		btnCustLogin.setBounds(873, 479, 86, 23);
		getContentPane().add(btnCustLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCustomerRegistration newComer = new NewCustomerRegistration(null, rootPaneCheckingEnabled);
				newComer.setVisible(true);
			}
		});
		btnRegister.setForeground(new Color(102, 51, 0));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setBounds(873, 441, 86, 25);
		getContentPane().add(btnRegister);

		JButton viewMenuBtn = new JButton("View Our Menu");
		viewMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustFoodView viewMenu = new CustFoodView();
				viewMenu.setVisible(true);
			}
		});
		viewMenuBtn.setForeground(new Color(102, 0, 0));
		viewMenuBtn.setBackground(new Color(255, 255, 255));
		viewMenuBtn.setBounds(24, 479, 127, 23);
		getContentPane().add(viewMenuBtn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Images\\WelcomeScreen.png"));
		lblNewLabel.setBackground(new Color(153, 0, 0));
		lblNewLabel.setBounds(4, 1, 958, 527);
		getContentPane().add(lblNewLabel);

	}

}
