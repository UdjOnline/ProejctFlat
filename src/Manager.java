import java.util.Scanner;
public class Manager {

    Scanner scanner;

    Manager() {
        scanner = new Scanner(System.in);
    }

    public static boolean isInt(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getYear(){
        System.out.println("Введите год построики дома: ");
        String line = scanner.nextLine();
        if (isInt(line)) {
            return Integer.valueOf(line);

        } else {
            return 0;
        }
    }
}
