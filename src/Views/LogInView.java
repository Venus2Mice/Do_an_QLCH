package Views;

import Framework.ViewHelp;
import Models.Account;

public class LogInView {
    private Account Account;

    public LogInView(Account account) {
        Account = account;
    }

    public void Render() {
        System.out.println("\t\t\t\t\t\t\t LOGIN MENU");
        Account.setUserName(ViewHelp.inputString("Username : "));
        Account.setPassword(ViewHelp.inputString("Password : "));
    }
}
