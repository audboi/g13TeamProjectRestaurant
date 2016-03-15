package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class ReservationComplete extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReservationComplete dialog = new ReservationComplete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReservationComplete() {
		setResizable(false);
		setTitle("Booking Successful!");
		setBounds(100, 100, 559, 182);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 618, 120);
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBackground(new Color(255, 255, 255));
			label.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Images\\BannerReservationComplete.png"));
			label.setBounds(-24, 0, 592, 52);
			contentPanel.add(label);
		}
		
		JLabel lblThankYouFor = new JLabel("Thank you for reserving a table at The G13 Restaurant, we hope you enjoy your experience! ");
		lblThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThankYouFor.setForeground(new Color(255, 153, 102));
		lblThankYouFor.setBounds(10, 47, 572, 29);
		contentPanel.add(lblThankYouFor);
		
		JLabel lblPleaseCheckYour = new JLabel("                         Please check your E-mail for confirmation details!");
		lblPleaseCheckYour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseCheckYour.setBackground(new Color(0, 0, 0));
		lblPleaseCheckYour.setForeground(new Color(255, 153, 102));
		lblPleaseCheckYour.setBounds(53, 74, 453, 14);
		contentPanel.add(lblPleaseCheckYour);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 120, 552, 33);
			buttonPane.setBackground(new Color(255, 102, 51));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton bookingOkButton = new JButton("OK");
				bookingOkButton.setForeground(new Color(255, 153, 102));
				bookingOkButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				bookingOkButton.setBackground(new Color(0, 0, 0));
				bookingOkButton.setActionCommand("OK");
				buttonPane.add(bookingOkButton);
				getRootPane().setDefaultButton(bookingOkButton);
			}
			{
				JButton bookingCancelButton = new JButton("Cancel");
				bookingCancelButton.setForeground(new Color(255, 153, 102));
				bookingCancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				bookingCancelButton.setBackground(new Color(0, 0, 0));
				bookingCancelButton.setActionCommand("Cancel");
				buttonPane.add(bookingCancelButton);
			}
		}
	}
}
