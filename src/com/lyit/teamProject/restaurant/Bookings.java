package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.sql.*;
import java.util.ArrayList;

public class Bookings {
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
	public Bookings(String dateIn, int bookIdIn, int bookQtyIn, int custID_In, 
			String specReqIn,String eventTypeIn,String dietary_requirementsIn,
			String allergen_alertIn,String other_requirementsIn) {

		bookingdate = dateIn;
		bookingID = bookIdIn;
		bookingQty = bookQtyIn;
		customerID = custID_In;
		special_request = specReqIn;
		event_type = eventTypeIn;
		dietary_requirements = dietary_requirementsIn;
		allergen_alert = allergen_alertIn;
		other_requirements = other_requirementsIn;
		
		
	}

	public Bookings() {

	}

	// Accessor Methods

	public String getbookingdate() {
		return bookingdate;
	}

	public int getBookID() {
		return bookingID;
	}

	public int getBookQty() {
		return bookingQty;
	}

	public int getCustID() {
		return customerID;
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
	public int add(Bookings bookIn) {
		int status = 0;
		String sqlString = "insert into g13restaurant.reservations(bookingdate,bookingID,bookingQty,"
				+ "customerID,special_request,event_type,"
				+ "dietary_requirements,allergen_alert,other_requirements) values"
				+ "('" + bookIn.getbookingdate() + "',\'" + bookIn.getBookID() + "\','" + bookIn.getBookQty() + "\','"
				+ bookIn.getCustID() + "\','" + bookIn.getSpecReq() + "\','" + bookIn.getEvType() + "\','" + bookIn.getDietReq()+ "\','"
				+ bookIn.getAllergen() + "\','" + bookIn.getOtherReq() + "'" + ")";
		status = databaseUpdate(sqlString);
		return status;
	}

	/// Cancel Booking
	/// //////////////////////////////////////////////////////////////////////
	public int delete(int bookIn) {
		int status = 0;
		String sqlString = "delete from g13restaurant.reservations where customerid=" + getCustID();
		status = databaseUpdate(sqlString);
		return status;
	}

	/// getAllBookings//////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Bookings> getAllBookings() {
		ArrayList<Bookings> AllBookings = new ArrayList<Bookings>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * gthirteenrestaurant.reservations");

			while (resultSet.next()) {
				Bookings nextBooking = new Bookings(resultSet.getString("bookingdate"), resultSet.getInt("bookingid"),
						resultSet.getInt("bookingqty"), resultSet.getInt("customerid"),
						resultSet.getString("special_request"),resultSet.getString("event_type"),
						resultSet.getString("dietary_requirements"),resultSet.getString("allergen_alert"),
						resultSet.getString("other_requirements").toString());

				AllBookings.add(nextBooking);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AllBookings;
	}

	/// getCustomer//////////////////////////////////////////////////////////////////////////////////////
	public Bookings getBooking(int searchID) {
		Bookings foundBooking = new Bookings();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery(
					"select * from gthirteenrestaurant.Bookings where gthirteenrestaurant.reservations.bookingID="
							+ searchID);

			while (resultSet.next()) {
				foundBooking = new Bookings(resultSet.getString("bookingdate"), resultSet.getInt("bookingid"),
						resultSet.getInt("bookingqty"), resultSet.getInt("customerid"),
						resultSet.getString("special_request"),resultSet.getString("event_type"),
						resultSet.getString("dietary_requirements"),resultSet.getString("allergen_alert"),
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
		String sqlString = "update gthirteenrestaurant.reservations  set bookingqty=" + bookQtyIn + " where bookingID="
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
