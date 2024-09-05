package exceptions.ex02.applicantion;

import exceptions.ex02.modal.entities.Account;
import exceptions.ex02.modal.exceptions.DomainException;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         /*Fazer um programa para ler os dados de uma conta bancária e depois realizar um
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
saque da conta. Implemente a conta bancária conforme projeto abaixo:
*/
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            System.out.println();
            Account acc=new Account(number,holder,initialBalance,withdrawLimit);
            System.out.print("Enter amount for withdraw: ");
            double quant=sc.nextDouble();
            acc.withdraw(quant);
            System.out.println("New balance: "+acc.getBalance());
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.println("unexpected error");
        }



    }


}
