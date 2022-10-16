package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        Integer roomNumber = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation:");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: check-out date must be after check-in.");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }

        }

        sc.close();
    }
}
