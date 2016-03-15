package com.lyit.teamProject.restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;  

public class SidesTester {
   public static void main(String[] args) {
      int menuOpt=0;   
      Scanner kbIn= new Scanner(System.in);
      SideOrders mySideOrders = new SideOrders();
       
      do  { 
         System.out.println("\t\tSideOrders Menu");
         System.out.println("\t1. Display all SideOrders");
         System.out.println("\t2. Search and display one SideOrders");
         System.out.println("\t3. Add a SideOrders");
         System.out.println("\t4. Delete a SideOrders");
         System.out.println("\t5. Change SideOrders Price");
         System.out.println("\t0. Exit the system");
         menuOpt=kbIn.nextInt();
         
         switch(menuOpt)  {
         
            case 1://display all Side Orders
             
               ArrayList<SideOrders> allSideOrders = mySideOrders.getAllSideOrders();
               System.out.println("Display All SideOrders");
               System.out.println("Sides ID \tSides Name \tSides Description \tSides Cost \tSides Type");
               Iterator<SideOrders> SidesIterator = allSideOrders.iterator();
               while(SidesIterator.hasNext())    {
            	   SideOrders displaySideOrders = SidesIterator.next();
                  System.out.println(displaySideOrders.getSidesID() + " \t" +  
                		  displaySideOrders.getSidesName() + " \t\t" +  
                		  displaySideOrders.getSidesDesc() + " \t\t" + 
                		  displaySideOrders.getSidesCost() + " \t\t" +
                		  displaySideOrders.getSidesType());
               }
            
               break;
               
            case 2:// search and display one Side Order Item
               int searchSidesID=0;
               System.out.println("\n\nEnter the Menu Item ID number you wish to view");
               searchSidesID=kbIn.nextInt();      
               SideOrders searchSideOrders = mySideOrders.getSideOrders(searchSidesID); 
               System.out.println(mySideOrders.getSidesID() + " \t" +
            		   searchSideOrders.getSidesName() + " \t\t" +  
            		   searchSideOrders.getSidesDesc() + " \t\t" + 
            		   searchSideOrders.getSidesCost() + " \t\t" +
            		   searchSideOrders.getSidesType() );
               break;
                
            case 3://add a new Side Order
               System.out.println("\n\nPlease Enter new values for the Sides Menu ");
               
               System.out.print("\n\nPlease Enter Sides ID Number:\t");
               int nSidesID=kbIn.nextInt();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Sides Name:\t");
               String nSidesName=kbIn.nextLine();
               
               System.out.print("Enter Side Order Description:\t");
               String nSidesDesc=kbIn.nextLine();
               
               System.out.print("Please enter Side Order Cost");
               float nSidesCost = kbIn.nextFloat();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Side Order Type");
               String nSidesType = kbIn.nextLine();
               
               SideOrders newSideOrders = new SideOrders(nSidesID,nSidesName,nSidesDesc,nSidesCost,nSidesType);
               int addStatus = mySideOrders.add(newSideOrders);
               if (addStatus==1)
                  System.out.println("New Sides successfully added to Sides Menu");
               break;   
               
            case 4://Remove a Side Order Item
               int delSidesID=0;
               System.out.print("\n\nEnter the Sides ID number you wish to delete:");
               delSidesID=kbIn.nextInt(); 
               int delStatus = mySideOrders.delete(delSidesID);
               if (delStatus==1)
                  System.out.println("Dish was successfully removed from the Menu");          
               break;
               
            case 5://change a Side Order Cost
               int changeSidesID=0;
               float newSidesCost=0;
               
               int changeStatus=0;
               System.out.print("\n\nEnter the Sides ID number you wish to change Price: ");
               newSidesCost=kbIn.nextInt(); 
               System.out.print("\n\nEnter the new Price for the Sides: ");
               newSidesCost=kbIn.nextFloat(); 
               kbIn.nextLine();//clear keyboard buffer
               changeStatus=mySideOrders.changePrice(changeSidesID, newSidesCost);
               if (changeStatus==1)
                  System.out.println("Menu Item price changed successfully");
               break;
         
         }
      } while (menuOpt!=0);          
   }
}
