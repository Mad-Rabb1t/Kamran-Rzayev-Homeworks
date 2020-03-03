package hw07;


public final class Woman extends Human {
    @Override
    public void greetPet(){
        System.out.println("Hey there, little friend!");
    }
    @Override
    public String toString() {
        return String.format("Woman{name='%s', surname='%s', year=%d, iq=%d}", super.name, super.surname, super.b_year, super.iq);
    }

    public void makeup() {
        System.out.println("Gonna look gorgeous today :) ");
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule, Family family){
        super(name, surname, year, iq, schedule, family);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule){
        super(name, surname, year, iq, schedule);
    }
}
