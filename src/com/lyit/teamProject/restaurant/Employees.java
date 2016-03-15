package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.sql.*;
import java.util.ArrayList;

public class Employees {

	private int employeeID;
	private String employeeName;
	private String employeeSurname;
	private String empRole;
	private double empSalary;
	private String employeePhone;
	private String empPasswd;
	// Needs to be an int but keep getting error at line 125 & 153 so changed to
	// a string (db dont like)

	// sql and database variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "g13restaurant";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement statement = null;
	private ResultSet resultSet = null;

	// Constructors
	public Employees(int empID, String empName, String empSName, String empRoleIN, double empSalaryIn,
			String empPhoneIn, String empPasswdIN) {

		employeeID = empID;
		employeeName = empName;
		employeeSurname = empSName;
		empRole = empRoleIN;
		empSalary = empSalaryIn;
		empPasswd = empPasswdIN;
		employeePhone = empPhoneIn;

	}

	public Employees() {

	}

	// Accessors
	public int getEmpID() {
		return employeeID;
	}

	public String getEmpName() {
		return employeeName;
	}

	public String getEmpSName() {
		return employeeSurname;
	}

	public String getEmpRole() {
		return empRole;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public String getEmpPhone() {
		return employeePhone;
	}

	public String getEmpPasswd() {
		return empPasswd;
	}

	// database access and update methods

	/// add ///
	/// ///////////////////////////////////////////////////////////////////////////////////////
	public int add(Employees empIn) {
		int status = 0;
		String sqlString = "insert into g13restaurant.employees(employeeid,employeename,employeesurname,employeerole,empSalary,empPhone,employeepassword)values"
				+ "('" + empIn.getEmpID() + "',\'" + empIn.getEmpName() + "\','" + empIn.getEmpSName() + "\','"
				+ empIn.getEmpRole() + "\','" + empIn.getEmpPhone() + "\','" + empIn.getEmpSalary() + "\','"
				+ empIn.getEmpPasswd() + "\'" + ")";
		status = databaseUpdate(sqlString);
		return status;
	}

	/// Fire
	/// Employee///////////////////////////////////////////////////////////////////////////////////
	public int delete(int empID_In) {
		int status = 0;
		String sqlString = "delete from g13restaurant.employees where employeeID =" + empID_In;
		status = databaseUpdate(sqlString);
		return status;
	}

	/// getAllEmployees//////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Employees> getAllEmployees() {
		ArrayList<Employees> AllEmployees = new ArrayList<Employees>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from g13restaurant.employees");

			while (resultSet.next()) {
				Employees nextEmployees = new Employees(resultSet.getInt("employeeid"),
						resultSet.getString("employeename"), resultSet.getString("employeesurname"),
						resultSet.getString("empRole"), resultSet.getDouble("empSalary"),
						resultSet.getString("empPhone"), resultSet.getString("emppasswd").toString());

				AllEmployees.add(nextEmployees);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AllEmployees;

	}

	/// getEmployee//////////////////////////////////////////////////////////////////////////////////////
	public Employees getEmployees(int searchNo) {
		Employees foundEmployee = new Employees();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery(
					"select * from g13restaurant.employees where g13restaurant.employees.employeeID=" + searchNo);

			while (resultSet.next()) {
				foundEmployee = new Employees(resultSet.getInt("employeeid"), resultSet.getString("employeename"),
						resultSet.getString("employeesurname"), resultSet.getString("empRole"),
						resultSet.getDouble("empSalary"), resultSet.getString("empPhone"),
						resultSet.getString("emppasswd").toString());
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundEmployee;
	}

	/// changeEmployee
	/// Password///////////////////////////////////////////////////////////////////////////////
	public int changePassword(int empIdIn, String passwdIn) {
		int status = 0;
		String sqlString = "update g13restaurant.employees set employeepassword=" + passwdIn + " where employeeID="
				+ empIdIn;
		status = databaseUpdate(sqlString);

		return status;
	}

	/// changeEmployee Phone
	/// Number///////////////////////////////////////////////////////////////////////////////
	public int changePhone(int empIdIn, String phoneIn) {
		int status = 0;
		String sqlString = "update g13restaurant.employees set empPhone=" + phoneIn + " where employeeID=" + empIdIn;
		status = databaseUpdate(sqlString);

		return status;
	}

	/// Promote Employee & change
	/// Salary//////////////////////////////////////////////////////////////////////////////
	public int changeSalary(int empIdIn, double empSalaryIn) {
		int status = 0;
		String sqlString = "update g13restaurant.employees set empSalary=" + empSalaryIn + " where employeeID="
				+ empIdIn;
		status = databaseUpdate(sqlString);

		return status;
	}

	private int databaseUpdate(String sqlUpdate) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			status = statement.executeUpdate(sqlUpdate);
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
