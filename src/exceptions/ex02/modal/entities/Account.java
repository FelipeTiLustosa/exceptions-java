package exceptions.ex02.modal.entities;

import exceptions.ex02.modal.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance; //saldo
    private Double withdrawLimit;// Limite de retirada


    public Account() {
    }
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public  void withdraw(Double amount) {
        validatewithdraw(amount);
        this.balance -= amount;
    }
    public  void validatewithdraw(Double amount)  {
        if (amount>getWithdrawLimit()){
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit");

        } else if (amount>getBalance()) {
        throw new DomainException("Withdraw error: Not enough balance");
        }
    }
}
