package exceptions.ex01.applicantion;

import exceptions.ex01.modal.entities.Reservation;
import exceptions.ex01.modal.exceptions.DomainException;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa não deve aceitar dados
inválidos para a reserva, conforme as seguintes regras:
- Alterações de reserva só podem ocorrer para datas futuras
- A data de saída deve ser maior que a data de entrada
*/
        /*• Solução 3 (boa): tratamento de exceções*/

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), ft);
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), ft);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), ft);
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), ft);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());

        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}




