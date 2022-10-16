package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration() {
        return TimeUnit.DAYS.convert(checkOut.getTime() - checkIn.getTime(), TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + simpleDateFormat.format(checkIn) + ", check-out: " + simpleDateFormat.format(checkOut) + ", " + duration() + " nights";
    }
}
