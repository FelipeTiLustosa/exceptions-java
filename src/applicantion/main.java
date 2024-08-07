package applicantion;

import model.entities.Reservation;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws DateTimeParseException {
/*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa não deve aceitar dados
inválidos para a reserva, conforme as seguintes regras:
- Alterações de reserva só podem ocorrer para datas futuras
- A data de saída deve ser maior que a data de entrada
*/
        //• Solução 1 (muito ruim): lógica de validação no programa principal
        //• Lógica de validação não delegada à reserva
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), ft);
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), ft);

        /*isBefore: Usa-se para verificar se uma data ou tempo é antes de outra.
         isAfter: Usa-se para verificar se uma data ou tempo é depois de outra.
        * */
        if (!checkOut.isAfter(checkIn)) {// isAfter serve para testa ser uma data e depois q a outra
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), ft);
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), ft);

            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {// ser a data de check-in for antes de agora ou a data de check-out for antes de agora q dizer q eu nao posso aceita as datas
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.isAfter(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

        }


        sc.close();
    }
}



