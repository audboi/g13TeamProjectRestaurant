package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.ArrayList;


public class Customers {
	// class attributes
	private int customerID;
	private String customerName;
	private String customerSurname;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String county;
	private String country;
	private String phone;
	//private int creditCard;
	private String email;
	private String custPassword;
	private String RTcustPassword;
	private static int nextCustId = 1;

	public static int getNextCustomerId() {
		return ++nextCustId;
	}
	

	// sql and database variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "g13restaurant";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	/*String url = null;
	if (SystemProperty.environment.value() ==
	    SystemProperty.Environment.Value.Production) {
	  // Connecting from App Engine.
	  // Load the class that provides the "jdbc:google:mysql://"
	  // prefix.
	  Class.forName("com.mysql.jdbc.GoogleDriver");
	  url =
	    "jdbc:google:mysql://g13restaurant:teamproject13?user=root";
	} else {
	 // Connecting from an external network.
	  Class.forName("com.mysql.jdbc.Driver");
	  url = "jdbc:mysql://173.194.255.30:3306?user=root";
	}


	Connection conn = DriverManager.getConnection(url);
	ResultSet rs = conn.createStatement().executeQuery(
	    "SELECT 1 + 1");*/

	// Constructors
	public Customers(int custID, String custName, String custSurname, String addLine1, String addLine2,
			String cityIn, String countyIn, String countryIn,String phoneIn, String emailIn) {

		customerID = custID;
		customerName = custName;
		customerSurname = custSurname;
		addressLine1 = addLine1;
		addressLine2 = addLine2;
		city = cityIn;
		county = countyIn;
		country = countryIn;
		phone = phoneIn;
		email = emailIn;
		
		
	}

	public Customers() {

	}

	public Customers(String firstname, String lastName, String addressLine12, String addressLine22, String city2,
			String county2, String phone2, String email2, String password2, String reTypePassword) {

		customerName = firstname;
		customerSurname = lastName;
		addressLine1 = addressLine12;
		addressLine2 = addressLine22;
		city = city2;
		county = county2;
		phone = phone2;
		email = email2;
		custPassword = password2;
		RTcustPassword = reTypePassword;
	}

	// Accessor Methods
	public int getCustID() {
		return customerID;
	}

	public String getCName() {
		return customerName;
	}

	public String getCSurname() {
		return customerSurname;
	}

	public String getAddLine1() {
		return addressLine1;
	}

	public String getAddLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getCounty() {
		return county;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
	
	

	// database access and update methods

	/// add /// ///////////////////////////////////////////////////////////////////////////////////////
	public int add(Customers custIn) {
		int status = 0;
		String sqlString = "insert into g13restaurant.customers(customerid,customername,customersurname,"
				+ "addressLine1,addressLine2,city,county,country,phone,email) values"
				+ "('" + custIn.getCustID()+ "',\'" 
				+ custIn.getCName() +    "\','" 
				+ custIn.getCSurname() + "\','" 
				+ custIn.getAddLine1() + "\','"
				+ custIn.getAddLine2() + "\','" 
				+ custIn.getCity() +     "\','" 
				+ custIn.getCounty() +   "\','"
				+ custIn.getCountry() +  "\','" 
				+ custIn.getPhone() +    "\','"
				+ custIn.getEmail() +    "'" + ")";
		status = databaseUpdate(sqlString);
		return status;
	}
	
	/// delete Customer//////////////////////////////////////////////////////////////////////
	public int delete(int custID_In)   {
	      int status=0;  
	      String sqlString= "delete from g13restaurant.customers where customerid=" + custID_In;     
	      status = databaseUpdate(sqlString);                                        
	      return status;
	}
	
	/// getAllCustomers//////////////////////////////////////////////////////////////////////////////////////
	 public ArrayList<Customers> getAllCustomers() {
		 ArrayList<Customers> AllCustomers = new ArrayList<Customers>();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.customers");
	         
	         while ( resultSet.next() )      {
	        	 Customers nextCustomers = new Customers(resultSet.getInt("customerid"), resultSet.getString("customername"),
	                                   resultSet.getString("customersurname"), resultSet.getString("addressLine1"),
	                                   resultSet.getString("addressLine2"),resultSet.getString("city"),
	                                   resultSet.getString("county"),resultSet.getString("country"),
	                                   resultSet.getString("phone"),
	                                   resultSet.getString("email").toString()); 
	        	 
	        	 AllCustomers.add(nextCustomers); 
	         }   
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return AllCustomers;
	   }
	 
	/// getCustomer////////////////////////////////////////////////////////////////////////////////////// 
	 public Customers getCustomer(int searchNo)
	   {
		 Customers foundCustomer= new Customers();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.customers where g13restaurant.customers.customerID=" + searchNo);
	                 
	         while ( resultSet.next() )      {
	        	 foundCustomer = new Customers(resultSet.getInt("customerid"), resultSet.getString("customername"),
                         resultSet.getString("customersurname"), resultSet.getString("addressLine1"),
                         resultSet.getString("addressLine2"),resultSet.getString("city"),
                         resultSet.getString("county"),resultSet.getString("country"),
                         resultSet.getString("phone"),
                         resultSet.getString("email").toString());               
	         }   
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return foundCustomer;
	   }
	 
	 private int databaseUpdate(String sqlUpdate)
	   {
	      int status=0;
	   
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         status=statement.executeUpdate(sqlUpdate);
	         conn.close(); 
	      }       
	       
	      catch (Exception e) {
	         e.printStackTrace();
	      }   
	      return status;
	   }
	 
	 
	 public void getLastCustomerID() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
				statement = conn.createStatement();

				String query = "SELECT custId from customers;";
				ResultSet result = statement.executeQuery(query);

				// finds the last used id
				while (result.next()) {
					nextCustId = result.getInt(1);
				}

				conn.close();

			} catch (SQLException ex) {
				while (ex != null) {
					System.out.println("SQL Exception:  " + ex.getMessage());
					ex = ex.getNextException();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public void insertRow(Customers customer) {
		// TODO Auto-generated method stub
		
	}

	public String getCustPassword() {
		// TODO Auto-generated method stub
		return custPassword;
	}

	public Customers getCustomer(String text, String valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

}

