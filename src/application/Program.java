package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
	try {
			System.out.println("Room number: ");
			int num = in.nextInt();
			System.out.println("Check-in date (dd/MM/yyy): ");
			Date checkIn = sdf.parse(in.next());
			System.out.println("Check-Out date (dd/MM/yyy): ");
			Date checkOut = sdf.parse(in.next());
		
		
			Reservation reservation = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
				
			System.out.println();
			System.out.println("Enter data update the reservation:");
			System.out.println("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(in.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(in.next());

			reservation.updateDates(checkIn,checkOut);
			System.out.println("Reservation: " +reservation);
		}
	catch(ParseException e) {
		System.out.println("Invalid date format");
	}
	catch(DomainException e) {
		System.out.println("Error in reservation: "+ e.getLocalizedMessage());
	}
		in.close();
}
}
