import model.ATM;
import model.Account;

public class App {
    public static void main(String[] args) throws Exception {
        Account account = new Account("1234567890", "Ashutosh Singh", 10000, 1234);
        ATM atm = new ATM(account);
        atm.start();
    }
}
