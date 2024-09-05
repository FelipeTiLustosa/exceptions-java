package exceptions.ex01.modal.entities;


import exceptions.ex01.modal.exceptions.DomainException;

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

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if (!checkOut.isAfter(checkIn)){
            throw  new DomainException( "Check-out date must be after check-in date");
        }
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
    public  void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        /*isBefore: Usa-se para verificar se uma data ou tempo é antes de outra.
         isAfter: Usa-se para verificar se uma data ou tempo é depois de outra.
        * */
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {// ser a data de check-in for antes de agora ou a data de check-out for antes de agora q dizer q eu nao posso aceita as datas
            throw new DomainException( "Reservation dates for update must be future dates");
            // o throw new  vai lanca uma execao caso a condicao ocorra
        }
        if (!checkOut.isAfter(checkIn)){
            throw  new DomainException( "Check-out date must be after check-in date");
        }
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
