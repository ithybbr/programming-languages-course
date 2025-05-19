package banking_system;
public class ATM {
    private Bank bank;
    private int currentAccountNumber = 0; 
    protected void setBank(Bank b){
        bank = b;
    }
    public boolean loginToAccount(int acctNum){
        for(Account account: bank.getAccounts()){
            if(account.getAccount_number() == acctNum){
                //System.out.println("account number " + account.getAccount_number());
                currentAccountNumber = acctNum;
                return true;
            }
        }
        return false;
    }
    public boolean deposit(int amount){
        //System.out.println("current account number is " + currentAccountNumber + " amount to deposit is " + amount);
        if(currentAccountNumber == 0){
            return false;
        }
        try{
            bank.updateAcctBal(currentAccountNumber, amount);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    public boolean withdraw(int amount){
        if(currentAccountNumber == 0){
            return false;
        }
        try{
            bank.updateAcctBal(currentAccountNumber, -amount);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public int getBalance(){
        if(currentAccountNumber == 0){
            return 0;
        }
        try{
            return bank.accessAcctInfo(currentAccountNumber);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public void logout(){
        currentAccountNumber = 0;
    }
}
