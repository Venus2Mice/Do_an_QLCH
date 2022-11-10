package Help;
import java.util.Scanner;
public class Help {
    final static Scanner sc = new Scanner(System.in);
    public static String inputString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
    public static String inputString() {
        return sc.nextLine();
    }
    public static int inputInt() {
        return Integer.parseInt(sc.nextLine());
    }
    public static int inputInt(String message) {
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }
    public static float inputFloat() {
        return Float.parseFloat(sc.nextLine());        
    }
    public static float inputFloat(String message) {
        System.out.print(message);
        return Float.parseFloat(sc.nextLine());
    }
    public static void outputString(String message) {
        System.out.println(message);
    }
}
