package Controller;

import Models.Account;
import Models.User;
import Views.LogInView;

public class LogInController {
    private User[] Models;

    public LogInController(User[] models) {
        Models = models;
    }

    public User Render() {
        var account = new Account();
        new LogInView(account).Render();
        if (check(account) != null) {
            return check(account);
        }
        return null;
    }

    private User check(Account account) {
        for (User user : Models) {
            var logic = user.getAccount().getUserName().equals(account.getUserName()) &&
                    user.getAccount().getPassword().equals(account.getPassword());
            if (logic) {
                return user;
            }
        }
        return null;
    }
}
