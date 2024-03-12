public class Main {
    public static void main(String[] args) {

        //House house1 = new House("inSpanndau", 25);

        House[] house = {
                new House("Hrushevka", 1974),
                new House("Monolithic", 1900),
                new House("Brick", 2010),
                new House("Townhouse",2008),
        };

        Flat[] initialFlats = new Flat[]{
                new Flat("One-room", 38, 1, true, house[0]),
                new Flat("Two-room", 45, 2, false, house[0]),
                new Flat("Three-room", 64, 3, true, house[0]),
                new Flat("Studio", 45, 1, true, house[0]),
                new Flat("Penthouse", 128, 6, true, house[1]),
                new Flat("Communal", 22, 1, false, house[1]),
                new Flat("Loft", 42, 1, true, house[1]),
                new Flat("Apartments", 78, 4, true, house[2]),
                new Flat("Two-room", 47, 2, true, house[2]),
                new Flat("Penthouse", 142, 7, true, house[2]),
                new Flat("Studio", 43, 1, false, house[2]),
                new Flat("Communal", 26, 1, false, house[3]),
                new Flat("One-room", 37, 1, false, house[3]),
                new Flat("Four-room", 75, 4, true, house[3]),
                new Flat("Loft", 40, 1, false, house[3])
        };
        //ввести массив квартир: введён


        //перевести массив в LinkedList через for цикл.
        Manager manager = new Manager();

        for (Flat f: initialFlats)    {
            manager.flats.add(f);
        }

                String userName; // переменная для имени пользователя

        System.out.print(
                "Добро пожаловать в наше приложение Менеджер квартир!\n" +
                        "Введите Ваше имя: \n");

        userName = manager.scanner.nextLine(); // считываем введенное пользователем значение имени
        manager.addCommand(userName);

        System.out.print(userName + ", " + "для Вас доступны следующие команды: \n"); // выводим это сообщение пользователю
        manager.getHelp(); // сразу выдаётся информация о объектах

        boolean loopIsTrue = true;


        do {
            manager.getIntro();
            String[] lineInParts = null;
            String argIn = null;
            String lineIn = manager.scanner.nextLine();
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
                    manager.addCommand(lineIn);
                    manager.getHelp();
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
                    manager.update_by_id(argIn);
                    break;

                case "remove":
                    manager.addCommand(lineIn);
                    manager.remove_by_id(argIn);
                    break;

                case "clear":
                    manager.addCommand(lineIn);
                    manager.clear();
                    break;

                case "remove_head":
                    manager.addCommand(lineIn);
                    manager.remove_head();
                    break;

                case "history":
                    manager.addCommand(lineIn);
                    manager.history();
                    break;

                case "filter_balcony":
                    manager.addCommand(lineIn);
                    manager.filter_balcony();
                    break;

                case "print_ascending":
                    manager.addCommand(lineIn);
                    manager.print_ascending();
                    break;

                default:
                    System.err.println("не верно задонноя строка");

            }
        } while (loopIsTrue);

    }
}

// Here was Karl