package com.lyit.teamProject.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Starters {

	   private int starter_ID;
	   private String starter_Name;
	   private String starter_Description;
	   private float starter_Cost;
	   private String starter_Type;
	   
	   //sql and database variables
	   private String url = "jdbc:mysql://localhost:3306/";
	   private String dbName = "g13restaurant";
	   private String driver = "com.mysql.jdbc.Driver";
	   private String userName = "root";
	   private String password = "password";
	   private Statement statement = null;   
	   private ResultSet resultSet = null;

	   //Constructors
	   public Starters(int starterIdIn, String starterNameIn,String starterDescIn, float starterCostIn, String starterTypeIn)   { 
		   starter_ID=starterIdIn;
		   starter_Name=starterNameIn;
		   starter_Description=starterDescIn;
		   starter_Cost=starterCostIn;
		   starter_Type = starterTypeIn;
	     
	   }
	   public Starters()   {
	   }
	 
	   //Accessor methods   
	   public int getStarterID() {
	      return starter_ID;
	   }

	   public String getStarterName() {
	      return starter_Name;
	   }

	   public String getStarterDesc() {
	      return starter_Description;
	   }

	   public float getStarterCost() {
	      return starter_Cost;
	   }
	   
	   public String getStarterType() {
		      return starter_Type;
		   }
	 
	  
	// database access and update methods  
	       
	/// add Starter to Database/////////////////////////////////////////////////////////////////////////////////////// 
	   public int add(Starters stIn)   { 
	      int status=0;
	      String sqlString="insert into g13restaurant.Starters(starter_ID,starter_Name,"
	      		+ "starter_Description,starter_Cost,starter_Type) values('"+
	                                          stIn.getStarterID() + "',\'" + 
	                                          stIn.getStarterName() + "\','" +
	                                          stIn.getStarterDesc() + "',\'"+ 
	                                          stIn.getStarterCost()+ "',\'" +
	                                          stIn.getStarterType()+ "\'"+ ")";
	    status = databaseUpdate(sqlString);
	    return status;
	   }

	 
	 
	/// Change Starter Cost/////////////////////////////////////////////////////////////////////////////// 
	   public int changePrice(int starterIdIn, float starterCostIn)   {
	      int status = 0;
	      String sqlString="update g13restaurant.Starters set starter_ID="+starterIdIn
	                                         + " where starter_ID="+starterCostIn;
	      status = databaseUpdate(sqlString);                                           
	               
	      return status;
	   }

	 
	 
	 /// Remove Starter from menu/////////////////////////////////////////////////////////////////////////////// 
	   public int delete(int startIdIn)   {
	      int status=0;  
	      String sqlString= "delete from g13restaurant.Starters where starter_ID=" + startIdIn;     
	      status = databaseUpdate(sqlString);                                        
	      return status;
	   }

	 
	 /// View All Starters//////////////////////////////////////////////////////////////////////////////////////
	   public ArrayList<Starters> getAllStarters()      { 
	      ArrayList<Starters> AllStarters = new ArrayList<Starters>();
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.starters");
	         
	         while ( resultSet.next() )    {
	        	 Starters nextStarter = new Starters(
	        			 resultSet.getInt("starter_ID"), 
	        			 resultSet.getString("starter_Name"),
	                     resultSet.getString("starter_Description"), 
	                     resultSet.getFloat("starter_Cost"),
	                     resultSet.getString("starter_Type").toString() );                
	            AllStarters.add(nextStarter);
	         }
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return AllStarters;     
	   }

	 
	 /// get one Starter from Menu////////////////////////////////////////////////////////////////////////////////////// 
	   public Starters getStarter(int searchID)
	   {
		   Starters foundStarter= new Starters();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.Starters where g13restaurant.Starters.starter_ID=" + searchID);
	                 
	         while ( resultSet.next() )      {
	        	 foundStarter = new Starters(resultSet.getInt("starter_ID"), resultSet.getString("starter_Name"),
	                    resultSet.getString("starter_Description"), resultSet.getFloat("starter_Cost"),
	                    resultSet.getString("starter_Type").toString() );                
	         }   
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return foundStarter;
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

