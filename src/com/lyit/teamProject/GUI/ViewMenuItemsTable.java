package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenuItemsTable extends JFrame {
	public ViewMenuItemsTable() {
		setTitle("View Menu Items");
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		// Connect to an MySQL Database, run query, get result set
		String url = "jdbc:mysql://localhost:3306/g13restaurant";
		String userid = "root";
		String password = "password";
		String driver = "com.mysql.jdbc.Driver";
		String sql = "SELECT * FROM g13restaurant.menu_items ORDER BY itemClass"; 

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
			@SuppressWarnings("unchecked")
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

		JButton btnNewButton = new JButton("View Starters");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStartersTable vst = new ViewStartersTable();
				vst.setBounds(100, 100, 600, 400);
				vst.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(102, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View Mains");
		btnNewButton_1.setForeground(new Color(102, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View Desserts");
		btnNewButton_2.setForeground(new Color(102, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnNewButton_2);

		JButton btnViewSideOrders = new JButton("View Side Orders");
		btnViewSideOrders.setForeground(new Color(102, 0, 0));
		btnViewSideOrders.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnViewSideOrders);
	}

	public static void main(String[] args) {
		ViewMenuItemsTable frame = new ViewMenuItemsTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}