public class Main {
    public static void main(String[] args) {

        //Initialize manager.
        Manager manager = new Manager();


        //data for manager testing
        House[] house = {
                new House("Hrushevka", 1974),
                new House("Monolithic", 1900),
                new House("Brick", 2010),
                new House("Townhouse",2008),
        };

        Flat[] initialFlats = new Flat[]{
                new Flat("One-room", 38, 1, true, Furnish.NONE, house[0]),
                new Flat("Two-room", 45, 2, false, Furnish.NONE, house[0]),
                new Flat("Three-room", 64, 3, true, Furnish.LITTLE , house[0]),
                new Flat("Studio", 45, 1, true, Furnish.NONE, house[0]),
                new Flat("Penthouse", 128, 6, true, Furnish.NONE, house[1]),
                new Flat("Communal", 22, 1, false, Furnish.NONE, house[1]),
                new Flat("Loft", 42, 1, true, Furnish.NONE, house[1]),
                new Flat("Apartments", 78, 4, true, Furnish.DESIGNER , house[2]),
                new Flat("Two-room", 47, 2, true, Furnish.NONE, house[2]),
                new Flat("Penthouse", 142, 7, true, Furnish.NONE, house[2]),
                new Flat("Studio", 43, 1, false, Furnish.NONE, house[2]),
                new Flat("Communal", 26, 1, false, Furnish.NONE, house[3]),
                new Flat("One-room", 37, 1, false, Furnish.NONE, house[3]),
                new Flat("Four-room", 75, 4, true, Furnish.NONE, house[3]),
                new Flat("Loft", 40, 1, false, Furnish.NONE , house[3])
        };


        //add new flats to manager
        for (Flat f: initialFlats)    {
            manager.flats.add(f);
        }


//        //create a list of Flats from a file:
//        manager.readData();

        // save user name
        String userName;
        System.out.print(
                "Welcome to our FLAT MANAGER!\n" +
                        "Please enter your name: \n");
        // read user name
        userName = manager.scanner.nextLine();
        manager.addCommand(userName);
        //provide user with help
        System.out.print(userName + ", " + "following commands are available to your: \n");
        manager.help(); // showing commands list immediately

        //variable to stop the loop
        boolean loopIsTrue = true;

        do {
            //reading new command
            System.out.println("\n \nPlease type in what you need...");
            String[] lineInParts = null;
            String argIn = null;
            String lineIn = manager.scanner.nextLine();

            if (lineIn.contains(" ")) {
                 lineInParts = lineIn.split(" ");
            }

            if (lineInParts != null && lineInParts.length == 2) {
                lineIn = lineInParts[0];
                argIn = lineInParts[1];
            }
            //switch between possible commands
            switch (lineIn) {
                case "exit":
                    System.out.println("See you next time! Good Bye");
                    loopIsTrue = false;
                    break;

                case "help":
                    manager.addCommand(lineIn);
                    manager.help();
                    break;

                case "info":
                    manager.addCommand(lineIn);
                    manager.startInfoCommand();
                    break;

                case "show":
                    manager.addCommand(lineIn);
                    manager.show();
                    break;

                case "add":
                    manager.addCommand(lineIn);
                    manager.addFlat();
                    break;

                case "update":
                    manager.addCommand(lineIn);
                    manager.updateById(argIn);
                    break;

                case "remove":
                    manager.addCommand(lineIn);
                    manager.removeById(argIn);
                    break;

                case "clear":
                    manager.addCommand(lineIn);
                    manager.clear();
                    break;

                case "remove_head":
                    manager.addCommand(lineIn);
                    manager.removeHead();
                    break;

                case "history":
                    manager.addCommand(lineIn);
                    manager.history();
                    break;

                case "filter_balcony":
                    manager.addCommand(lineIn);
                    manager.filterBalcony();
                    break;

                case "print_ascending":
                    manager.addCommand(lineIn);
                    manager.printAscending();
                    break;

                case "write":
                    manager.addCommand(lineIn);
                    manager.writeData();
                    break;

                case "read":
                    manager.addCommand(lineIn);
                    manager.writeData();
                    break;

                default:
                    System.err.println("Unacceptable input!");

            }
        } while (loopIsTrue);

    }
}

// Here was Karl