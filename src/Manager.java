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

    public void getIntro() {
        System.out.println("Введите, что надо сделать");
    }

    public void getHelp() {
        // Roman
        System.out.println("Здесь будет выданна помощь!");
    }

    public void getInfo() { //startInfoCommand
        //Romam
        System.out.println("Здесь будет выданна Информация о коллекции!");
    }

    public void getshow() {
        System.out.println("Здесь будет выданны все элементы коллекции!");
    }


    public void add() { // startAddCommand
        //Sergej
        System.out.println("добавить новый элемент в коллекцию!");
    }

    public void update_by_id(String id) {
        System.out.println("обновить значение элемента коллекции, по id ");
    }

    public void remove_by_id(String id) {
        System.out.println("удалить элемент из коллекции по его id! ");
    }

    public void clear() {
        System.out.println("очистить коллекцию! ");
    }

    public void remove_head() {
        System.out.println("вывести первый элемент коллекции и удалить его! ");
    }

    public void history() {
        System.out.println("вывести последние 15 команд! ");
    }

    public void filter_less_than_balcony() {
        System.out.println("вывести элементы, значение поля balcony! ");
    }

    public void print_ascending() {
        System.out.println("вывести элементы коллекции в порядке возрастания! ");
    }


}
