package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.sql.*;
import java.util.ArrayList;

public class MenuItems {
   //class attributes
   private int itemID;
   private String itemName;
   private String itemDescription;
   private double itemCost;
   private String itemClass;
   private String itemImage;
   
   //sql and database variables
   private String url = "jdbc:mysql://localhost:3306/";
   private String dbName = "g13restaurant";
   private String driver = "com.mysql.jdbc.Driver";
   private String userName = "root";
   private String password = "password";
   private Statement statement = null;   
   private ResultSet resultSet = null;

   //Constructors
   public MenuItems(int itemIn, String nameIn,String itemDescIn, double itemCostIn,String itemClassIn)   { 
      itemID=itemIn;
      itemName=nameIn;
      itemDescription=itemDescIn;
      itemCost=itemCostIn;
      itemClass = itemClassIn;
     
   }
   public MenuItems()   {
   }
 
   //Accessor methods   
   public int getItemID() {
      return itemID;
   }

   public String getItemName() {
      return itemName;
   }

   public String getItemDesc() {
      return itemDescription;
   }

   public double getItemCost() {
      return itemCost;
   }
   
   public String getItemClass() {
	      return itemClass;
   }
   
 
  
// database access and update methods  
       
/// add Menu item/////////////////////////////////////////////////////////////////////////////////////// 
   public int add(MenuItems msIn)   { 
      int status=0;
      String sqlString="insert into g13restaurant.menu_items(itemid,itemname,itemdescription,itemcost,itemclass) values('"+
                                          msIn.getItemID() + "',\'" + msIn.getItemName() + "\','" +
                                          msIn.getItemDesc() + "',\'"+ msIn.getItemCost()+ "\','" + 
                                          msIn.getItemClass()+ "\'"+ ")";
    status = databaseUpdate(sqlString);
    return status;
   }

 
 
/// changeItemCost/////////////////////////////////////////////////////////////////////////////// 
   public int changePrice(int itemIdIn, double itemCostIn)   {
      int status = 0;
      String sqlString="update g13restaurant.menu_items set itemID="+itemIdIn
                                         + " where itemID="+itemCostIn;
      status = databaseUpdate(sqlString);                                           
               
      return status;
   }

 
 
 /// deleteMenuItem/////////////////////////////////////////////////////////////////////////////// 
   public int delete(int itemIdIn)   {
      int status=0;  
      String sqlString= "delete from g13restaurant.menu_items where itemID=" + itemIdIn;     
      status = databaseUpdate(sqlString);                                        
      return status;
   }

 
 /// getAll Dishes on Menu//////////////////////////////////////////////////////////////////////////////////////
   public ArrayList<MenuItems> getAllDishes()      { 
      ArrayList<MenuItems> AllDishes = new ArrayList<MenuItems>();
      try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
         statement=conn.createStatement();
         resultSet=statement.executeQuery("select * from g13restaurant.menu_items");
         
         while ( resultSet.next() )    {
        	 MenuItems nextDish = new MenuItems(resultSet.getInt("itemID"), resultSet.getString("itemName"),
                                         resultSet.getString("itemDescription"), resultSet.getDouble("itemCost"),
                                         resultSet.getString("itemClass").toString() );                
            AllDishes.add(nextDish);
         }
         conn.close();
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      return AllDishes;     
   }

 
 /// get Dish from menu Items////////////////////////////////////////////////////////////////////////////////////// 
   public MenuItems getDish(int searchID)
   {
	   MenuItems foundDish= new MenuItems();
      try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
         statement=conn.createStatement();
         resultSet=statement.executeQuery("select * from g13restaurant.menu_items where g13restaurant.item_menu.itemID=" + searchID);
                 
         while ( resultSet.next() )      {
            foundDish = new MenuItems(resultSet.getInt("itemID"), resultSet.getString("itemName"),
                    resultSet.getString("itemDescription"), resultSet.getDouble("itemCost"),
                    resultSet.getString("itemClass").toString() );                
         }   
         conn.close();
      } 
      catch (Exception e) {
         e.printStackTrace();
      }  
      return foundDish;
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
