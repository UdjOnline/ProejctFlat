import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //House house1 = new House("inSpanndau", 25);


        //ввести массив квартир:
        //перевести массив в LinkedList через for цикл.
        List<Flat> flats = new LinkedList<>();
//Евгений

        System.out.println("добро пожаловать в Манэджер квартир");

        boolean loopIsTrue = true;

        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        do {
            manager.getIntro();
            String[] lineInParts = null;
            String argIn = null;
            String lineIn = scanner.nextLine();
            // history

            if (lineIn.contains(" ")) {
                 lineInParts = lineIn.split(" ");
            }

            if (lineInParts != null && lineInParts.length == 2) {
                lineIn = lineInParts[0];
                argIn = lineInParts[1];
            }

            switch (lineIn) {
                case "exit":
                    System.out.println("до свиданья");
                    loopIsTrue = false;
                    break;

                case "help":
                    manager.getHelp();
                    break;

                case "info":
                    manager.getInfo(flats);
                    break;

                case "show":
                    manager.getshow();
                    break;

                case "add":
                    manager.add();
                    break;

                case "update_by_id":
                    manager.update_by_id(argIn);
                    break;

                case "remove_by_id":
                    manager.remove_by_id(argIn);
                    break;

                case "clear":
                    manager.clear();
                    break;

                case "remove_head":
                    manager.remove_head();
                    break;

                case "history":
                    manager.history();
                    break;

                case "filter_less_than_balcony":
                    manager.filter_less_than_balcony();
                    break;

                default:
                    System.err.println("не верно задонноя строка");

            }
        } while (loopIsTrue);



    }
}
//
//help : вывести справку по доступным командам
//info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
//show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
//add : добавить новый элемент в коллекцию (спросить про значение каждого поля)
//update_by_id {id}: обновить значение элемента коллекции, id которого равен заданному (спросить что вы хотите изменить, вы должны указать в вводе id той или иной квартиры, и тогда программа должна спросить какое поле вы хотите обновить и т.д.)
//remove_by_id {id} : удалить элемент из коллекции по его id
//clear : очистить коллекцию
//exit : завершить программу (без сохранения в файл)
//remove_head : вывести первый элемент коллекции и удалить его
//history : вывести последние 15 команд (без их аргументов)
//filter_less_than_balcony {balcony} : вывести элементы, значение поля balcony которых меньше заданного
//print_ascending : вывести элементы коллекции в порядке возрастания