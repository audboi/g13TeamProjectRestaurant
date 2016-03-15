package com.lyit.teamProject.restaurant;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookingsTester {
	public static void main(String[] args) {
		int menuOpt = 0;
		Scanner kIn = new Scanner(System.in);
		Bookings myBookings = new Bookings();

		do {
			System.out.println("\t\t\n\n\nBookings Options");
			System.out.println("\t1. Display all Bookings");
			System.out.println("\t2. Search and display one Booking");
			System.out.println("\t3. Make a Booking");
			System.out.println("\t4. Cancel a Booking");
			System.out.println("\t5. Change number of Guests");
			System.out.println("\t5. Change Booking Date");
			System.out.println("\t0. Exit the system");
			menuOpt = kIn.nextInt();

			switch (menuOpt) {

			case 1:// Display all current Bookings on System this function is
					// ONLY available to Manager and Chef

				ArrayList<Bookings> allBookings = myBookings.getAllBookings();
				System.out.println("View All Current Bookings");
				System.out.println("Booking Date \tBooking ID\tNo of Guests \tCustomer Details\tSpecial Requests");
				Iterator<Bookings> BookingsIterator = allBookings.iterator();
				while (BookingsIterator.hasNext()) {
					Bookings DisplayBookings = BookingsIterator.next();
					System.out.println(DisplayBookings.getbookingdate() + " \t" + DisplayBookings.getBookID() + " \t\t"
							+ DisplayBookings.getBookQty() + " \t\t" + DisplayBookings.getCustID() + " \t\t"
							+ DisplayBookings.getSpecReq() + " \t\t" + DisplayBookings.getEvType() + " \t\t"
							+ DisplayBookings.getDietReq() + " \t\t" + DisplayBookings.getAllergen() + " \t\t"
							+ DisplayBookings.getOtherReq());
				}

				break;

			case 2:// Search and display one Booking this function is ONLY
					// available to Manager and Chef
				int searchBookingsNo = 0;
				System.out.println("\n\nEnter the Bookings number you wish to view");
				searchBookingsNo = kIn.nextInt();
				Bookings SearchBookings = myBookings.getBooking(searchBookingsNo);
				System.out.println(SearchBookings.getbookingdate() + " \t" + SearchBookings.getBookID() + " \t\t"
						+ SearchBookings.getBookQty() + " \t\t" + SearchBookings.getCustID() + " \t\t"
						+ SearchBookings.getSpecReq() + " \t\t" + SearchBookings.getEvType() + " \t\t"
						+ SearchBookings.getDietReq() + " \t\t" + SearchBookings.getAllergen() + " \t\t"
						+ SearchBookings.getOtherReq());
				break;

			case 3:// Make a new Booking this function is available to Customer,
					// Manager and Chef
				System.out.println(
						"\n\nPlease Enter Date, Your Name, No Of Guests,Confirmation ID and any Special Requests");
				System.out.print("\t\tEnter Booking Date (YYYY-MM-DD):\t");
				String newDate = kIn.next();

				System.out.print("Enter Booking ID:\t");// Hidden from Customer
														// via available button
				int nBookingsID = kIn.nextInt(); // This function is available
													// to Manager only
				// kIn.nextInt();

				System.out.print("Enter Number of Guests:\t");// This function
																// is available
																// to Customer
																// and Manager
				int nBookingsNoOfGuests = kIn.nextInt(); // Hidden from Chef
				// kIn.nextLine();//clear keyboard buffer

				System.out.print("What is your Cust ID number");
				int newCustID = kIn.nextInt();
				kIn.nextLine();

				System.out.print("Please tell us about any special requests you may have");
				String newSpecReq = kIn.nextLine();

				System.out.print("Please tell us about your Event");
				String newEvType = kIn.nextLine();

				System.out.print("Please tell us about any special Dietary Requirements");
				String newDietReq = kIn.nextLine();

				System.out.print("Please tell us about any Allergens you may have");
				String newAllergen = kIn.nextLine();

				System.out.print("Please tell us about any other requirements you may have");
				String newOtherReq = kIn.nextLine();

				Bookings newBookings = new Bookings(newDate, nBookingsID, nBookingsNoOfGuests, newCustID, newSpecReq,
						newEvType, newDietReq, newAllergen, newOtherReq);
				int addStatus = myBookings.add(newBookings);
				if (addStatus == 1)
					System.out.println("Thank you for booking with us we hope you enjoy your evening");// Customer
																										// message
				System.out.println("Table succesfully booked, please contact customer with details");// Manager
																										// Message
				break;

			case 4:// Cancel A Booking
				int delBookingsNo = 0;
				System.out.print("\n\nPlease enter your booking reference Number:");
				delBookingsNo = kIn.nextInt();
				int delStatus = myBookings.delete(delBookingsNo);
				if (delStatus == 1)
					System.out.println("Thank you! You have successfully cancelled your booking");
				break;

			case 5:// change number of customers
				int changeBookingsNo = 0;
				int newBookings1 = 0;

				int changeStatus = 0;
				System.out.print("\n\nEnter the Customer number you wish to change: ");
				changeBookingsNo = kIn.nextInt();
				System.out.print("\n\nEnter the new number for bookings: ");
				newBookings1 = kIn.nextInt();
				changeStatus = myBookings.changeNoCustomer(changeBookingsNo, newBookings1);
				if (changeStatus == 1)
					System.out.println("Record successfully updated");
				break;

			}
		} while (menuOpt != 0);
	}
}
