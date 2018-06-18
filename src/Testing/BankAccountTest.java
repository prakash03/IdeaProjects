package Testing;

import static org.junit.Assert.*;

public class BankAccountTest {

    @org.junit.Test
    public void deposit() {
        BankAccount account = new BankAccount("Prakash","Kantheti",3000);
        double balance = account.deposit(500,true);
        assertEquals(3500, balance, 0);
    }

    @org.junit.Test
    public void withdraw() {
    }

    @org.junit.Test
    public void getBalance() {
    }

}