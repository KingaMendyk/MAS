package MP03;

import java.io.Serializable;

public abstract class Person implements Serializable {
    protected String name;
    protected String surname;

    // Dziedziczenie overlapping za pomoca kompozycji
    private Owner owner;
    private Worker worker;


    public Person(String name, String surname, PersonType type) {
        this.name = name;
        this.surname = surname;

        switch(type){
            case Owner -> owner = new Owner(name, surname);
            case Worker -> worker = new Worker(Worker.getLatestId() + 1, name, surname);
            case Owner_Worker -> {
                owner = new Owner(name, surname);
                worker = new Worker(Worker.getLatestId() + 1, name, surname);
            }
        }
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getInfo(){
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
