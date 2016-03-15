package com.lyit.teamProject.restaurant;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Desserts {

	   private int dessert_ID;
	   private String dessert_Name;
	   private String dessert_Description;
	   private float dessert_Cost;
	   private String dessert_Type;
	   
	   //sql and database variables
	   private String url = "jdbc:mysql://localhost:3306/";
	   private String dbName = "g13restaurant";
	   private String driver = "com.mysql.jdbc.Driver";
	   private String userName = "root";
	   private String password = "password";
	   private Statement statement = null;   
	   private ResultSet resultSet = null;

	   //Constructors
	   public Desserts(int dessertIdIn, String dessertNameIn,String dessertDescIn, float dessertCostIn, String dessertTypeIn)   { 
		   dessert_ID=dessertIdIn;
		   dessert_Name=dessertNameIn;
		   dessert_Description=dessertDescIn;
		   dessert_Cost=dessertCostIn;
		   dessert_Type = dessertTypeIn;
	     
	   }
	   public Desserts()   {
	   }
	 
	   //Accessor methods   
	   public int getDessertID() {
	      return dessert_ID;
	   }

	   public String getDessertName() {
	      return dessert_Name;
	   }

	   public String getDessertDesc() {
	      return dessert_Description;
	   }

	   public float getDessertCost() {
	      return dessert_Cost;
	   }
	   
	   public String getDessertType() {
		      return dessert_Type;
		   }
	 
	  
	// database access and update methods  
	       
	/// add Menu item/////////////////////////////////////////////////////////////////////////////////////// 
	   public int add(Desserts dtIn)   { 
	      int status=0;
	      String sqlString="insert into g13restaurant.Desserts(dessert_ID,dessert_Name,"
	      		+ "dessert_Description,dessert_Cost,dessert_Type) values('"+
	      		dtIn.getDessertID() + "',\'" + 
	      		dtIn.getDessertName() + "\','" +
	      		dtIn.getDessertDesc() + "',\'"+ 
	      		dtIn.getDessertCost()+ "',\'" +
	      		dtIn.getDessertType()+ "\'"+ ")";
	    status = databaseUpdate(sqlString);
	    return status;
	   }

	 
	 
	/// changeItemCost/////////////////////////////////////////////////////////////////////////////// 
	   public int changePrice(int dessertIdIn, float dessertCostIn)   {
	      int status = 0;
	      String sqlString="update g13restaurant.Desserts set dessert_ID="+dessertIdIn
	                                         + " where dessert_ID="+dessertCostIn;
	      status = databaseUpdate(sqlString);                                           
	               
	      return status;
	   }

	 
	 
	 /// deleteMenuItem/////////////////////////////////////////////////////////////////////////////// 
	   public int delete(int dessertIdIn)   {
	      int status=0;  
	      String sqlString= "delete from g13restaurant.desserts where dessert_ID=" + dessertIdIn;     
	      status = databaseUpdate(sqlString);                                        
	      return status;
	   }

	 
	 /// getAll Dishes on Menu//////////////////////////////////////////////////////////////////////////////////////
	   public ArrayList<Desserts> getAllDesserts()      { 
	      ArrayList<Desserts> AllDesserts = new ArrayList<Desserts>();
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.Desserts");
	         
	         while ( resultSet.next() )    {
	        	 Desserts nextDesserts = new Desserts(
	        			 resultSet.getInt("dessert_ID"), 
	        			 resultSet.getString("dessert_Name"),
	                     resultSet.getString("dessert_Description"), 
	                     resultSet.getFloat("dessert_Cost"),
	                     resultSet.getString("dessert_Type").toString() );                
	            AllDesserts.add(nextDesserts);
	         }
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return AllDesserts;     
	   }

	 
	 /// get Dish from menu Items////////////////////////////////////////////////////////////////////////////////////// 
	   public Desserts getDesserts(int searchID)
	   {
		   Desserts foundDesserts= new Desserts();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.desserts where g13restaurant.desserts.dessert_ID=" + searchID);
	                 
	         while ( resultSet.next() )      {
	        	 foundDesserts = new Desserts(resultSet.getInt("dessert_ID"), resultSet.getString("dessert_Name"),
	                    resultSet.getString("dessert_Description"), resultSet.getFloat("dessert_Cost"),
	                    resultSet.getString("dessert_Type").toString() );                
	         }   
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return foundDesserts;
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
	}



