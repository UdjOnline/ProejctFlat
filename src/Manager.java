import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Manager {

    List<Flat> flats;
    LinkedList<String> commands;
    Scanner scanner;
    Utils util = new Utils();

    // MANAGER CONSTRUCTOR
    Manager() {
        flats = new LinkedList<>();
        commands = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    //ADD COMMAND to the command list (commands)
    public void addCommand(String lastCommand) {
        System.out.println("Adding current command to the list..");
        commands.add(lastCommand);
        if (commands.size() > 15) {
            commands.removeFirst();
        }
    }

    //ADD FLAT
    public void addFlat() {
        String addName = addFlatName();
        int addArea = addFlatArea();
        int addNrRooms = addFlatNrRooms();
        boolean addBalcony = addFlatBalcony();
        Furnish furniture = addFlatFurniture();
        House h1 = new House(addHouseName(), addHouseYear());
        //добавление новой квартиры
        Flat flat = new Flat(addName, addArea, addNrRooms, addBalcony, furniture, h1);
        flats.add(flat);
        System.out.println("Flat has been added to the list.");
        System.out.println(flat);
    }

    //auxiliary method to allow user to enter flat's name
    private String addFlatName() {
        System.out.println("Add a new flat!");
        System.out.println("Enter flat's name...");
        String flatName = scanner.nextLine();
        return flatName;
    }

    //auxiliary method to allow user to enter flat's area
    private int addFlatArea() {
        String lineIn;
        int addArea = -1;
        do {
            System.out.println("Enter flat's area in square meters...");
            lineIn = scanner.nextLine();
            if (Utils.isInt(lineIn)) {
                addArea = Integer.valueOf(lineIn);
                if (addArea > 200) {
                    addArea = -1;
                    System.err.println("Unacceptable area, can't be more than 200 square meters.");
                }
            } else {
                System.err.println("Unaccepatble entry, a number is required.");
            }
        } while (!Utils.isInt(lineIn) || addArea < 0);
        return addArea;
    }

    //auxiliary method to allow user to enter the number of flat's rooms
    private int addFlatNrRooms() {
        String lineIn;
        int addNrRooms = -1;
        do {
            System.out.println("Enter the number of flat's rooms...");
            lineIn = scanner.nextLine();
            if (Utils.isInt(lineIn)) {
                addNrRooms = Integer.valueOf(lineIn);
                if (addNrRooms < 0 || addNrRooms > 8) {
                    System.err.println("Unacceptable entry, provide number of rooms between 0 and 8.");
                    addNrRooms = -1;
                    //continue here;
                    //break to the cycle's beginning doesn't work
                }
            } else {
                System.err.println("Unacceptable entry, provide number of rooms between 0 and 8.");
            }
        } while (!Utils.isInt(lineIn) || addNrRooms < 0);
        return addNrRooms;
    }

    //auxiliary method to allow user to enter whether the flat has a balcony
    private boolean addFlatBalcony() {
        String lineIn;
        boolean addBalcony = false;
        do {
            System.out.println("Please enter whether the flat has a balcony");
            lineIn = scanner.nextLine().toLowerCase();
            if (lineIn.equals("yes") || lineIn.equals("ja")) {
                addBalcony = true;
                break;
            } else if (lineIn.equals("no") || lineIn.equals("nein")) {
                addBalcony = false;
                break;
            } else {
                System.err.println("Unacceptable entry, please try again");
            }
        } while (true);
        return addBalcony;
    }

    //auxiliary method to allow user to grade the flat's furniture
    private Furnish addFlatFurniture() {
        String lineIn;
        Furnish furniture = null;
        do {
            System.out.println("If you wish, determine the room's furnishing.");
            System.out.println("yes/ja to continue, no/nein to skip");
            lineIn = scanner.nextLine().toLowerCase();
            if (lineIn.equals("yes") || lineIn.equals("ja")) {
                do {
                    System.out.println("Determine the level of furnishing:  ");
                    System.out.println("DESIGNER,\n" +
                            "    NONE,\n" +
                            "    BAD,\n" +
                            "    LITTLE");
                    lineIn = scanner.nextLine().toUpperCase();
                    switch (lineIn) {
                        case "DESIGNER":
                            return Furnish.DESIGNER;
                        case "NONE":
                            return Furnish.NONE;
                        case "BAD":
                            return Furnish.BAD;
                        case "LITTLE":
                            return Furnish.LITTLE;
                        default:
                            System.out.println("Unacceptable entry, please try again.");
                    }
                } while (true);
            } else if (lineIn.equals("no") || lineIn.equals("nein")) {
                return furniture;
            } else {
                System.err.println("Unacceptable entry, please try again.");
            }
        } while (true);
    }

    //auxiliary method to allow user to provide house's building year
    private int addHouseYear() {
        while (true) {
            System.out.println("Enter the house's building year:");
            String line = scanner.nextLine();
            if (!Utils.isInt(line)) {
                System.out.println("That's no number!");
                continue;
            }
            int year = Integer.parseInt(line);
            if (year < 2030 && year > 0) {
                return year;
            }
            System.out.println("Must be lower than 2030 and higher than 0!");
        }
    }

    //auxiliary method to allow user to provide house's name
    private String addHouseName() {
        while (true) {
            System.out.println("Please enter the house's name: ");
            String line = scanner.nextLine();
            if (!Utils.isString(line)) {
                System.out.println("That's an empty line!");
                continue;
            }
            return line;
        }
    }

    //SHOW THE LIST OF FLATS FILTERED BY BALCONY!
    public void filter_balcony() {
        System.out.println("Show all flats with or without balconies! \n " +
                "with / mit = with a balcony, without / ohne = without one.");
        String lineIn = scanner.nextLine().toLowerCase();
        if (lineIn.equals("with") || lineIn.equals("mit")) {
            System.out.println("Showing all flats with a balcony:");
            for (Flat flat : flats) {
                if (flat.isBalcony()) {
                    System.out.println(flat);
                }
            }
        } else if (lineIn.equals("without") || lineIn.equals("ohne")) {
            System.out.println("Showing all flats without a balcony:");
            for (Flat flat : flats) {
                if (!flat.isBalcony()) {
                    System.out.println(flat);
                }
            }
        } else {
            System.out.println("Unacceptable entry...");
        }
    }

    //CLEAR the list - with a safeguard against accidental clearing
    public void clear() {
        System.out.println("Delete all flats from the list!");
        System.out.println("Are you sure? The process is irreversible! Type 'ja' or 'yes' to confirm.");
        String lineIn = scanner.nextLine().toLowerCase();
        if (lineIn.equals("ja") || lineIn.equals("yes")) {
            flats.clear();
            System.out.println("All flats deleted");

        } else {
            System.out.println("List clearing aborted!");
        }
    }

    //SHOW HELP with the list of all commands
    public void help() {
        // Roman
        System.out.println("help: the list of all commands \n" +
                "info: provide information about our list of flats \n" +
                "show: show all flats in the list: \n" +
                "add: add new flat to the list \n" +
                "update_by_id {id}: update the flat with id {id} \n" +
                "remove_by_id {id}: remove the flat with id {id} from the list \n" +
                "clear: delete all flats from the list \n" +
                "exit: exit program \n" +
                "remove_head {head}: remove first flat fromt he list and show it \n" +
                "history: show the last 15 commands \n" +
                "filter_balcony: show all flats with/without balcony \n" +
                "print_ascending {print}: show the list of flats in ascending order");
    }

    //SHOW COMMAND HISTORY - last 15 commands or less
    public void history() {
        System.out.println("The last 15 commands were:");
        for (String str : commands) {
            System.out.println(str);
        }
    }

    //REMOVE THE FIRST ELEMENT AND SHOW IT
    public void remove_head() {
        System.out.println("Removing the first flat in the list!");
        System.out.println("This is what it was:");
        System.out.println(flats.remove(0));
    }

    //REMOVE A FLAT BY ID
    public void remove_by_id() {
        int index = -1;
        String argsIn;
        do {
            System.out.println("Please enter the ID of the apartment to be removed");
            argsIn = scanner.nextLine();
            if (!Utils.isLong(argsIn)) {
                System.err.println("Unacceptable entry, numbers required!");
            } else {
                break;
            }
        } while (true);
        System.out.println("Removing flat from the list by ID! ");
        long id = Long.valueOf(argsIn);
        for (int i = 0; i<flats.size(); i++) {
            if (flats.get(i).getId()==id) {
                index = i;
                break;
            }
        }
        if (index!=-1) {
            flats.remove(index);
            System.out.println("Flat with list index "+index+" removed from the list!");
        } else {
            System.out.println("No apartment with such ID found!");
        }
    }

    //SHOW ALL FLATS
    public void show() {
        //Sergej
        System.out.println("Showing all flats:");
        for (Flat flat : flats) {
            System.out.println(flat);
        }
    }
















    //UPDATE FLAT BY ID
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










    public void print_ascending() {
        System.out.println("вывести элементы коллекции в порядке возрастания! ");
    }



    public void startInfoCommand() { //startInfoCommand
        //Romam
        System.out.println("Здесь будет выданна Информация о коллекции!");
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


// и тут коментарий

}
