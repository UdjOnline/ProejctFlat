import java.io.*;
import java.util.*;


public class Manager {

    final String fileName = new String("src/flats.cvs");

    List<Flat> flats;
    LinkedList<String> commands;
    Scanner scanner;
    Utils util = new Utils();

    Date date;


    // MANAGER CONSTRUCTOR
    Manager() {
        flats = new LinkedList<>();
        commands = new LinkedList<>();
        scanner = new Scanner(System.in);
        date = new Date();
    }

    //ADD COMMAND to the command list (commands)
    public void addCommand(String lastCommand) {
        commands.add(lastCommand);
        if (commands.size() > 15) {
            commands.removeFirst();
        }
    }

    //ADD FLAT
    public void addFlat() {
        System.out.println("Add a new flat!");
        String addName = getFlatName();
        int addArea = getFlatArea();
        int addNrRooms = getFlatNrRooms();
        boolean addBalcony = getFlatBalcony();
        Furnish furniture = getFlatFurniture();
        House h1 = getHouse();
        //add new FLat
        Flat flat = new Flat(addName, addArea, addNrRooms, addBalcony, furniture, h1);
        flats.add(flat);
        System.out.println("Following flat has been added to the list:");
        System.out.println(flat);
    }

    //auxiliary method to allow user to enter flat's name
    private String getFlatName() {
        String flatName;
        do {
            System.out.println("Enter flat's name...");
            flatName = scanner.nextLine();
            if (flatName.equals("")) {
                System.err.println("Name can't be empty.");
            } else {
                return flatName;
            }
        } while (true);
    }

    //auxiliary method to allow user to enter flat's area
    private int getFlatArea() {
        String lineIn;
        int addArea = -1;
        do {
            System.out.println("Enter flat's area in square meters...");
            lineIn = scanner.nextLine();
            if (Utils.isInt(lineIn)) {
                addArea = Integer.valueOf(lineIn);
                if (addArea < 0 || addArea > 200) {
                    addArea = -1;
                    System.err.println("Unacceptable area, must be between 0 and 200 square meters.");
                }
                break;
            } else {
                System.err.println("Unacceptable entry, a number is required.");
            }
        } while (true);
        return addArea;
    }

    //auxiliary method to allow user to enter the number of flat's rooms
    private int getFlatNrRooms() {
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
                break;
            } else {
                System.err.println("Unacceptable entry, provide number of rooms between 0 and 8.");
            }
        } while (true);
        return addNrRooms;
    }

    //auxiliary method to allow user to enter whether the flat has a balcony
    private boolean getFlatBalcony() {
        String lineIn;
        boolean addBalcony = false;
        do {
            System.out.println("Please enter whether the flat has a balcony");
            System.out.println("yes/ja  or  no/nein");
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
    private Furnish getFlatFurniture() {
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
                            System.err.println("Unacceptable entry, please try again.");
                    }
                } while (true);
            } else if (lineIn.equals("no") || lineIn.equals("nein")) {
                return furniture;
            } else {
                System.err.println("Unacceptable entry, please try again.");
            }
        } while (true);
    }

    //auxiliary method to add a new House to a building
    private House getHouse() {
        House house = new House(getHouseName(), getHouseYear());
        return house;
    }

    //auxiliary method to allow user to provide house's building year
    private int getHouseYear() {
        while (true) {
            System.out.println("Enter the house's building year:");
            String line = scanner.nextLine();
            if (!Utils.isInt(line)) {
                System.err.println("That's no number!");
                continue;
            }
            int year = Integer.parseInt(line);
            if (year <= 2030 && year >= 0) {
                return year;
            }
            System.err.println("The year must be lower than 2030 and higher than 0!");
        }
    }

    //auxiliary method to allow user to provide house's name
    private String getHouseName() {
        while (true) {
            System.out.println("Please enter the house's name: ");
            String line = scanner.nextLine();
            if (!Utils.isString(line)) {
                System.err.println("That's an empty line!");
                continue;
            }
            return line;
        }
    }

    //CLEAR the list - with a safeguard against accidental clearing
    public void clear() {
        System.out.println("Delete all flats from the list!");
        System.err.println("Are you sure? The process is irreversible! Type 'ja' or 'yes' to confirm.");
        String lineIn = scanner.nextLine().toLowerCase();
        if (lineIn.equals("ja") || lineIn.equals("yes")) {
            flats.clear();
            System.out.println("All flats deleted");

        } else {
            System.err.println("List clearing aborted!");
        }
    }

    //SHOW THE LIST OF FLATS FILTERED BY BALCONY!
    public void filterBalcony() {
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
            System.err.println("Unacceptable entry...");
        }
    }

    //SHOW HELP with the list of all commands
    public void help() {
        // Roman
        System.out.println(
                "help: the list of all commands \n" +
                "info: provide information about this manager \n" +
                "show: show all flats in the list: \n" +
                "add: add new flat to the list \n" +
                "update : update the flat with id {id} \n" +
                "remove : remove the flat with id {id} from the list \n" +
                "clear: delete all flats from the list \n" +
                "exit: exit program \n" +
                "remove_head: remove first flat fromt he list and show it \n" +
                "history: show the last 15 commands \n" +
                "filter_balcony: show all flats with/without balcony \n" +
                "print_ascending: show the list of flats in ascending order\n" +
                "write: write the Data of the Flats into a file.\n" +
                "read: get the list of flats from file"
        );
    }

    //SHOW COMMAND HISTORY - last 15 commands or less
    public void history() {
        System.out.println("The last 15 commands were:");
        for (String str : commands) {
            System.out.println(str);
        }
    }

    //REMOVE THE FIRST ELEMENT AND SHOW IT
    public void removeHead() {
        System.out.println("Removing the first flat in the list!");
        System.out.println("This is what it was:");
        System.out.println(flats.remove(0));
    }

    //REMOVE A FLAT BY ID
    public void removeById(String args) {
        //read ID, find if it here is a flat with such id, return index
        int index = findListIndexByFlatID(args);
        if (index != -1) {
            flats.remove(index);
            System.out.println("Flat with ID " + args + " removed from the list!");
        } else {
            System.err.println("No apartment with such ID found!");
        }
    }

    //asks for a flat id, then looks which index does it have in flats List
    private int findListIndexByFlatID(String args) {
        int index = -1;
        //reading the id from the user
        if (!Utils.isLong(args)) {
            System.err.println("Unacceptable entry, numbers required!");
        } else {
            //searching got the flat with this ID and grabbing its index
            long id = Long.valueOf(args);
            for (int i = 0; i < flats.size(); i++) {
                if (flats.get(i).getId() == id) {
                    index = i;
                    break;
                }
            }
        }
        return index;
        //either normal index or -1 in case nothing was found
    }

    //SHOW ALL FLATS
    public void show() {
        //Sergej
        System.out.println("Showing all flats:");
        for (Flat flat : flats) {
            System.out.println(flat);
        }
    }

    //startInfoCommand
    public void startInfoCommand() {
        //Roman
        System.out.println("This FLAT MANAGER was initialized on " + this.date + ".");
        System.out.println("At the moment, the FLAT MANAGER has " + flats.size() + " of flats saved.");
        if (flats.size() < 10)
            System.out.println("Hardly impressive - but there is room for improvement");
        if (flats.size() >= 10)
            System.out.println("That's a lot of flats!");
        System.out.println("FLAT MANAGER is the result of collective effort by Team 1, Cohort 40_2 of AIT TR course.");
        System.out.println("- Sergej Schmidt");
        System.out.println("- Eugeny Davydov");
        System.out.println("- Roman Sheludko");
        System.out.println("If you have any suggestions and complaints, please let us know!");
        System.out.println("Our email is: we-dont-care-get-lost@gmail.com!");
        System.out.println("We eagerly await your feedback!");
    }


    //UPDATE FLAT BY ID
    public void updateById(String args) {
        //read ID, find if ithere is a flat with such id, return index
        int index = findListIndexByFlatID(args);
        //if no such flat - get out
        if (index == -1) {
            System.err.println("There is no flat with such ID!");
            return;
        }
        boolean looper = true;
        do {
            // ask for parameter to change
            System.out.println("Please let us know which parameter of the apartment do you wish to change.");
            System.out.println("Acceptable parameters are: \n" +
                    "name, \n" +
                    "area, \n" +
                    "rooms, \n" +
                    "balcony, \n" +
                    "furnish, \n" +
                    "house");
            System.out.println("Type 'done' if you wish to stop updating the apartment.");
            String lineIn = scanner.nextLine().toLowerCase();
            //switch case launching add-commands to read the values and apply them
            // to the flat with index [index]
            switch (lineIn) {
                case "name":
                    flats.get(index).setName(getFlatName());
                    System.out.println("Updated Flat:");
                    System.out.println(flats.get(index));
                    break;
                case "area":
                    flats.get(index).setArea(getFlatArea());
                    System.out.println("Updated Flat:");
                    System.out.println(flats.get(index));
                    break;
                case "rooms":
                    flats.get(index).setNumberOfRooms(getFlatNrRooms());
                    System.out.println("Updated Flat:");
                    System.out.println(flats.get(index));
                    break;
                case "balcony":
                    flats.get(index).setBalcony(getFlatBalcony());
                    System.out.println("Updated Flat:");
                    System.out.println(flats.get(index));
                    break;
                case "furnish":
                    flats.get(index).setFurnish(getFlatFurniture());
                    System.out.println("Updated Flat:");
                    System.out.println(flats.get(index));
                    break;
                case "house":
                    flats.get(index).setHouse(getHouse());
                    System.out.println("Updated Flat:");
                    System.out.println(flats.get(index));
                    break;
                case "done":
                    looper = false;
                    break;
                default:
                    System.err.println("Unacceptable entry!");
            }
        } while (looper);

    }

    public void printAscending() {
        boolean looper = true;
        do {
            // ask for parameter to change
            System.out.println("Please let us know by which parameter do you wish to sort the flats.");
            System.out.println("Acceptable parameters are: \n" +
                    "name, \n" +
                    "area, \n" +
                    "rooms (for the number of rooms)");
            String lineIn = scanner.nextLine().toLowerCase();
            //switch case chooses by which parameter the flats are sorted
            switch (lineIn) {
                case "name":
                    System.out.println("Flats sorted by name:");
                    FlatNameComparator compName = new FlatNameComparator();
                    Collections.sort(flats, compName);
                    show();
                    looper = false;
                    break;
                case "area":
                    System.out.println("Flats sorted by area:");
                    FlatAreaComparator compArea = new FlatAreaComparator();
                    Collections.sort(flats, compArea);
                    show();
                    looper = false;
                    break;
                case "rooms":
                    System.out.println("Flats sorted by number of rooms:");
                    FlatRoomNumberComparator compRoom = new FlatRoomNumberComparator();
                    Collections.sort(flats, compRoom);
                    show();
                    looper = false;
                    break;
                default:
                    System.err.println("Unacceptable entry! Try again:");
            }
        } while (looper);
    }

    //write the Data of the flat Array into a cvs file
    public void writeData() {
        try (FileWriter fw = new FileWriter(fileName)) {
            BufferedWriter bw = new BufferedWriter(fw);
            for (Flat flat : flats) {       //iteration through the list
                bw.write(flat.getId() + ","
                        + flat.getName() + ","
                        + flat.getArea() + ","
                        + flat.getNumberOfRooms() + ","
                        + flat.isBalcony() + ","
                        + flat.getFurnish() + ","
                        + flat.getHouse().getName() + ","
                        + flat.getHouse().getYear()); // all elements are separated by comma
                bw.newLine(); // new line
            }
            bw.flush();         //writing the rows from the buffer into a file
            System.out.println("Data of the Flat's List has been written to: " + fileName);
        } catch (IOException e) {
            System.err.print("An error has been appeared");
        }
    }

    public void readData() {
        String[] inputData = null;
        int i = 0;

        try (FileReader fr = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(fr);

            do {
                // reading by line
                String line = br.readLine();
                if (line == null) // finish, if reached the end of the file
                    break;
                // split the line into a data parts
                inputData = line.split(",");

                long id = Long.parseLong(inputData[0]);
                String name = inputData[1];
                int area = Integer.parseInt(inputData[2]);
                int numberOfRooms = Integer.parseInt(inputData[3]);
                boolean balcony = Boolean.parseBoolean(inputData[4]);
                //check Furnishing:
                Furnish furnish;
                switch (inputData[5]) {
                    case "DESIGNER":
                        furnish = Furnish.DESIGNER;
                        break;
                    case "LITTLE":
                        furnish = Furnish.LITTLE;
                        break;
                    case "BAD":
                        furnish = Furnish.BAD;
                        break;
                    default:
                        furnish = Furnish.NONE;

                }

                String houseName = inputData[6];
                int houseYear = Integer.parseInt(inputData[7]);
                House house = new House(houseName, houseYear);

                Flat newFlat = new Flat(id, name, area, numberOfRooms, balcony, furnish, house);

                flats.add(newFlat);
            } while (true);
            System.out.println("List of flats were reading succesfully");
        } catch (IOException e) {
            System.out.print("Ошибка ввода вывода");
        }

    }

    /*
    // these functions are not needed in current version of the manager
    // they were supposed to search for a house in the flats list by house's name
    // and create a new house if there was no house with such name
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

     */


}

