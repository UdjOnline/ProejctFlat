import java.util.List;
import java.util.Scanner;


public class Manager {

    Scanner scanner;

    Manager() {
        scanner = new Scanner(System.in);
    }

    Utils util = new Utils();

    public int getYear() {
        System.out.println("Введите год построики дома: ");
        String line = scanner.nextLine();
        if (util.isInt(line)) {
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
        System.out.println("help: список доступных команд \n" +
                "info: cписок всех квартир \n" +
                "show: показать все квартиры в списке: \n" +
                "add: добавить новую квартиру в список \n" +
                "update_by_id {id}: обновить данные квартиры с указанным id \n" +
                "remove_by_id {id}: удалить квартиру с данным id \n" +
                "clear: очмстить список квартир (используйте осторожно!) \n" +
                "exit: завершить программу без сохранения в файл \n" +
                "remove_head {head}: вывести первую квартиру списка и удалить её \n" +
                "history: вывести последние 15 команд \n" +
                "filter_less_than_balcony {balcony}: вывести элементы значения поля balcony \n" +
                "print_ascending {print}: вывести список в порядке возрастания");
    }

    public void startInfoCommand() { //startInfoCommand
        //Romam
        System.out.println("Здесь будет выданна Информация о коллекции!");
    }

    public void getshow() {
        //Sergej
        System.out.println("Здесь будет выданны все элементы коллекции!");
    }


    public void addCommand(List<Flat> flats) { //добавляем Квартиру
        String lineIn;
        String addName = null;
        int addArea = -1;
        int addNrRooms = -1;
        boolean addBalcony = false;

        System.out.println("добавить новую Квартиру!");

        System.out.println("введите Название новой Квартиры");
        lineIn = scanner.nextLine();
        addName = lineIn;

        do {
            System.out.println("введите размер новой Квартиры в квадратных метрах");
            lineIn = scanner.nextLine();
            if (util.isInt(lineIn)) {
                addArea = Integer.valueOf(lineIn);
                if (addArea > 200) {
                    addArea = -1;
                    System.err.println("неверный ввод, не более 200 кв метров");
                }
            } else {
                System.err.println("неверный ввод, задайте цифры");
            }
        } while (!util.isInt(lineIn) || addArea < 0);

        do {
//            here:
            System.out.println("введите количество комнат в новой Квартиры");
            lineIn = scanner.nextLine();
            if (util.isInt(lineIn)) {
                addNrRooms = Integer.valueOf(lineIn);
                if (addNrRooms < 0 || addNrRooms > 8) {
                    System.err.println("неверный ввод, задайте цифры от 0 до 8");
                    addNrRooms = -1;
//                    continue here;
//                      //не работает сброс в начало цикла
                }
            } else {
                System.err.println("неверный ввод, задайте цифры от 0 до 8");
            }
        } while (!util.isInt(lineIn) || addNrRooms < 0);


        do {
            System.out.println("введите есть ли балкон в Квартиры");
            lineIn = scanner.nextLine();
            if (lineIn.equals("yes") || lineIn.equals("ja")) {
                addBalcony = true;
                break;
            } else if (lineIn.equals("no") || lineIn.equals("nein")) {
                addBalcony = false;
                break;
            } else {
                System.err.println("неверный ввод");
            }
        } while (true);

        //добавление новой квартиры
        Flat flat = new Flat(addName, addArea, addNrRooms, addBalcony);
        flats.add(flat);
        System.out.println("квартира заданна");
        System.out.println(flat);
    }

    public void update_by_id(String argsIn, List<Flat> flats) {
        int id;

        if (!Utils.isInt(argsIn)) {
            System.err.println("неверный ввод, надо цифры");
        } else {
            id = Integer.valueOf(argsIn);
            for (Flat flat : flats) {
                if (id == flat.getId()) {

                    System.out.println("Какой из параметров вы хотите поменять?");
                    String lineIn = scanner.nextLine();
                    String arg;
                    lineIn = lineIn.toLowerCase();

                    switch (lineIn) {

                        case "name":
                            System.out.println("Задайте новое название ?");
                            arg = scanner.nextLine();

                            if (!util.isString(arg)) {
                                System.err.println("не задонноя строка");
                            } else {
                                String newName = arg;
                                flat.setName(newName);
                            }
                            break;

                        case "area":
                            System.out.println("Задайте новую площадь");
                            arg = scanner.nextLine();

                            if (!util.isInt(arg)) {
                                System.err.println("не задоннaя строка");
                            } else {
                                int newArea = Integer.valueOf(arg);
                                flat.setArea(newArea);
                            }
                            break;

                        case "rooms":
                            System.out.println("Задайте сколько");
                            arg = scanner.nextLine();

                            if (!Utils.isInt(arg)) {
                                System.err.println("не задоннaя строка");
                            } else {
                                int newNumberOfRooms = Integer.valueOf(arg);
                                flat.setNumberOfRooms(newNumberOfRooms);
                            }
                            break;

                        default:
                            System.err.println("не верно задонноя строка");

                    }


//                } else {
                }
                System.err.println("ID не найден");

            }
        }


        System.out.

                println("обновить значение элемента коллекции, по id ");
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
// и тут коментарий

}
