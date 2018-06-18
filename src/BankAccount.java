public class BankAccount {
    int accountNumber;
    int balance;
    String customerName;
    String email;
    int phoneNumber;

    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getcustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int deposit(int amount){
        System.out.println("Depositing " + amount + " in your account."+ " Balance is" + (getBalance()+ amount) );
        this.balance += amount;
        return getBalance()+ amount;
    }

    public int withdraw(int amount){
        int current = getBalance();
        if(current > amount){
            System.out.println("Amount left in you account : " + (current - amount));
            setBalance(current - amount);
            return current - amount;
        }
        else System.out.println("Cannot withdraw ovverdraft.");
        return current;
    }

    public static void main(String[] args){
        BankAccount myAccount = new BankAccount();
        myAccount.setBalance(2000);
        myAccount.setCustomerName("Prakash");
        myAccount.deposit(500);
        myAccount.withdraw(500);
    }
}
