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
        System.out.println("Список доступных команд...");
        System.out.println("help: список доступных команд");
        System.out.println("show: показать все квартиры в списке");
        System.out.println("add: добавить новую квартиру в список");
        System.out.println("update_by_id {id}: обновить данные квартиры с указанным id");
        System.out.println("remove_by_id {id}: удалить квартиру с данным id");
        System.out.println("clear: очистить список квартир (используйте осторожно)");
        System.out.println("exit: завершить программу без сохранения в файл");
        System.out.println("remove_head : вывести первую квартиру списка и удалить её");
        System.out.println("history : вывести последние 15 команд");
        System.out.println("filter_less_than_balcony {balcony}: filter_less_than_balcony {balcony} : вывести квартиры, значение поля balcony которых меньше заданного");
        System.out.println("print_ascending: вывести спискоре в порядке возрастания");
    }

    public void startInfoCommand() { //startInfoCommand
        //Romam
        System.out.println("Здесь будет выданна Информация о коллекции!");
    }

    public void getshow() {
        System.out.println("Здесь будет выданны все элементы коллекции!");
    }


    public void startAddCommand() { // startAddCommand
        //Sergej
        System.out.println("добавить новый элемент в коллекцию!");
    }

    public void update_by_id(String argsIn) {
        System.out.println("обновить значение элемента коллекции, по id ");
    }

    public void remove_by_id(String argsIn) {
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
