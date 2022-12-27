package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Room number: ");
		int num = in.nextInt();
		System.out.println("Check-in date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(in.next());
		System.out.println("Check-Out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(in.next());
		
		if(!checkOut.after(checkOut)) {
			System.out.println("Error in reservation: Check-out date must de after check-in date");
			
		}
		else {
			Reservation reservation = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
				
			System.out.println();
			System.out.println("Enter data update the reservation:");
			System.out.println("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(in.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(in.next());

		Date now= new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in reservation: Check-out must be after check-in date");
		}
		else if(!checkOut.after(checkOut)) {
			System.out.println("Error in reservation: Check-out date must de after check-in date");
		}
		else {
			reservation.updateDates(checkIn,checkOut);
			System.out.println("Reservation: " +reservation);
		}
	}
		in.close();
}
}
