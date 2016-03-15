package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import com.lyit.teamProject.restaurant.Desserts;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewDessertsTable extends JFrame {
	public ViewDessertsTable() {
		
		final Scanner kbIn = new Scanner(System.in);
		final Desserts myDesserts = new Desserts();
		
		setTitle("View Dessert Items");
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		// Connect to an MySQL Database, run query, get result set
		String url = "jdbc:mysql://localhost:3306/g13restaurant";
		String userid = "root";
		String password = "password";
		String driver = "com.mysql.jdbc.Driver";              
		String sql = "SELECT * FROM g13restaurant.Desserts ORDER BY dessert_Name";   

		// Java SE 7 has try-with-resources
		// This will ensure that the sql objects are closed when the program
		// is finished with them
		try (Connection connection = DriverManager.getConnection(url, userid, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql))  // String sql points to g13restaurant.desserts
			
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
		
		JButton addDessbtn = new JButton("Add Dessert");
		addDessbtn.setBackground(new Color(255, 255, 255));
		addDessbtn.setForeground(new Color(102, 0, 0));
		addDessbtn.addActionListener(new ActionListener() {
			//public Desserts myDesserts;

			public void actionPerformed(ActionEvent e) {
				System.out.println("\n\nPlease Enter new values for the Dessert Menu ");
	               
	               System.out.print("\n\nPlease Enter Dessert ID Number:\t");
	               int nDessertID=kbIn.nextInt();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Please enter Dessert Name:\t");
	               String nDessertName=kbIn.nextLine();
	               
	               System.out.print("Enter Dessert Description:\t");
	               String nDessertDesc=kbIn.nextLine();
	               
	               System.out.print("Please enter Dessert Cost");
	               float nDessertCost = kbIn.nextFloat();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Please enter Dessert Type");
	               String nDessertType = kbIn.nextLine();
	               
	               Desserts newDesserts = new Desserts(nDessertID,nDessertName,nDessertDesc,nDessertCost,nDessertType);
	               int addStatus = myDesserts.add(newDesserts);
	               if (addStatus==1)
	                  System.out.println("New Dessert successfully added to Dessert Menu");
	               
			}
		});
		buttonPanel.add(addDessbtn);
		
		JButton remDessBtn = new JButton("Remove Dessert");
		remDessBtn.setBackground(new Color(255, 255, 255));
		remDessBtn.setForeground(new Color(102, 0, 0));
		remDessBtn.addActionListener(new ActionListener() {
			//private Desserts myDesserts;

			public void actionPerformed(ActionEvent e) {
				int delDessertID=0;
	               System.out.print("\n\nEnter the Dessert ID number you wish to delete:");
	               delDessertID=kbIn.nextInt(); 
	               int delStatus = myDesserts.delete(delDessertID);
	               if (delStatus==1)
	                  System.out.println("Dessert was successfully removed from the Menu"); 
			}
		});
		buttonPanel.add(remDessBtn);
		
		JButton chgDessPriceBtn = new JButton("Change Dessert Price");
		chgDessPriceBtn.setBackground(new Color(255, 255, 255));
		chgDessPriceBtn.setForeground(new Color(102, 0, 0));
		chgDessPriceBtn.addActionListener(new ActionListener() {
			//private Desserts myDesserts;

			public void actionPerformed(ActionEvent e) {
				int changeDessertID=0;
	               float newDessertCost=0;
	               
	               int changeStatus=0;
	               System.out.print("\n\nEnter the Dessert ID number you wish to change Price: ");
	               newDessertCost=kbIn.nextInt(); 
	               System.out.print("\n\nEnter the new Price for the Dessert: ");
	               newDessertCost=kbIn.nextFloat(); 
	               kbIn.nextLine();//clear keyboard buffer
	               changeStatus=myDesserts.changePrice(changeDessertID, newDessertCost);
	               if (changeStatus==1)
	                  System.out.println("Dessert price changed successfully");
			}
		});
		buttonPanel.add(chgDessPriceBtn);
		
		JButton addDessPicBtn = new JButton("Add Picture");
		addDessPicBtn.setBackground(new Color(255, 255, 255));
		addDessPicBtn.setForeground(new Color(102, 0, 0));
		buttonPanel.add(addDessPicBtn);
	}

	public static void main(String[] args) {
		ViewDessertsTable frame = new ViewDessertsTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
