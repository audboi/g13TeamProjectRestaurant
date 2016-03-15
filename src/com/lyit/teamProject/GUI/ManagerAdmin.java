package com.lyit.teamProject.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import com.lyit.teamProject.restaurant.Employees;

public class ManagerAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAdmin frame = new ManagerAdmin();
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
	public ManagerAdmin() {
		final Scanner kbIn = new Scanner(System.in);
		final Employees myEmployees = new Employees();

		setTitle("Managers Staff Console");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblViewStaffMembers = new JLabel("View All Employees:");
		lblViewStaffMembers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblViewStaffMembers.setForeground(new Color(102, 0, 0));
		lblViewStaffMembers.setBounds(11, 37, 163, 14);
		contentPane.add(lblViewStaffMembers);

		JLabel lblChangeEmployeeDetails = new JLabel("Change Employee Details:");
		lblChangeEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChangeEmployeeDetails.setForeground(new Color(102, 0, 0));
		lblChangeEmployeeDetails.setBounds(11, 75, 163, 14);
		contentPane.add(lblChangeEmployeeDetails);

		JLabel lblNewLabel = new JLabel("Add New Employee:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setBounds(11, 110, 163, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPromoteAnEmployee = new JLabel("Promote an Employee:");
		lblPromoteAnEmployee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPromoteAnEmployee.setForeground(new Color(102, 0, 0));
		lblPromoteAnEmployee.setBounds(11, 148, 163, 14);
		contentPane.add(lblPromoteAnEmployee);

		JLabel lblChangeEmployeeRole = new JLabel("Change Employee Role:");
		lblChangeEmployeeRole.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChangeEmployeeRole.setForeground(new Color(102, 0, 0));
		lblChangeEmployeeRole.setBounds(11, 186, 163, 14);
		contentPane.add(lblChangeEmployeeRole);

		JLabel lblDelegateDuties = new JLabel("Delegate Duties:");
		lblDelegateDuties.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDelegateDuties.setForeground(new Color(102, 0, 0));
		lblDelegateDuties.setBounds(11, 224, 164, 14);
		contentPane.add(lblDelegateDuties);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Staff Administration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 11, 300, 372);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployeesTable vet = new ViewEmployeesTable();
				vet.setBounds(100, 400, 1400, 500);
				vet.setVisible(true);
			}
		});
		btnView.setBounds(179, 16, 115, 23);
		panel.add(btnView);
		btnView.setForeground(new Color(102, 0, 0));
		btnView.setBackground(new Color(255, 255, 255));

		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeEmpPasswd = 0;
				String newPasswd = "";

				int changePasswd = 0;
				System.out.print("\n\nEnter the Employee ID you wish to change Password on: ");
				changeEmpPasswd = kbIn.nextInt();
				System.out.print("\n\nPlease Enter new Password: ");
				newPasswd = kbIn.nextLine();
				changePasswd = myEmployees.changePassword(changeEmpPasswd, newPasswd);
				if (changePasswd == 1)
					System.out.println("Password successfully updated");
			}
		});
		btnChange.setBounds(179, 54, 115, 23);
		panel.add(btnChange);
		btnChange.setForeground(new Color(102, 0, 0));
		btnChange.setBackground(new Color(255, 255, 255));

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
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

				System.out.print("Enter Employee Salary:\t");
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
					System.out.println("New Employee successfully added to database");
			}
		});
		btnAdd.setBounds(179, 89, 115, 23);
		panel.add(btnAdd);
		btnAdd.setForeground(new Color(102, 0, 0));
		btnAdd.setBackground(new Color(255, 255, 255));

		JButton btnPromote = new JButton("Promote");
		btnPromote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeEmpSal = 0;
				double newSalary = 0;

				int changeSalary = 0;
				System.out.print("\n\nEnter the Employee ID you wish to Promote: ");
				changeEmpSal = kbIn.nextInt();
				System.out.print("\n\nPlease Enter new Salary: ");
				newSalary = kbIn.nextDouble();
				changeSalary = myEmployees.changeSalary(changeEmpSal, newSalary);
				if (changeSalary == 1)
					System.out.println("Salary successfully updated, and staff member promoted!");
			}
		});
		btnPromote.setBounds(179, 127, 115, 23);
		panel.add(btnPromote);
		btnPromote.setForeground(new Color(102, 0, 0));
		btnPromote.setBackground(new Color(255, 255, 255));

		JButton btnChangeRole = new JButton("Change Role");
		btnChangeRole.setBounds(179, 165, 115, 23);
		panel.add(btnChangeRole);
		btnChangeRole.setForeground(new Color(102, 0, 0));
		btnChangeRole.setBackground(new Color(255, 255, 255));

		JButton btnDuties = new JButton("Duties");
		btnDuties.setBounds(179, 203, 115, 23);
		panel.add(btnDuties);
		btnDuties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDuties.setForeground(new Color(102, 0, 0));
		btnDuties.setBackground(new Color(255, 255, 255));

		JButton btnNewButton = new JButton("CANCEL ADMIN TASK");
		btnNewButton.setBounds(10, 326, 288, 35);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(102, 0, 0));

		JLabel lblFireEmployee = new JLabel("Fire Employee:");
		lblFireEmployee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFireEmployee.setBackground(new Color(255, 255, 255));
		lblFireEmployee.setForeground(new Color(102, 0, 0));
		lblFireEmployee.setBounds(10, 250, 146, 14);
		panel.add(lblFireEmployee);

		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delEmployeeNo = 0;
				System.out.print("\n\nEnter the Employee number you wish to Fire:");
				delEmployeeNo = kbIn.nextInt();
				int delStatus = myEmployees.delete(delEmployeeNo);
				if (delStatus == 1)
					System.out.println("Employee Successfully Terminated! Don't forget the P45");
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(102, 0, 0));
		btnNewButton_1.setBounds(179, 246, 115, 23);
		panel.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
