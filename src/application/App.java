package application;

import model.entities.Reservation;
import model.exceptions.ReservationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            Integer roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation:");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException exception) {
            System.out.println("Invalid date format");
        }

        catch (ReservationException exception) {
            System.out.println("Error in reservation: " + exception.getMessage());
        }

        catch (RuntimeException exception) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
