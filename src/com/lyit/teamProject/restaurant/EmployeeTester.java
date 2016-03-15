package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeTester {

	public static void main(String[] args) {
		int menuOpt=0;
		Scanner kbIn = new Scanner(System.in);
		Employees myEmployees = new Employees();
		
		do{
			System.out.println("\t\tEmployees Menu");
			System.out.println("\t1. Display all Employees");
			System.out.println("\t2. Search & display one Employee");
			System.out.println("\t3. Add Employee");
			System.out.println("\t4. Fire Employee");
			System.out.println("\t0. Exit");
			menuOpt=kbIn.nextInt();
			
			switch(menuOpt) {
			
			case 1:// Display all employees
				
				ArrayList<Employees> allEmployees = myEmployees.getAllEmployees();
	               System.out.println("View All Employees");
	               System.out.println("Employee ID \tEmployee Name \tEmployee Surname \tEmployee Role\tEmployee Phone \tEmployee Password");
	               Iterator<Employees> employeeIterator = allEmployees.iterator();
	               while(employeeIterator.hasNext())    {
	            	   Employees DisplayEmployees = employeeIterator.next();
	                  System.out.println(DisplayEmployees.getEmpID() + " \t" + 
	                		  DisplayEmployees.getEmpName() + " \t\t" + 
	                		  DisplayEmployees.getEmpSName() + " \t\t" +  
	                		  DisplayEmployees.getEmpRole() + " \t\t" + 
	                		  DisplayEmployees.getEmpPasswd() + " \t\t" );
	               }
	            
	               break;
	               
			case 2:// Search for and display one Employee
	               int searchEmployeeNo=0;
	               System.out.println("\n\nEnter the Customer number you wish to view");
	               searchEmployeeNo=kbIn.nextInt();      
	               Employees SearchEmployees = myEmployees.getEmployees(searchEmployeeNo);
	               System.out.println(SearchEmployees.getEmpID() + " \t" + 
	            		   SearchEmployees.getEmpName() + " \t\t" + 
	            		   SearchEmployees.getEmpSName() + " \t\t" +  
	            		   SearchEmployees.getEmpRole() + " \t\t" + 
	            		   SearchEmployees.getEmpPasswd() + " \t\t" );
	               break;
	               
			case 3://Hire a new Employee
	               System.out.println("\n\nEnter the new Employee values");
	               
	               System.out.print("Enter Employee ID:\t");
	               int nEmployeeID=kbIn.nextInt();
	               kbIn.nextLine(); // clear keyboard buffer
	               
	               System.out.print("Enter Employee Name:\t");
	               String nEmployeeName=kbIn.nextLine();
	              // kbIn.nextLine();//clear keyboard buffer
	               
	               System.out.print("Enter Employee Surname:\t");
	               String nEmployeeSurname=kbIn.nextLine();
	              // kbIn.nextLine();//clear keyboard buffer
	               
	               System.out.print("Enter Employee Role:\t");
	               String nEmpRole=kbIn.nextLine();
	               //kbIn.nextLine();//clear keyboard buffer
	               
	               System.out.print("Enter Employee Salary:\t");
	               double nEmpSalary=kbIn.nextDouble();
	               kbIn.nextLine();
	               
	               System.out.print("Enter Employee Phone Number:\t");
	               String nEmpPhone=kbIn.nextLine();
	               
	               System.out.print("Enter Employee Password:\t");
	               String nEmpPasswd=kbIn.nextLine();
	              // kbIn.nextLine();//clear keyboard buffer
	               
	               
	               Employees newEmployee = new Employees(nEmployeeID,nEmployeeName,nEmployeeSurname,nEmpRole,nEmpSalary,nEmpPhone, nEmpPasswd);
	               int addStatus = myEmployees.add(newEmployee);
	               if (addStatus==1)
	                  System.out.println("record successfully added to database");
	               break;
	               
			case 4:// Fire an Employee
	               int delEmployeeNo=0;
	               System.out.print("\n\nEnter the Employee number you wish to Fire:");
	               delEmployeeNo=kbIn.nextInt(); 
	               int delStatus = myEmployees.delete(delEmployeeNo);
	               if (delStatus==1)
	                  System.out.println("Employee terminated");          
	               break;
	               
			case 5:// Change Employee Password
				   int changeEmpId=0;
	               String newPasswd="";
	               
	               int changeStatus=0;
	               System.out.print("\n\nEnter the Employee ID you wish to change Password on: ");
	               changeEmpId=kbIn.nextInt(); 
	               System.out.print("\n\nPlease Enter new Password: ");
	               newPasswd=kbIn.nextLine(); 
	               changeStatus=myEmployees.changePassword(changeEmpId, newPasswd);
	               if (changeStatus==1)
	                  System.out.println("Password successfully updated");
	               break;	
	               
			case 6:// Change Employee Phone Number
				   int changeEmpPhone=0;
	               String newPhone="";
	               
	               int changePhone=0;
	               System.out.print("\n\nEnter the Employee ID you wish to change Password on: ");
	               changeEmpPhone=kbIn.nextInt(); 
	               System.out.print("\n\nPlease Enter new Password: ");
	               newPhone=kbIn.nextLine(); 
	               changePhone=myEmployees.changePassword(changeEmpPhone, newPhone);
	               if (changePhone==1)
	                  System.out.println("Password successfully updated");
	               break;	
	               
			}
			
		}while (menuOpt!=0); 

	}

}
