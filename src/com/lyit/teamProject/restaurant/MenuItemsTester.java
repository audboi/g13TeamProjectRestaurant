package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;   
public class MenuItemsTester {
   public static void main(String[] args) {
      int menuOpt=0;   
      Scanner kbIn= new Scanner(System.in);
      MenuItems myMenu = new MenuItems();
       
      do  { 
         System.out.println("\t\tStarters Menu");
         System.out.println("\t1. Display all Dishes");
         System.out.println("\t2. Search and display one Dish");
         System.out.println("\t3. Add a Dish");
         System.out.println("\t4. Delete a Dish");
         System.out.println("\t5. Change Item Price");
         System.out.println("\t0. Exit the system");
         menuOpt=kbIn.nextInt();
         
         switch(menuOpt)  {
         
            case 1://display all Menu Items
             
               ArrayList<MenuItems> allmenuItems = myMenu.getAllDishes();
               System.out.println("View All Dishes");
               System.out.println("Item ID \tItem Name \tItem Description \tItem Cost \t Item Class\tItemImage");
               Iterator<MenuItems> itemIterator = allmenuItems.iterator();
               while(itemIterator.hasNext())    {
            	   MenuItems DisplayMenuItems = itemIterator.next();
                  System.out.println(DisplayMenuItems.getItemID() + " \t" +  
                		  DisplayMenuItems.getItemName() + " \t\t" +  
                		  DisplayMenuItems.getItemDesc() + " \t\t" + 
                		  DisplayMenuItems.getItemCost() + " \t\t" +
                		  DisplayMenuItems.getItemClass());
               }
            
               break;
               
            case 2:// search and display one Menu Item
               int searchMenuID=0;
               System.out.println("\n\nEnter the Menu Item ID number you wish to view");
               searchMenuID=kbIn.nextInt();      
               MenuItems searchMenuItems = myMenu.getDish(searchMenuID); 
               System.out.println(myMenu.getItemID() + " \t" +
            		   searchMenuItems.getItemName() + " \t\t" +  
            		   searchMenuItems.getItemDesc() + " \t\t" + 
            		   searchMenuItems.getItemCost() + " \t\t" +
            		   searchMenuItems.getItemClass() );
               break;
                
            case 3://add a new Starter
               System.out.println("\n\nPlease Enter new values for the Menu ");
               System.out.print("\n\nPlease Enter Menu Item ID Number:\t");
               int nItemID=kbIn.nextInt();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Item Name:\t");
               String nItemName=kbIn.nextLine();
               
               System.out.print("Enter Item Description:\t");
               String nItemDescription=kbIn.nextLine();
               System.out.print("Please enter Menu Item Cost");
               double nItemCost = kbIn.nextDouble();
               kbIn.nextLine(); // clear keyboard buffer
               System.out.print("Please enter Menu Item Class");
               String nItemClass = kbIn.nextLine();
               MenuItems newMenuItems = new MenuItems(nItemID,nItemName,nItemDescription,nItemCost,nItemClass);
               int addStatus = myMenu.add(newMenuItems);
               if (addStatus==1)
                  System.out.println("New Starter successfully added to Starter Menu");
               break;   
               
            case 4://Remove a Dish menu Item
               int delMenuID=0;
               System.out.print("\n\nEnter the Starter ID number you wish to delete:");
               delMenuID=kbIn.nextInt(); 
               int delStatus = myMenu.delete(delMenuID);
               if (delStatus==1)
                  System.out.println("Dish was successfully removed from the Menu");          
               break;
               
            case 5://change an Item Cost
               int changeMenuID=0;
               double newItemCost=0;
               
               int changeStatus=0;
               System.out.print("\n\nEnter the Menu ID number you wish to change Price: ");
               newItemCost=kbIn.nextDouble(); 
               System.out.print("\n\nEnter the new Price for Item: ");
               newItemCost=kbIn.nextDouble(); 
               kbIn.nextLine();//clear keyboard buffer
               changeStatus=myMenu.changePrice(changeMenuID, newItemCost);
               if (changeStatus==1)
                  System.out.println("Menu Item price changed successfully");
               break;
         
         }
      } while (menuOpt!=0);          
   }
}