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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.lyit.teamProject.restaurant.Mains;
import com.lyit.teamProject.restaurant.Starters;

import java.awt.Component;
import javax.swing.SwingConstants;

public class ChefPortal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefPortal frame = new ChefPortal();
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
	public ChefPortal() {
		final Scanner kbIn = new Scanner(System.in);
		final Starters myStarters = new Starters();
		final Mains myMains = new Mains();

		setResizable(false);
		setTitle("Chef's Admin Portal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\chef.png"));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 384);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("View Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMenuItemsTable vmit = new ViewMenuItemsTable();
				vmit.setBounds(600, 300, 800, 300);
				vmit.setVisible(true);

			}
		});
		button.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\menu_icon1.png"));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(153, 0, 0));
		button.setBounds(9, 287, 196, 30);
		contentPane.add(button);

		JButton btnViewBookings = new JButton("View Bookings");
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBookingsTable viewBooks = new ViewBookingsTable();
				viewBooks.setBounds(600, 300, 800, 300);
				viewBooks.setVisible(true);
			}
		});
		btnViewBookings.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\changeBooking1.png"));
		btnViewBookings.setForeground(new Color(255, 255, 255));
		btnViewBookings.setBackground(new Color(153, 0, 0));
		btnViewBookings.setBounds(205, 287, 196, 30);
		contentPane.add(btnViewBookings);

		JButton btnDelete = new JButton("Add Special");
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\menuIcon.png"));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(153, 0, 0));
		btnDelete.setBounds(401, 316, 196, 30);
		contentPane.add(btnDelete);

		JButton btnChangeStarter = new JButton("Add Dessert");
		btnChangeStarter.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\dessert1.png"));
		btnChangeStarter.setForeground(new Color(255, 255, 255));
		btnChangeStarter.setBackground(new Color(153, 0, 0));
		btnChangeStarter.setBounds(205, 316, 196, 30);
		contentPane.add(btnChangeStarter);

		JButton btnAddMains = new JButton("Add Mains");
		btnAddMains.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n\nPlease Enter new values for the Mains Menu ");

				System.out.print("\n\nPlease Enter Mains ID Number:\t");
				int nMainsID = kbIn.nextInt();
				kbIn.nextLine(); // clear keyboard buffer

				System.out.print("Please enter Mains Name:\t");
				String nMainsName = kbIn.nextLine();

				System.out.print("Enter Mains Description:\t");
				String nMainsDesc = kbIn.nextLine();

				System.out.print("Please enter Mains Cost");
				float nMainsCost = kbIn.nextFloat();
				kbIn.nextLine(); // clear keyboard buffer

				System.out.print("Please enter Mains Type");
				String nMainsType = kbIn.nextLine();

				Mains newMains = new Mains(nMainsID, nMainsName, nMainsDesc, nMainsCost, nMainsType);
				int addStatus = myMains.add(newMains);
				if (addStatus == 1)
					System.out.println("New Mains successfully added to Mains Menu");
			}
		});
		btnAddMains.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\mains1.png"));
		btnAddMains.setForeground(new Color(255, 255, 255));
		btnAddMains.setBackground(new Color(153, 0, 0));
		btnAddMains.setBounds(9, 316, 196, 30);
		contentPane.add(btnAddMains);

		JButton btnNewButton = new JButton("View Today's Bookings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTodaysBookings vtb1 = new ViewTodaysBookings();
				vtb1.setBounds(100, 100, 900, 400);
				vtb1.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setBounds(401, 287, 196, 30);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Gifs\\slicingGarlic.gif"));
		label.setBounds(4, 0, 598, 361);
		contentPane.add(label);
	}
}
