import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Manager {

    List<Flat> flats;
    LinkedList<String> commands;

    Scanner scanner;

    // privat и getter and setter
    Manager() {
        flats = new LinkedList<>();
        commands = new LinkedList<>();
        scanner = new Scanner(System.in);

    }


    Utils util = new Utils();

    public int houseYear() {
        while (true) {
            System.out.println("Введите год постройки дома: ");
            String line = scanner.nextLine();
            if (!Utils.isInt(line)) {
                System.out.println("Это не число!");
                continue;
            }
            int year = Integer.parseInt(line);
            if (year < 2030 && year > 0) {
                return year;
            }
            System.out.println("Должно быть меньше 2030 и больше 0!");
        }
    }

    public String houseName() {
        while (true) {
            System.out.println("Введите название дома: ");
            String line = scanner.nextLine();
            if (!Utils.isString(line)) {
                System.out.println("это пустая строка!");
                continue;
            }
            return line;
        }
    }

    public House findHouseByName(String name) {
        for (Flat flat : flats) {
            if (flat.getHouse().getName().equals(name))
                return flat.getHouse();
        }
        return null;
    }

    public House getOrCreateHouse(String name, int year) {
        House home = this.findHouseByName(name);
        if (home == null)
            home = new House(name, year);
        return home;
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
                "filter_balcony: вывести элементы значения поля balcony \n" +
                "print_ascending {print}: вывести список в порядке возрастания");
    }

    public void startInfoCommand() { //startInfoCommand
        //Romam
        System.out.println("Здесь будет выданна Информация о коллекции!");
    }

    public void show() {
        //Sergej
        System.out.println("Здесь будет выданны все элементы коллекции!");
        for (Flat flat : flats) {
            System.out.println(flat);
        }
    }


    public void addFlat() { //добавляем Квартиру
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
            if (Utils.isInt(lineIn)) {
                addArea = Integer.valueOf(lineIn);
                if (addArea > 200) {
                    addArea = -1;
                    System.err.println("неверный ввод, не более 200 кв метров");
                }
            } else {
                System.err.println("неверный ввод, задайте цифры");
            }
        } while (!Utils.isInt(lineIn) || addArea < 0);

        do {
//            here:
            System.out.println("введите количество комнат в новой Квартиры");
            lineIn = scanner.nextLine();
            if (Utils.isInt(lineIn)) {
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
        } while (!Utils.isInt(lineIn) || addNrRooms < 0);


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

        House h1 = new House(houseName(), houseYear());
        //добавление новой квартиры
        Flat flat = new Flat(addName, addArea, addNrRooms, addBalcony, h1);
        flats.add(flat);
        System.out.println("квартира заданна");
        System.out.println(flat);
    }

    public void update_by_id(String argsIn) {
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
                            System.out.println("Задайте сколько комнат в квартире");
                            arg = scanner.nextLine();

                            if (!Utils.isInt(arg)) {
                                System.err.println("не задоннaя строка");
                            } else {
                                int newNumberOfRooms = Integer.valueOf(arg);
                                flat.setNumberOfRooms(newNumberOfRooms);
                            }
                            break;

                        case "balcony":
                            System.out.println("Задайте есть ли в квартире балкон");
                            arg = scanner.nextLine();
                            arg = arg.toLowerCase();

                            if (!Utils.isString(arg)) {
                                System.err.println("не задоннaя строка");
                            } else {
                                flat.setBalcony(arg);
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
        System.out.println("удаляем элемент из коллекции по его id! ");

        if (!Utils.isInt(argsIn)) {
            System.err.println("неверный ввод, надо цифры");
        } else {
            int id = Integer.valueOf(argsIn);
            System.out.println(flats.remove(id));
        }
    }

    public void clear() {
        System.out.println("очистить коллекцию! ");
        System.out.println("Вы уверены? ja/yes ");
        String lineIn = scanner.nextLine().toLowerCase();
        if (lineIn.equals("ja") || lineIn.equals("yes")) {
            flats.clear();
            System.out.println("Всё удалено");

        } else {
            System.out.println("abort");
        }
    }

    public void remove_head() {
        System.out.println("вывести первый элемент коллекции и удалить его! ");
        System.out.println(flats.remove(0));
    }

    public void addCommand(String lastCommand) {

        commands.add(lastCommand);
        if (commands.size() > 15) {
            commands.removeFirst();
        }
    }

    public void history() {
        System.out.println("Выводит последние 15 Команд");

        for (String str : commands) {
            System.out.println(str);
        }
    }

    public void filter_balcony() {
        System.out.println("вывести элементы, значение с балконом! или без \n " +
                "with / mit = с Балконом, without / ohne = без Балкона");
        String lineIn = scanner.nextLine().toLowerCase();
        if (lineIn.equals("with") || lineIn.equals("mit")) {
            System.out.println("Выдаю квартиры с балконом");
            for (Flat flat : flats) {
                if (flat.isBalcony()) {
                    System.out.println(flat);
                }
            }
        } else if (lineIn.equals("without") || lineIn.equals("ohne")) {
            System.out.println("Выдаю квартиры без балкона");
            for (Flat flat : flats) {
                if (!flat.isBalcony()) {
                    System.out.println(flat);
                }
            }
        } else {
            System.out.println("не праввельный ввод");
        }
    }

    public void print_ascending() {
        System.out.println("вывести элементы коллекции в порядке возрастания! ");
    }
// и тут коментарий

}
