import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //House house1 = new House("inSpanndau", 25);


        Flat[] initialFlats = new Flat[] {
                new Flat("One-room", 38,1, true),
                new Flat("Two-room", 45,2,false),
                new Flat("Three-room", 64,3,true),
                new Flat("Studio", 45,1,true),
                new Flat("Penthouse", 128,6,true),
                new Flat("Communal", 22,1,false),
                new Flat("Loft", 42, 1,true),
                new Flat("Apartments", 78, 4,true),
                new Flat("Two-room", 47,2,true),
                new Flat("Penthouse", 142,7,true),
                new Flat("Studio", 43,1,false),
                new Flat("Communal", 26,1,false),
                new Flat("One-room", 37,1, false),
                new Flat("Four-room", 75,4, true),
                new Flat("Loft", 40, 1,false)
        };
        //ввести массив квартир: введён

//        for (Flat f: initialFlats) {
//            System.out.println(f);
//        }

        //перевести массив в LinkedList через for цикл.
//Евгений
        List<Flat> flats = new LinkedList<>();

        for (Flat f: initialFlats) {
            flats.add(f);
        }

        Manager manager = new Manager();
        String name; // переменная для имени пользователя

        System.out.print(
                "Добро пожаловать в наше приложение Менеджер квартир!\n" +
                        "Введите Ваше имя: \n");

        name = manager.scanner.nextLine(); // считываем введенное пользователем значение имени

        System.out.print(name + ", " + "для Вас доступны следующие команды: \n"); // выводим это сообщение пользователю
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
                    manager.getHelp();
                    break;

                case "info":
                    manager.startInfoCommand();
                    break;

                case "show":
                    manager.getshow();
                    break;

                case "add":
                    manager.addCommand(flats);
                    break;

                case "update":
                    manager.update_by_id(argIn, flats);
                    break;

                case "remove":
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

                case "print_ascending":
                    manager.print_ascending();
                    break;

                default:
                    System.err.println("не верно задонноя строка");

            }
        } while (loopIsTrue);



    }
}
