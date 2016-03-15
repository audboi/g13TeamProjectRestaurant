package com.lyit.teamProject.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SideOrders {

	   private int sides_ID;
	   private String sides_Name;
	   private String sides_Description;
	   private float sides_Cost;
	   private String sides_Type;
	   
	   //sql and database variables
	   private String url = "jdbc:mysql://localhost:3306/";
	   private String dbName = "g13restaurant";
	   private String driver = "com.mysql.jdbc.Driver";
	   private String userName = "root";
	   private String password = "password";
	   private Statement statement = null;   
	   private ResultSet resultSet = null;

	   //Constructors
	   public SideOrders(int sidesIdIn, String sidesNameIn,String sidesDescIn, float sidesCostIn, String sidesTypeIn)   { 
		   sides_ID=sidesIdIn;
		   sides_Name=sidesNameIn;
		   sides_Description=sidesDescIn;
		   sides_Cost=sidesCostIn;
		   sides_Type = sidesTypeIn;
	     
	   }
	   public SideOrders()   {
	   }
	 
	   //Accessor methods   
	   public int getSidesID() {
	      return sides_ID;
	   }

	   public String getSidesName() {
	      return sides_Name;
	   }

	   public String getSidesDesc() {
	      return sides_Description;
	   }

	   public float getSidesCost() {
	      return sides_Cost;
	   }
	   
	   public String getSidesType() {
		      return sides_Type;
		   }
	 
	  
	// database access and update methods  
	       
	/// add Menu item/////////////////////////////////////////////////////////////////////////////////////// 
	   public int add(SideOrders sIn)   { 
	      int status=0;
	      String sqlString="insert into g13restaurant.SideOrders(sides_ID,sides_Name,"
	      		+ "sides_Description,sides_Cost,sides_Type) values('"+
	      		sIn.getSidesID() + "',\'" + 
	      		sIn.getSidesName() + "\','" +
	      		sIn.getSidesDesc() + "',\'"+ 
	      		sIn.getSidesCost()+ "',\'" +
	      		sIn.getSidesType()+ "\'"+ ")";
	    status = databaseUpdate(sqlString);
	    return status;
	   }

	 
	 
	/// changeItemCost/////////////////////////////////////////////////////////////////////////////// 
	   public int changePrice(int sidesIdIn, float sidesCostIn)   {
	      int status = 0;
	      String sqlString="update g13restaurant.SideOrders set sides_ID="+sidesIdIn
	                                         + " where sides_ID="+sidesCostIn;
	      status = databaseUpdate(sqlString);                                           
	               
	      return status;
	   }

	 
	 
	 /// deleteMenuItem/////////////////////////////////////////////////////////////////////////////// 
	   public int delete(int sidesIdIn)   {
	      int status=0;  
	      String sqlString= "delete from g13restaurant.SideOrders where sides_ID=" + sidesIdIn;     
	      status = databaseUpdate(sqlString);                                        
	      return status;
	   }

	 
	 /// getAll Dishes on Menu//////////////////////////////////////////////////////////////////////////////////////
	   public ArrayList<SideOrders> getAllSideOrders()      { 
	      ArrayList<SideOrders> AllSideOrders = new ArrayList<SideOrders>();
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.SideOrders");
	         
	         while ( resultSet.next() )    {
	        	 SideOrders nextSideOrders = new SideOrders(
	        			 resultSet.getInt("sides_ID"), 
	        			 resultSet.getString("sides_Name"),
	                     resultSet.getString("sides_Description"), 
	                     resultSet.getFloat("sides_Cost"),
	                     resultSet.getString("sides_Type").toString() );                
	            AllSideOrders.add(nextSideOrders);
	         }
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return AllSideOrders;     
	   }

	 
	 /// get Dish from menu Items////////////////////////////////////////////////////////////////////////////////////// 
	   public SideOrders getSideOrders(int searchID)
	   {
		   SideOrders foundSideOrders= new SideOrders();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.SideOrders where g13restaurant.SideOrders.sides_ID=" + searchID);
	                 
	         while ( resultSet.next() )      {
	        	 foundSideOrders = new SideOrders(resultSet.getInt("sides_ID"), resultSet.getString("sides_Name"),
	                    resultSet.getString("sides_Description"), resultSet.getFloat("sides_Cost"),
	                    resultSet.getString("sides_Type").toString() );                
	         }   
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return foundSideOrders;
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


