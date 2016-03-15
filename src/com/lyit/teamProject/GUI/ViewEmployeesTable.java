package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import com.lyit.teamProject.restaurant.Employees;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEmployeesTable extends JFrame {
	public ViewEmployeesTable() {
		setForeground(new Color(204, 102, 255));
		setTitle("G13 Restaurant Customer Table");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\staffIcon.png"));
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		// Connect to an MySQL Database, run query, get result set
		String url = "jdbc:mysql://localhost:3306/g13restaurant";
		String userid = "root";
		String password = "password";
		String driver = "com.mysql.jdbc.Driver"; ///////////////////////////////////////////
		String sql = "SELECT * FROM g13restaurant.customers"; // Maybe create a
																// switch
																// statement

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

		final Scanner kbIn = new Scanner(System.in);
		final Employees myEmployees = new Employees();

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton btnNewButton_2 = new JButton("Add New Employee");
		btnNewButton_2.addActionListener(new ActionListener() {
			private Employees myEmployees;

			public void actionPerformed(ActionEvent e) {
				System.out.println("\n\nEnter the new Employee values");

				System.out.print("Enter Employee ID:\t");
				int nEmployeeID = kbIn.nextInt();
				kbIn.nextLine(); // clear keyboard buffer

				System.out.print("Enter Employee Name:\t");
				String nEmployeeName = kbIn.nextLine();
				// kbIn.nextLine();//clear keyboard buffer

				System.out.print("Enter Employee Surname:\t");
				String nEmployeeSurname = kbIn.nextLine();
				// kbIn.nextLine();//clear keyboard buffer

				System.out.print("Enter Employee Role:\t");
				String nEmpRole = kbIn.nextLine();
				// kbIn.nextLine();//clear keyboard buffer

				System.out.print("Set Employee Salary:\t");
				double nEmpSalary = kbIn.nextDouble();
				kbIn.nextLine();

				System.out.print("Enter Employee Phone Number:\t");
				String nEmpPhone = kbIn.nextLine();

				System.out.print("Enter Employee Password:\t");
				String nEmpPasswd = kbIn.nextLine();
				// kbIn.nextLine();//clear keyboard buffer

				Employees newEmployee = new Employees(nEmployeeID, nEmployeeName, nEmployeeSurname, nEmpRole,
						nEmpSalary, nEmpPhone, nEmpPasswd);
				int addStatus = myEmployees.add(newEmployee);
				if (addStatus == 1)
					System.out.println("record successfully added to database");
			}
		});
		btnNewButton_2.setForeground(new Color(102, 51, 51));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Change Employee Details");
		btnNewButton_1.setForeground(new Color(102, 51, 51));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Fire Employee");
		btnNewButton.setForeground(new Color(102, 51, 51));
		btnNewButton.setBackground(new Color(255, 255, 255));
		buttonPanel.add(btnNewButton);
	}

	public static void main(String[] args) {
		ViewEmployeesTable frame = new ViewEmployeesTable();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
