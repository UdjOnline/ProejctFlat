import java.util.Comparator;

public class Flat {

    private static int count = 1;

    private long id; //Field must be bigger than zero,
    //the value must be unique,
    //the value must be generated automatically
    private String name; //can't be null or empty
    private Integer area; //can't be null, must be bigger than zero
    private Integer numberOfRooms; //maximum value 8, must be bigger than zero
    private boolean balcony;
    private Furnish furnish; //CAN be null
    private House house; //can't be null

    //FLAT CONSTRUCTOR - with furniture
    public Flat(String name, Integer area, Integer numberOfRooms, boolean balcony, Furnish furnish, House house) {
        this.id = 10115 * 100000 + Flat.count; //Berlin postal index + counter
        Flat.count++;

        this.name = name;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
        this.furnish = furnish;
        this.house = house;
    }

//    //FLAT CONSTRUCTOR - without furniture
//    public Flat(String name, Integer area, Integer numberOfRooms, boolean balcony, House house) {
//        this.id = 10115 * 100000 + Flat.count; //Berlin postal index + counter
//        Flat.count++;
//
//        this.name = name;
//        this.area = area;
//        this.numberOfRooms = numberOfRooms;
//        this.balcony = balcony;
//        this.furnish = null;
//        this.house = house;
//    }


    //FLAT CONSTRUCTOR - for reading from a file
    public Flat(long id, String name, Integer area, Integer numberOfRooms, boolean balcony, Furnish furnish, House house) {

        this.id = id;
        this.name = name;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
        this.furnish = furnish;
        this.house = house;
    }

    @Override
    public String toString() {
        String p1 = "A flat " +
                "with id number " + id +
                ", named " + name + '\'' +
                ", " + area +
                " square meters, with " + numberOfRooms +
                " rooms.";
        String p2 = "";
        if (balcony) {
            p2 = " It has a balcony.";
        } else {
            p2 = " It has no balcony.";
        }
        String p3 = "";
        if (!(furnish == null))
            p3 = " This flat has "+furnish+" furnishing.";
        String p4 = "";
        if (!(house == null))
            p4 = house.toString();
        return p1+p2+p3+p4;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }       //ID can only be viewed, not edited

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
       this.house = house;
    }

}

class FlatAreaComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return f1.getArea()-f2.getArea();
    }
}

class FlatRoomNumberComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return f1.getNumberOfRooms()-f2.getNumberOfRooms();
    }
}

class FlatNameComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return f1.getName().compareTo(f2.getName());
    }
}
