package Help;

import java.util.Scanner;

public class Help {
    final static Scanner sc = new Scanner(System.in);

    public static String inputString(String message, String oldValue) {
        System.out.print(message);
        System.out.println(oldValue);
        System.out.print("New value >>");
        var newValue = sc.nextLine();
        newValue = newValue.trim();
        boolean IsNullOrEmpty = false;
        if (newValue == null || newValue == "") {
            IsNullOrEmpty = true;
        }
        return IsNullOrEmpty ? oldValue : newValue;
    }

    public static String inputString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public static String inputString() {
        return sc.nextLine();
    }

    public static int inputInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("error!");
        }
        return 0;
    }

    public static int inputInt(String message) {
        try {
            System.out.print(message);
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("error!");
        }
        return 0;
    }

    public static int inputInt(String message, int oldValue) {
        try {
            System.out.print(message);
            System.out.println(oldValue);
            System.out.print("New value >>");
            var input = sc.nextLine();
            input = input.trim();
            boolean IsNullOrEmpty = false;
            if (input == null || input == "") {
                IsNullOrEmpty = true;
                input="0";
            }
            int newValue = Integer.parseInt(input);
            return IsNullOrEmpty ? oldValue : newValue;
        } catch (NumberFormatException n) {
            System.out.println("error!");
        }
        return 0;
    }

    public static float inputFloat() {
        try {
            return Float.parseFloat(sc.nextLine());
        } catch (NullPointerException n) {
            System.out.println("error!");
        }
        return 0;
    }

    public static float inputFloat(String message) {
        try {
            System.out.print(message);
            return Float.parseFloat(sc.nextLine());
        } catch (NullPointerException n) {
            System.out.println("error!");
        }
        return 0;
    }

    public static float inputFloat(String message, float oldValue) {
        try {
            System.out.print(message);
            System.out.println(oldValue);
            System.out.print("New value >>");
            var input = sc.nextLine();
            input = input.trim();
            boolean IsNullOrEmpty = false;
            if (input == null || input == "") {
                IsNullOrEmpty = true;
                input="0.0f";
            }
            float newValue = Float.parseFloat(input);
            return IsNullOrEmpty ? oldValue : newValue;
        } catch (NumberFormatException n) {
            System.out.println("error!");
        }
        return 0;
    }

    public static void outputString(String message) {
        System.out.println(message);
    }
}
