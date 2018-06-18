package Testing;

public class BankAccount {
    private String firstname;
    private String lastName;
    private double balance;

    public BankAccount(String firstname, String lastName, double balance) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.balance = balance;
    }

    //Branch field is true if the transaction is happening at a Branch as opposed to an ATM.
    public double deposit(double amount, boolean branch){
        balance+=amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance-=amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) {

    }
}
