import com.bank_haro.dashboard.LoginPage;
import com.bank_haro.user.BankAccount;

public class Main {
    public static void main(String[] args){
        BankAccount idandPasswords = new BankAccount();

        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    }
}
