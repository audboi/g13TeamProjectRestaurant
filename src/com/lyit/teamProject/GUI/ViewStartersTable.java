package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import com.lyit.teamProject.restaurant.Mains;
import com.lyit.teamProject.restaurant.Starters;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStartersTable extends JFrame {
	public ViewStartersTable() {

		final Scanner kbIn = new Scanner(System.in);
		final Starters myStarters = new Starters();

		setTitle("View Starter Items");
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		// Connect to an MySQL Database, run query, get result set
		String url = "jdbc:mysql://localhost:3306/g13restaurant";
		String userid = "root";
		String password = "password";
		String driver = "com.mysql.jdbc.Driver";
		String sql = "SELECT * FROM g13restaurant.Starters ORDER BY starter_Name";

		///////////////////////////////////////////
		// Java SE 7 has try-with-resources
		// This will ensure that the sql objects are closed when the program
		// is finished with them
		try (Connection connection = DriverManager.getConnection(url, userid, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) // String sql points to
														// g13restaurant.bookings

		{
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.add(md.getColumnName(i));
			}

			// Get row data
			while (rs.next()) {
				ArrayList row = new ArrayList(columns);

				for (int i = 1; i <= columns; i++) {
					row.add(rs.getObject(i));
				}

				data.add(row);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Create Vectors and copy over elements from ArrayLists to them
		// Vector is deprecated but I am using them in this example to keep
		// things simple - the best practice would be to create a custom defined
		// class which inherits from the AbstractTableModel class
		Vector columnNamesVector = new Vector();
		Vector dataVector = new Vector();

		for (int i = 0; i < data.size(); i++) {
			ArrayList subArray = (ArrayList) data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++) {
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}

		for (int i = 0; i < columnNames.size(); i++)
			columnNamesVector.add(columnNames.get(i));

		// Create table with database data
		JTable table = new JTable(dataVector, columnNamesVector) {
			@Override
			public Class getColumnClass(int column) {
				for (int row = 0; row < getRowCount(); row++) {
					Object o = getValueAt(row, column);

					if (o != null) {
						return o.getClass();
					}
				}

				return Object.class;
			}
		};

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(153, 0, 0));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton addStarterBtn = new JButton("Add Starter");
		addStarterBtn.setForeground(new Color(102, 0, 0));
		addStarterBtn.setBackground(new Color(255, 255, 255));
		addStarterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n\nPlease Enter new values for the Starter Menu ");

				System.out.print("\n\nPlease Enter Starter ID Number:\t");
				int nStarterID = kbIn.nextInt();
				kbIn.nextLine(); // clear keyboard buffer

				System.out.print("Please enter Starter Name:\t");
				String nStarterName = kbIn.nextLine();

				System.out.print("Enter Item Description:\t");
				String nStarterDesc = kbIn.nextLine();

				System.out.print("Please enter Menu Item Cost");
				float nStarterCost = kbIn.nextFloat();
				kbIn.nextLine(); // clear keyboard buffer

				System.out.print("Please enter Menu Item Class");
				String nStarterType = kbIn.nextLine();

				Starters newStarters = new Starters(nStarterID, nStarterName, nStarterDesc, nStarterCost, nStarterType);
				int addStatus = myStarters.add(newStarters);
				if (addStatus == 1)
					System.out.println("New Starter successfully added to Starter Menu");
			}
		});
		buttonPanel.add(addStarterBtn);

		JButton remStarterBtn = new JButton("Remove Starter");
		remStarterBtn.setForeground(new Color(102, 0, 0));
		remStarterBtn.setBackground(new Color(255, 255, 255));
		remStarterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delStarterID = 0;
				System.out.print("\n\nEnter the Starter ID number you wish to delete:");
				delStarterID = kbIn.nextInt();
				int delStatus = myStarters.delete(delStarterID);
				if (delStatus == 1)
					System.out.println("Dish was successfully removed from the Menu");

			}
		});
		buttonPanel.add(remStarterBtn);

		JButton chgStartPriceBtn = new JButton("Change Starter Price");
		chgStartPriceBtn.setForeground(new Color(102, 0, 0));
		chgStartPriceBtn.setBackground(new Color(255, 255, 255));
		chgStartPriceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int changeStarterID = 0;
				float newStarterCost = 0;

				int changeStatus = 0;
				System.out.print("\n\nEnter the Starter ID number you wish to change Price: ");
				newStarterCost = kbIn.nextInt();
				System.out.print("\n\nEnter the new Price for the Starter: ");
				newStarterCost = kbIn.nextFloat();
				kbIn.nextLine();// clear keyboard buffer
				changeStatus = myStarters.changePrice(changeStarterID, newStarterCost);
				if (changeStatus == 1)
					System.out.println("Menu Item price changed successfully");
			}
		});
		buttonPanel.add(chgStartPriceBtn);

		JButton addStarterPic = new JButton("Add Picture");
		addStarterPic.setForeground(new Color(102, 0, 0));
		addStarterPic.setBackground(new Color(255, 255, 255));
		buttonPanel.add(addStarterPic);
	}

	public static void main(String[] args) {
		ViewStartersTable frame = new ViewStartersTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
