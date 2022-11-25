package Views;

import Framework.Help;
import Models.Account;

public class LogInView {
    private Account Account;

    public LogInView(Account account) {
        Account = account;
    }

    public void Render() {
        System.out.println("\t\t\t\t\t\t\t LOGIN MENU");
        Account.setUserName(Help.inputString("Username : "));
        Account.setPassword(Help.inputString("Password : "));
    }
}
