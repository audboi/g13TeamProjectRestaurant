package com.lyit.teamProject.restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;  

public class MainsTester {
   public static void main(String[] args) {
      int menuOpt=0;   
      Scanner kbIn= new Scanner(System.in);
      Mains myMains = new Mains();
       
      do  { 
         System.out.println("\t\tMains Menu");
         System.out.println("\t1. Display all Mains");
         System.out.println("\t2. Search and display one Mains");
         System.out.println("\t3. Add a Mains");
         System.out.println("\t4. Delete a Mains");
         System.out.println("\t5. Change Mains Price");
         System.out.println("\t0. Exit the system");
         menuOpt=kbIn.nextInt();
         
         switch(menuOpt)  {
         
            case 1://Display all Mains Items
             
               ArrayList<Mains> allMains = myMains.getAllMains();
               System.out.println("Display All Mains");
               System.out.println("Mains ID \tMains Name \tMains Description \tMains Cost \tMains Type");
               Iterator<Mains> MainsIterator = allMains.iterator();
               while(MainsIterator.hasNext())    {
            	   Mains displayMains = MainsIterator.next();
                  System.out.println(displayMains.getMainsID() + " \t" +  
                		  displayMains.getMainsName() + " \t\t" +  
                		  displayMains.getMainsDesc() + " \t\t" + 
                		  displayMains.getMainsCost() + " \t\t" +
                		  displayMains.getMainsType());
               }
            
               break;
               
            case 2:// search and display one Mains Item
               int searchMainsID=0;
               System.out.println("\n\nEnter the Mains ID number you wish to view");
               searchMainsID=kbIn.nextInt();      
               Mains searchMains = myMains.getMains(searchMainsID); 
               System.out.println(myMains.getMainsID() + " \t" +
            		   searchMains.getMainsName() + " \t\t" +  
            		   searchMains.getMainsDesc() + " \t\t" + 
            		   searchMains.getMainsCost() + " \t\t" +
            		   searchMains.getMainsType() );
               break;
                
            case 3://Add a new Mains
               System.out.println("\n\nPlease Enter new values for the Mains Menu ");
               
               System.out.print("\n\nPlease Enter Mains ID Number:\t");
               int nMainsID=kbIn.nextInt();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Mains Name:\t");
               String nMainsName=kbIn.nextLine();
               
               System.out.print("Enter Item Mains Description:\t");
               String nMainsDesc=kbIn.nextLine();
               
               System.out.print("Please enter Mains Cost");
               float nMainsCost = kbIn.nextFloat();
               kbIn.nextLine(); // clear keyboard buffer
               
               System.out.print("Please enter Mains Type");
               String nMainsType = kbIn.nextLine();
               
               Mains newMains = new Mains(nMainsID,nMainsName,nMainsDesc,nMainsCost,nMainsType);
               int addStatus = myMains.add(newMains);
               if (addStatus==1)
                  System.out.println("New Mains successfully added to Mains Menu");
               break;   
               
            case 4://Remove a Mains Item
               int delMainsID=0;
               System.out.print("\n\nEnter the Mains ID number you wish to delete:");
               delMainsID=kbIn.nextInt(); 
               int delStatus = myMains.delete(delMainsID);
               if (delStatus==1)
                  System.out.println("Dish was successfully removed from the Menu");          
               break;
               
            case 5://change a Mains Cost
               int changeMainsID=0;
               float newMainsCost=0;
               
               int changeStatus=0;
               System.out.print("\n\nEnter the Mains ID number you wish to change Price: ");
               newMainsCost=kbIn.nextInt(); 
               System.out.print("\n\nEnter the new Price for the Mains: ");
               newMainsCost=kbIn.nextFloat(); 
               kbIn.nextLine();//clear keyboard buffer
               changeStatus=myMains.changePrice(changeMainsID, newMainsCost);
               if (changeStatus==1)
                  System.out.println("Menu Item price changed successfully");
               break;
         
         }
      } while (menuOpt!=0);          
   }
}