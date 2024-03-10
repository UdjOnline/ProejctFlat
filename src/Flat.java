public class Flat {

    private static int count = 1;

    private long id; //Значение поля должно быть больше 0,
    //Значение этого поля должно быть уникальным,
    //Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer area; //Поле может быть null, Значение поля должно быть больше 0
    private Integer numberOfRooms; //Максимальное значение поля: 8,
    //Значение поля должно быть больше 0
    private boolean balcony;
    private Furnish furnish; //Поле может быть null
    private House house; //Поле не может быть null

    public Flat(String name, Integer area, Integer numberOfRooms, boolean balcony) {
        this.id = 10115 * 100000 + Flat.count; //почтовый Индекс Берлина + счётсчик
        Flat.count++;

        this.name = name;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
    }       //Конструктор квартиры

    public long getId() {
        return id;
    }       //ID только смотреть, не переопредильть

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals(null)) {
            System.out.println("Поле не может быть NULL");
        } else if (name.equals("")) {
            System.out.println("Строка не может быть пустой");
        } else {
            this.name = name;
        }
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        if (area > 0) {
            this.area = area;
        } else {
            System.out.println("Значение поля должно быть больше 0");
        }
    } //

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        if (numberOfRooms > 0 && numberOfRooms < 9) {
            this.numberOfRooms = numberOfRooms;
            } else {
            System.out.println("Значение поля должно быть больше 0");
        }
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(String balcon) {
        if (balcon.equals("yes") || balcon.equals("ja")) {
            this.balcony = true;
        } else if (balcon.equals("no") || balcon.equals("nein")) {
            this.balcony = false;
        }else {
            System.out.println("неверное задание балкона");
        }
    }

    public Furnish getFurnish() {
        return furnish;
    }

//    public void setFurnish(Furnish furnish) {
//        this.furnish = furnish;
//    }

    public House getHouse() {
        return house;
    }

//    public void setHouse(House house) {
//        this.house = house;
//    }
//

    @Override
    public String toString() {
        return "Квартира {" +
                "id-Номер: " + id +
                ", название: " + name + '\'' +
                ", район: " + area +
                ", число комнат: " + numberOfRooms +
                ", наличие балкона: " + balcony +
                ", мебель: " + furnish +
                ", дом: " + house +
                '}';
    }
}
