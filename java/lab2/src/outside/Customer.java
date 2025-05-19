package outside;

import banking_system.ATM;
import banking_system.Bank;

public class Customer {
    private Bank bank;
    private ATM atm;
    private int accountNumber;
    Customer(Bank b, ATM atm){
        bank = b;
        this.atm = atm;
        openAccount();
    }
    public void openAccount(){
        accountNumber = bank.createAccount();
    }
    public boolean depositMoney(int amount){
        boolean result = false;
        if(atm.loginToAccount(accountNumber)){
            result = atm.deposit(amount);
            atm.logout();
        }
        return result;
    }
    public boolean withdrawMoney(int amount){
        boolean result = false;
        if(atm.loginToAccount(accountNumber)){
            result = atm.withdraw(amount);
            atm.logout();
        }
        return result;
    }
    public int checkBalance(){
        int balance = 0;
        if(atm.loginToAccount(accountNumber)){
            balance = atm.getBalance();
            atm.logout();
        }
        return balance;
    }
}
