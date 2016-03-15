package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import com.lyit.teamProject.restaurant.Desserts;
import com.lyit.teamProject.restaurant.Mains;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMainsTable extends JFrame {
	public ViewMainsTable() {
		
		final Scanner kbIn = new Scanner(System.in);
		final Mains myMains = new Mains();
		
		setTitle("View Mains Items");
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		// Connect to an MySQL Database, run query, get result set
		String url = "jdbc:mysql://localhost:3306/g13restaurant";
		String userid = "root";
		String password = "password";
		String driver = "com.mysql.jdbc.Driver";               ///////////////////////////////////////////
		String sql = "SELECT * FROM g13restaurant.Mains ORDER BY mains_Name";   // Maybe create a switch statement

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
		
		JButton addMainsBtn = new JButton("Add Mains");
		addMainsBtn.setForeground(new Color(102, 0, 0));
		addMainsBtn.setBackground(new Color(255, 255, 255));
		addMainsBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("\n\nPlease Enter new values for the Mains Menu ");
	               
	               System.out.print("\n\nPlease Enter Mains ID Number:\t");
	               int nMainsID=kbIn.nextInt();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Please enter Mains Name:\t");
	               String nMainsName=kbIn.nextLine();
	               
	               System.out.print("Enter Item Mains Description:\t");
	               String nMainsDesc=kbIn.nextLine();
	               
	               System.out.print("Please enter Mains Cost");
	               float nMainsCost = kbIn.nextFloat();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Please enter Mains Type");
	               String nMainsType = kbIn.nextLine();
	               
	               Mains newMains = new Mains(nMainsID,nMainsName,nMainsDesc,nMainsCost,nMainsType);
	               int addStatus = myMains.add(newMains);
	               if (addStatus==1)
	                  System.out.println("New Mains successfully added to Mains Menu");
			}
		});
		buttonPanel.add(addMainsBtn);
		
		JButton remMainsBtn = new JButton("Remove Mains");
		remMainsBtn.setForeground(new Color(102, 0, 0));
		remMainsBtn.setBackground(new Color(255, 255, 255));
		remMainsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delMainsID=0;
	               System.out.print("\n\nEnter the Mains ID number you wish to delete:");
	               delMainsID=kbIn.nextInt(); 
	               int delStatus = myMains.delete(delMainsID);
	               if (delStatus==1)
	                  System.out.println("Dish was successfully removed from the Menu");
			}
		});
		buttonPanel.add(remMainsBtn);
		
		JButton chgMainsPriceBtn = new JButton("Change Mains Price");
		chgMainsPriceBtn.setForeground(new Color(102, 0, 0));
		chgMainsPriceBtn.setBackground(new Color(255, 255, 255));
		chgMainsPriceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeMainsID=0;
	               float newMainsCost=0;
	               
	               int changeStatus=0;
	               System.out.print("\n\nEnter the Mains ID number you wish to change Price: ");
	               newMainsCost=kbIn.nextInt();
	               //kbIn.nextFloat();//clear keyboard buffer
	               System.out.print("\n\nEnter the new Price for the Mains: ");
	               newMainsCost=kbIn.nextFloat(); 
	               //kbIn.nextLine();//clear keyboard buffer
	               changeStatus=myMains.changePrice(changeMainsID, newMainsCost);
	               if (changeStatus==1)
	                  System.out.println("Menu Item price changed successfully");
			}
		});
		buttonPanel.add(chgMainsPriceBtn);
		
		JButton addMainsPicBtn = new JButton("Add Picture");
		addMainsPicBtn.setForeground(new Color(102, 0, 0));
		addMainsPicBtn.setBackground(new Color(255, 255, 255));
		buttonPanel.add(addMainsPicBtn);
	}

	public static void main(String[] args) {
		ViewMainsTable frame = new ViewMainsTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
