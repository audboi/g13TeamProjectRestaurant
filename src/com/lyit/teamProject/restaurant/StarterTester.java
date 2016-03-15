package com.lyit.teamProject.restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;  

public class StarterTester {
   public static void main(String[] args) {
      int menuOpt=0;   
      Scanner kbIn= new Scanner(System.in);
      Starters myStarters = new Starters();
       
      do  { 
         System.out.println("\t\tStarters Menu");
         System.out.println("\t1. Display all Starters");
         System.out.println("\t2. Search and display one Starter");
         System.out.println("\t3. Add a Starter");
         System.out.println("\t4. Delete a Starter");
         System.out.println("\t5. Change Starter Price");
         System.out.println("\t0. Exit the system");
         menuOpt=kbIn.nextInt();
         
         switch(menuOpt)  {
         
            case 1://display all Starter Items
             
               ArrayList<Starters> allStarters = myStarters.getAllStarters();
               System.out.println("Display All Starters");
               System.out.println("Starter ID \tStarter Name \tStarter Description \tStarter Cost \tStarter Type");
               Iterator<Starters> starterIterator = allStarters.iterator();
               while(starterIterator.hasNext())    {
            	   Starters displayStarters = starterIterator.next();
                  System.out.println(displayStarters.getStarterID() + " \t" +  
                		  displayStarters.getStarterName() + " \t\t" +  
                		  displayStarters.getStarterDesc() + " \t\t" + 
                		  displayStarters.getStarterCost() + " \t\t" +
                		  displayStarters.getStarterType());
               }
            
               break;
               
            case 2:// Search and display one Starter Item
               int searchStarterID=0;
               System.out.println("\n\nEnter the Menu Item ID number you wish to view");
               searchStarterID=kbIn.nextInt();      
               Starters searchStarters = myStarters.getStarter(searchStarterID); 
               System.out.println(myStarters.getStarterID() + " \t" +
            		   searchStarters.getStarterName() + " \t\t" +  
            		   searchStarters.getStarterDesc() + " \t\t" + 
            		   searchStarters.getStarterCost() + " \t\t" +
            		   searchStarters.getStarterType() );
               break;
                
            case 3://Add a new Starter
               System.out.println("\n\nPlease Enter new values for the Starter Menu ");
               
               System.out.print("\n\nPlease Enter Starter ID Number:\t");
               int nStarterID=kbIn.nextInt();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Starter Name:\t");
               String nStarterName=kbIn.nextLine();
               
               System.out.print("Enter Item Description:\t");
               String nStarterDesc=kbIn.nextLine();
               
               System.out.print("Please enter Menu Item Cost");
               float nStarterCost = kbIn.nextFloat();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Menu Item Class");
               String nStarterType = kbIn.nextLine();
               
               Starters newStarters = new Starters(nStarterID,nStarterName,nStarterDesc,nStarterCost,nStarterType);
               int addStatus = myStarters.add(newStarters);
               if (addStatus==1)
                  System.out.println("New Starter successfully added to Starter Menu");
               break;   
               
            case 4://Remove a Starter Item
               int delStarterID=0;
               System.out.print("\n\nEnter the Starter ID number you wish to delete:");
               delStarterID=kbIn.nextInt(); 
               int delStatus = myStarters.delete(delStarterID);
               if (delStatus==1)
                  System.out.println("Dish was successfully removed from the Menu");          
               break;
               
            case 5://Change a Starter Cost
               int changeStarterID=0;
               float newStarterCost=0;
               
               int changeStatus=0;
               System.out.print("\n\nEnter the Starter ID number you wish to change Price: ");
               newStarterCost=kbIn.nextInt(); 
               System.out.print("\n\nEnter the new Price for the Starter: ");
               newStarterCost=kbIn.nextFloat(); 
               kbIn.nextLine();//clear keyboard buffer
               changeStatus=myStarters.changePrice(changeStarterID, newStarterCost);
               if (changeStatus==1)
                  System.out.println("Menu Item price changed successfully");
               break;
         
         }
      } while (menuOpt!=0);          
   }
}