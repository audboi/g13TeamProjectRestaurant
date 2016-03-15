package com.lyit.teamProject.restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;  

public class DessertTester {
   public static void main(String[] args) {
      int menuOpt=0;   
      Scanner kbIn= new Scanner(System.in);
      Desserts myDesserts = new Desserts();
       
      do  { 
         System.out.println("\t\tDesserts Menu");
         System.out.println("\t1. Display all Desserts");
         System.out.println("\t2. Search and display one Dessert");
         System.out.println("\t3. Add a Dessert");
         System.out.println("\t4. Delete a Dessert");
         System.out.println("\t5. Change Dessert Price");
         System.out.println("\t0. Exit the system");
         menuOpt=kbIn.nextInt();
         
         switch(menuOpt)  {
         
            case 1://display all Dessert Items
             
               ArrayList<Desserts> allDesserts = myDesserts.getAllDesserts();
               System.out.println("Display All Desserts");
               System.out.println("Dessert ID \tDessert Name \tDessert Description \tDessert Cost \tDessert Type");
               Iterator<Desserts> DessertIterator = allDesserts.iterator();
               while(DessertIterator.hasNext())    {
            	   Desserts displayDesserts = DessertIterator.next();
                  System.out.println(displayDesserts.getDessertID() + " \t" +  
                		  displayDesserts.getDessertName() + " \t\t" +  
                		  displayDesserts.getDessertDesc() + " \t\t" + 
                		  displayDesserts.getDessertCost() + " \t\t" +
                		  displayDesserts.getDessertType());
               }
            
               break;
               
            case 2:// search and display one Dessert Item
               int searchDessertID=0;
               System.out.println("\n\nEnter the Menu Item ID number you wish to view");
               searchDessertID=kbIn.nextInt();      
               Desserts searchDesserts = myDesserts.getDesserts(searchDessertID); 
               System.out.println(myDesserts.getDessertID() + " \t" +
            		   searchDesserts.getDessertName() + " \t\t" +  
            		   searchDesserts.getDessertDesc() + " \t\t" + 
            		   searchDesserts.getDessertCost() + " \t\t" +
            		   searchDesserts.getDessertType() );
               break;
                
            case 3://add a new Dessert Item
               System.out.println("\n\nPlease Enter new values for the Dessert Menu ");
               
               System.out.print("\n\nPlease Enter Dessert ID Number:\t");
               int nDessertID=kbIn.nextInt();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Dessert Name:\t");
               String nDessertName=kbIn.nextLine();
               
               System.out.print("Enter Dessert Description:\t");
               String nDessertDesc=kbIn.nextLine();
               
               System.out.print("Please enter Dessert Cost");
               float nDessertCost = kbIn.nextFloat();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Dessert Type");
               String nDessertType = kbIn.nextLine();
               
               Desserts newDesserts = new Desserts(nDessertID,nDessertName,nDessertDesc,nDessertCost,nDessertType);
               int addStatus = myDesserts.add(newDesserts);
               if (addStatus==1)
                  System.out.println("New Dessert successfully added to Dessert Menu");
               break;   
               
            case 4://Remove a Dessert Item
               int delDessertID=0;
               System.out.print("\n\nEnter the Dessert ID number you wish to delete:");
               delDessertID=kbIn.nextInt(); 
               int delStatus = myDesserts.delete(delDessertID);
               if (delStatus==1)
                  System.out.println("Dessert was successfully removed from the Menu");          
               break;
               
            case 5://Change a Dessert Item Cost
               int changeDessertID=0;
               float newDessertCost=0;
               
               int changeStatus=0;
               System.out.print("\n\nEnter the Dessert ID number you wish to change Price: ");
               newDessertCost=kbIn.nextInt(); 
               System.out.print("\n\nEnter the new Price for the Dessert: ");
               newDessertCost=kbIn.nextFloat(); 
               kbIn.nextLine();//clear keyboard buffer
               changeStatus=myDesserts.changePrice(changeDessertID, newDessertCost);
               if (changeStatus==1)
                  System.out.println("Dessert price changed successfully");
               break;
         
         }
      } while (menuOpt!=0);          
   }
}