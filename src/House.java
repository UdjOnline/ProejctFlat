public class House {
    private String name; //can't be null
    private int year; //between 0 and 2030

    //Constructor
    public House(String name, int year) {
        this.name = name;
        this.year = year;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return " The house is named " + this.name + " and it was built in  " + this.year+"." ;
    }
}
