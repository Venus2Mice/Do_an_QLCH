package DangNhap;

import java.util.Arrays;

public class Login {
    private static Account acclist[];
    public static boolean isSign;

    public Login() {
        acclist = new Account[1];
        CreateAcc("Admin", "123");
        OnLoad();
    }

    public void CreateAcc(String username, String password) {
        boolean found = false;
        for (Account account : acclist) {
            if (account.getUserName().equals(username)) {
                found = true;
                System.out.println("Ten dang nhap da ton tai");
            }
        }
        if (!found) {
            acclist = Arrays.copyOf(acclist, acclist.length + 1);
            acclist[acclist.length - 1] = new Account(username, password);
        }
    }

    public void OnLoad() {
        System.out.println("\t\t\t\t\t\t\tDang nhap...");
        System.out.println("1. Dang Nhap admin:");
        System.out.println("2. Dang nhap khach");
    }

}
