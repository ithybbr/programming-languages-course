package banking_system;
import java.util.ArrayList;
public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<ATM> atms = new ArrayList<ATM>();
    public int createAccount(){
        Account accountNew = new Account();
        accountNew.setAccount_number(accounts.size() + 1);
        accountNew.setAccount_balance(0);
        accounts.add(accountNew);
        return accountNew.getAccount_number();
    }
    public void attachATM(ATM atm){
        atms.add(atm);
        atm.setBank(this);
    }
    protected int accessAcctInfo(int acctNum) throws Exception{
        for(Account account: accounts){
            if(account.getAccount_number() == acctNum){
                return account.getAccount_balance();
            }
        }
        throw new Exception("Error: the given account number has no corresponding Account in the Bank.");
    }
    protected void updateAcctBal(int acctNum, int diff) throws Exception{
        for(Account account: accounts){
            int newAccountBalance;
            if(account.getAccount_number() == acctNum){
                newAccountBalance = account.getAccount_balance() + diff;
                if(newAccountBalance < 0){
                    throw new Exception("Error: the resulting balance became negative");
                }
                //System.out.println("new account balance is " + newAccountBalance);
                account.setAccount_balance(newAccountBalance);
            }
        }
    }
    protected ArrayList<Account> getAccounts() {
        return accounts;
    }
}
