import com.bank_haro.dashboard.LoginPage;
import com.bank_haro.user.IDandPasswords;

public class Main {
    public static void main(String[] args){
        IDandPasswords idandPasswords = new IDandPasswords();

        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    }
}
