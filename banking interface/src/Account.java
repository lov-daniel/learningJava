import java.util.concurrent.atomic.AtomicInteger;

public class Account extends Person {


    int currentBalance = 0;
    String password;
    public final int minimumDeposit = 5000;

    public Account() {

    }

    public Account(String firstName, String middleName, String lastName, String address, String socialSecurity, String password, int balance) {
        super(firstName, middleName, lastName, address, socialSecurity);
        this.password = password;
        this.currentBalance = balance;

    }
}
