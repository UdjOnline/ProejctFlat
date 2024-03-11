public class House {
    private String name; //Поле не может быть null
    private int year; //Максимальное значение поля: 901, Значение поля должно быть больше 0

    public String getName() {
        return name;
    }

    public House(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void setName(String name) {
        if (this.name.equals(null)) {
            System.out.println("Поле не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0 || year > 2030) {
            System.out.println("неверно заданный возраст дома");
        } else {
            this.year = year;
        }   // Реалисацию надо улутьшить на пример на год построики
    }

    @Override
    public String toString() {
        return "Дом " + this.name + " с возрастом:  " + this.year ;
    }
}
