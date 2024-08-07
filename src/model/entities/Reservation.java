package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // implementacao basica da reserva sem ser preocupa com execoes ainda


    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
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

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    public  int duration(){
        return (int) ChronoUnit.DAYS.between(checkIn,checkOut);// esse metado e para data local sem hr, min e seg
    }
     // vai muda
    public  void updateDates(LocalDate checkIn, LocalDate checkOut){
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }

    @Override
    public String toString() {

        return "Room " +
                 roomNumber +
                ", check-In: " + checkIn.format(fmt) +
                ", checkOut: " + checkOut.format(fmt) +
                ", "+duration()+
                " nights";
    }
}
