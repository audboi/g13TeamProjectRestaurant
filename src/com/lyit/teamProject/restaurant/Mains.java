package com.lyit.teamProject.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Mains {

	   private int mains_ID;
	   private String mains_Name;
	   private String mains_Description;
	   private float mains_Cost;
	   private String mains_Type;
	   
	   //sql and database variables
	   private String url = "jdbc:mysql://localhost:3306/";
	   private String dbName = "g13restaurant";
	   private String driver = "com.mysql.jdbc.Driver";
	   private String userName = "root";
	   private String password = "password";
	   private Statement statement = null;   
	   private ResultSet resultSet = null;

	   //Constructors
	   public Mains(int mainsIdIn, String mainsNameIn,String mainsDescIn, float mainsCostIn, String mainsTypeIn)   { 
		   mains_ID=mainsIdIn;
		   mains_Name=mainsNameIn;
		   mains_Description=mainsDescIn;
		   mains_Cost=mainsCostIn;
		   mains_Type = mainsTypeIn;
	     
	   }
	   public Mains()   {
	   }
	 
	   //Accessor methods   
	   public int getMainsID() {
	      return mains_ID;
	   }

	   public String getMainsName() {
	      return mains_Name;
	   }

	   public String getMainsDesc() {
	      return mains_Description;
	   }

	   public float getMainsCost() {
	      return mains_Cost;
	   }
	   
	   public String getMainsType() {
		      return mains_Type;
		   }
	 
	  
	// database access and update methods  
	       
	/// add Menu item/////////////////////////////////////////////////////////////////////////////////////// 
	   public int add(Mains mnIn)   { 
	      int status=0;
	      String sqlString="insert into g13restaurant.Mains(Mains_ID,Mains_Name,"
	      		+ "Mains_Description,Mains_Cost,Mains_Type) values('"+
	                                          mnIn.getMainsID() + "',\'" + 
	                                          mnIn.getMainsName() + "\','" +
	                                          mnIn.getMainsDesc() + "',\'"+ 
	                                          mnIn.getMainsCost()+ "',\'" +
	                                          mnIn.getMainsType()+ "\'"+ ")";
	    status = databaseUpdate(sqlString);
	    return status;
	   }

	 
	 
	/// changeItemCost/////////////////////////////////////////////////////////////////////////////// 
	   public int changePrice(int mainsIdIn, float mainsCostIn)   {
	      int status = 0;
	      String sqlString="update g13restaurant.mains set mains_ID="+mainsIdIn
	                                         + " where mains_ID="+mainsCostIn;
	      status = databaseUpdate(sqlString);                                           
	               
	      return status;
	   }

	 
	 
	 /// deleteMenuItem/////////////////////////////////////////////////////////////////////////////// 
	   public int delete(int mainsIdIn)   {
	      int status=0;  
	      String sqlString= "delete from g13restaurant.mains where mains_ID=" + mainsIdIn;     
	      status = databaseUpdate(sqlString);                                        
	      return status;
	   }

	 
	 /// getAll Dishes on Menu//////////////////////////////////////////////////////////////////////////////////////
	   public ArrayList<Mains> getAllMains()      { 
	      ArrayList<Mains> AllMains = new ArrayList<Mains>();
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.Mains");
	         
	         while ( resultSet.next() )    {
	        	 Mains nextMains = new Mains(
	        			 resultSet.getInt("mains_ID"), 
	        			 resultSet.getString("mains_Name"),
	                     resultSet.getString("mains_Description"), 
	                     resultSet.getFloat("mains_Cost"),
	                     resultSet.getString("mains_Type").toString() );                
	            AllMains.add(nextMains);
	         }
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return AllMains;     
	   }

	 
	 /// get Dish from menu Items////////////////////////////////////////////////////////////////////////////////////// 
	   public Mains getMains(int searchID)
	   {
		   Mains foundMains= new Mains();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         statement=conn.createStatement();
	         resultSet=statement.executeQuery("select * from g13restaurant.Mains where g13restaurant.Mains.mains_ID=" + searchID);
	                 
	         while ( resultSet.next() )      {
	        	 foundMains = new Mains(resultSet.getInt("mains_ID"), resultSet.getString("mains_Name"),
	                    resultSet.getString("mains_Description"), resultSet.getFloat("mains_Cost"),
	                    resultSet.getString("mains_Type").toString() );                
	         }   
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return foundMains;
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



