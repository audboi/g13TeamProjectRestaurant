package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import com.lyit.teamProject.restaurant.Desserts;
import com.lyit.teamProject.restaurant.SideOrders;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSideOrdersTable extends JFrame {
	public ViewSideOrdersTable() {
		
		final Scanner kbIn = new Scanner(System.in);
		final SideOrders mySideOrders = new SideOrders();
		
		setTitle("View Side Order Items");
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		// Connect to an MySQL Database, run query, get result set
		String url = "jdbc:mysql://localhost:3306/g13restaurant";
		String userid = "root";
		String password = "password";
		String driver = "com.mysql.jdbc.Driver";               ///////////////////////////////////////////
		String sql = "SELECT * FROM g13restaurant.sideOrders ORDER BY sides_Name";   // Maybe create a switch statement

                                                               ///////////////////////////////////////////	
		// Java SE 7 has try-with-resources
		// This will ensure that the sql objects are closed when the program
		// is finished with them
		try (Connection connection = DriverManager.getConnection(url, userid, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql))  // String sql points to g13restaurant.bookings
			
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
		
		JButton addSidesBtn = new JButton("Add Side Order");
		addSidesBtn.setForeground(new Color(102, 51, 51));
		addSidesBtn.setBackground(Color.WHITE);
		addSidesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n\nPlease Enter new values for the Sides Menu ");
	               
	               System.out.print("\n\nPlease Enter Sides ID Number:\t");
	               int nSidesID=kbIn.nextInt();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Please enter Sides Name:\t");
	               String nSidesName=kbIn.nextLine();
	               
	               System.out.print("Enter Side Order Description:\t");
	               String nSidesDesc=kbIn.nextLine();
	               
	               System.out.print("Please enter Side Order Cost");
	               float nSidesCost = kbIn.nextFloat();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Please enter Side Order Type");
	               String nSidesType = kbIn.nextLine();
	               
	               SideOrders newSideOrders = new SideOrders(nSidesID,nSidesName,nSidesDesc,nSidesCost,nSidesType);
	               int addStatus = mySideOrders.add(newSideOrders);
	               if (addStatus==1)
	                  System.out.println("New Sides successfully added to Sides Menu");
			}
		});
		buttonPanel.add(addSidesBtn);
		
		JButton remSidesBtn = new JButton("Remove Side Order");
		remSidesBtn.setForeground(new Color(102, 51, 51));
		remSidesBtn.setBackground(Color.WHITE);
		remSidesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int delSidesID=0;
	               System.out.print("\n\nEnter the Sides ID number you wish to delete:");
	               delSidesID=kbIn.nextInt(); 
	               int delStatus = mySideOrders.delete(delSidesID);
	               if (delStatus==1)
	                  System.out.println("Dish was successfully removed from the Menu"); 
			}
		});
		buttonPanel.add(remSidesBtn);
		
		JButton chgPriceBtn = new JButton("Change Side Order Price");
		chgPriceBtn.setForeground(new Color(102, 51, 51));
		chgPriceBtn.setBackground(Color.WHITE);
		chgPriceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeSidesID=0;
	               float newSidesCost=0;
	               
	               int changeStatus=0;
	               System.out.print("\n\nEnter the Sides ID number you wish to change Price: ");
	               newSidesCost=kbIn.nextInt(); 
	               System.out.print("\n\nEnter the new Price for the Sides: ");
	               newSidesCost=kbIn.nextFloat(); 
	               kbIn.nextLine();//clear keyboard buffer
	               changeStatus=mySideOrders.changePrice(changeSidesID, newSidesCost);
	               if (changeStatus==1)
	                  System.out.println("Menu Item price changed successfully");
			}
		});
		buttonPanel.add(chgPriceBtn);
		
		JButton addSidesPicBtn = new JButton("Add Picture");
		addSidesPicBtn.setForeground(new Color(102, 51, 51));
		addSidesPicBtn.setBackground(Color.WHITE);
		buttonPanel.add(addSidesPicBtn);
	}

	public static void main(String[] args) {
		ViewSideOrdersTable frame = new ViewSideOrdersTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
