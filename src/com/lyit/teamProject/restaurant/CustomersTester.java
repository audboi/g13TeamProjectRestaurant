package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.util.*;
import java.util.Iterator;
public class CustomersTester {

	public static void main(String[] args) {
		int menuOpt=0;
		Scanner kbIn = new Scanner(System.in);
		Customers myCustomers = new Customers();
		
		do{
			System.out.println("\t\tCustomer Menu\n");
			System.out.println("\t1. Display all Customers");
			System.out.println("\t2. Search & display one Customer");
			System.out.println("\t3. Add Customer");
			System.out.println("\t4. Delete Customer");
			System.out.println("\t0. Exit");
			menuOpt=kbIn.nextInt();
			
			switch(menuOpt) {
			
			case 1:// display customers
				
				ArrayList<Customers> allCustomers = myCustomers.getAllCustomers();
	               System.out.println("View All Customers");
	               System.out.println("Customer ID\tCustomer name \tCustomer Surname\tAddress Line 1\t\tAddress Line2\t\tCity\t\tCounty\t\tCountry\t\tPhone\t\tEmail\n\n\n");
	               Iterator<Customers> customerIterator = allCustomers.iterator();
	               while(customerIterator.hasNext())    {
	                  Customers DisplayCustomers = customerIterator.next();
	                  System.out.println(DisplayCustomers.getCustID() + "\t\t" + 
	                		  DisplayCustomers.getCName() + "\t\t" + 
	                		  DisplayCustomers.getCSurname() + "\t\t" +  
	                		  DisplayCustomers.getAddLine1() + "\t\t" + 
	                		  DisplayCustomers.getAddLine2() + "\t\t" + 
	                		  DisplayCustomers.getCity() + "\t" + 
	                		  DisplayCustomers.getCounty() + "\t\t" + 
	                		  DisplayCustomers.getCountry() + "\t\t" + 
	                		  DisplayCustomers.getPhone() + "\t" + 
	                		  DisplayCustomers.getEmail()+  "\n");
	               }
	            
	               break;
	               
			case 2:// search and display one Customer
				
	               int searchCustomerNo=0;
	               System.out.println("\n\nEnter the Customer number you wish to view");
	               searchCustomerNo=kbIn.nextInt();      
	               Customers SearchCustomer = myCustomers.getCustomer(searchCustomerNo);
	               System.out.println(SearchCustomer.getCustID() + " \t" + 
	            		   SearchCustomer.getCName() + " \t" + 
	            		   SearchCustomer.getCSurname() + " \t" +  
	            		   SearchCustomer.getAddLine1() + " \t" + 
	            		   SearchCustomer.getAddLine2() + " \t" + 
	            		   SearchCustomer.getCity() + " \t" + 
	            		   SearchCustomer.getCounty() + " \t" + 
	            		   SearchCustomer.getCountry() + " \t" + 
	            		   SearchCustomer.getPhone() + " \t" + 
	            		   SearchCustomer.getEmail()+ "\n");
	               break;
	               
			case 3://add a new Customer
	               System.out.println("\n\nEnter the new Customer values");
	               
	               System.out.print("Enter Customer ID:\t");
	               int nCustomerID=kbIn.nextInt();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Enter Customer Name:\t");
	               String nCustomerName=kbIn.nextLine();
	               
	               System.out.print("Enter Customer Surname:\t");
	               String nCustomerSurname=kbIn.nextLine();
	               
	               System.out.print("Enter Customer Address Line 1:\t");
	               String nAddressLine1=kbIn.nextLine();
	               
	               System.out.print("Enter Customer Address Line 2:\t");
	               String nAddressLine2=kbIn.nextLine();
	               
	               System.out.print("Enter Customer City:\t");
	               String nCity=kbIn.nextLine();
	               
	               System.out.print("Enter Customer County:\t");
	               String nCounty=kbIn.nextLine();
	               
	               System.out.print("Enter Customer Country:\t");
	               String nCountry=kbIn.nextLine();
	               
	               System.out.print("Enter Customer Phone Number:\t");
	               String nPhone=kbIn.nextLine();
	              
	               System.out.print("Enter Customer Email Address:\t");
	               String nEmail=kbIn.nextLine();
	               
	               //kbIn.nextLine();//clear keyboard buffer
	               //System.out.print("Enter Customer Email Password:\t");
	               //String nPassword=kbIn.nextLine();
	               
	               
	               Customers newCustomers = new Customers(nCustomerID,nCustomerName,nCustomerSurname,nAddressLine1,
	            		   nAddressLine2,nCity,nCounty,nCountry,nPhone,nEmail);
	               int addStatus = myCustomers.add(newCustomers);
	               if (addStatus==1)
	                  System.out.println("Customer successfully added to database\n");
	               break;
	               
			case 4://delete a Customer
	               int delCustomerNo=0;
	               System.out.print("\n\nEnter the Customer number you wish to delete:");
	               delCustomerNo=kbIn.nextInt(); 
	               int delStatus = myCustomers.delete(delCustomerNo);
	               if (delStatus==1)
	                  System.out.println("Customer successfully deleted from database");          
	               break;
	               
			}
			
		}while (menuOpt!=0); 

	}

}
