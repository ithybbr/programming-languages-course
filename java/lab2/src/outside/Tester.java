package outside;

import banking_system.ATM;
import banking_system.Bank;

public class Tester {
    public static void main(String[] args) {
        Bank testBank = new Bank();
        ATM testAtm1 = new ATM();
        ATM testAtm2 = new ATM();
        testBank.attachATM(testAtm1);
        testBank.attachATM(testAtm2);
        Customer newCustomer1 = new Customer(testBank, testAtm2);
        Customer newCustomer2 = new Customer(testBank, testAtm1);
        Customer newCustomer3 = new Customer(testBank, testAtm1);
        System.out.println(newCustomer1.depositMoney(1500));
        newCustomer3.depositMoney(1000);
        System.out.println(newCustomer1.checkBalance());
        System.out.println(newCustomer2.checkBalance());
        System.out.println(newCustomer3.checkBalance());
        newCustomer1.withdrawMoney(800);
        System.out.println(newCustomer1.checkBalance());
        newCustomer3.withdrawMoney(1200);
        System.out.println(newCustomer3.checkBalance());
        newCustomer2.depositMoney(-1000);
        System.out.println(newCustomer2.checkBalance());
    }
}
