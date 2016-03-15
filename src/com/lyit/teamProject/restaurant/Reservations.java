package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.sql.*;
import java.util.ArrayList;

public class Reservations {
	// class attributes
	private String bookingdate;
	private int bookingID;
	private int bookingQty;
	private int customerID;
	private String special_request;
	private String event_type;
	private String dietary_requirements;
	private String allergen_alert;
	private String other_requirements;

	// sql and database variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "g13restaurant";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement statement = null;
	private ResultSet resultSet = null;

	// Constructors
	public Reservations(String dateIn, int bookQtyIn, 
			String eventTypeIn,String dietary_requirementsIn,
			String allergen_alertIn,String other_requirementsIn) {

		bookingdate = dateIn;
		bookingQty = bookQtyIn;
		event_type = eventTypeIn;
		dietary_requirements = dietary_requirementsIn;
		allergen_alert = allergen_alertIn;
		other_requirements = other_requirementsIn;
		
		
	}

	public Reservations() {

	}

	// Accessor Methods

	public String getbookingdate() {
		return bookingdate;
	}

	public int getBookQty() {
		return bookingQty;
	}

	public String getSpecReq() {
		return special_request;
	}
	
	public String getEvType() {
		return event_type;
	}
	
	public String getDietReq() {
		return dietary_requirements;
	}
	
	public String getAllergen() {
		return allergen_alert;
	}
	
	public String getOtherReq() {
		return other_requirements;
	}
	// database access and update methods

	/// add ///
	/// ///////////////////////////////////////////////////////////////////////////////////////
	public int add(Reservations bookIn) {
		int status = 0;
		String sqlString = "insert into g13restaurant.reservations(bookingdate,bookingQty,event_type,"
				+ "dietary_requirements,allergen_alert,other_requirements) values"
				+ "('" + bookIn.getbookingdate() + "','" + bookIn.getBookQty() + "\','" + bookIn.getEvType() + "\','" + bookIn.getDietReq()+ "\','"
				+ bookIn.getAllergen() + "\','" + bookIn.getOtherReq() + "'" + ")";
		status = databaseUpdate(sqlString);
		return status;
	}

	/// Cancel Booking
	/// //////////////////////////////////////////////////////////////////////
	public int delete(int bookIn) {
		int status = 0;
		String sqlString = "delete from g13restaurant.reservations where customerid=" + getbookingdate();
		status = databaseUpdate(sqlString);
		return status;
	}

	/// getAllBookings//////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Reservations> getAllReservations() {
		ArrayList<Reservations> AllReservations = new ArrayList<Reservations>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from g13restaurant.reservations");

			while (resultSet.next()) {
				Reservations nextReservation = new Reservations(resultSet.getString("bookingdate"), 
						resultSet.getInt("bookingqty"), 
						resultSet.getString("event_type"),
						resultSet.getString("dietary_requirements"),
						resultSet.getString("allergen_alert"),
						resultSet.getString("other_requirements").toString());

				AllReservations.add(nextReservation);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AllReservations;
	}

	/// getCustomer//////////////////////////////////////////////////////////////////////////////////////
	public Reservations getReservation(int searchID) {
		Reservations foundBooking = new Reservations();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery(
					"select * from g13restaurant.Bookings where g13restaurant.reservations.bookingID="
							+ searchID);

			while (resultSet.next()) {
				foundBooking = new Reservations(resultSet.getString("bookingdate"), 
						resultSet.getInt("bookingqty"), 
						resultSet.getString("event_type"),
						resultSet.getString("dietary_requirements"),
						resultSet.getString("allergen_alert"),
						resultSet.getString("other_requirements").toString());
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundBooking;
	}

	/// change Number of
	/// customers///////////////////////////////////////////////////////////////////////////////
	public int changeNoCustomer(int bookIdIn, int bookQtyIn) {
		int status = 0;
		String sqlString = "update g13restaurant.reservations  set bookingqty=" + bookQtyIn + " where bookingID="
				+ bookIdIn;
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
