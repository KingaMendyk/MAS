package AProjektKoncowy;

import AProjektKoncowy.Enums.PersonType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private static List<Person> allPeople = new ArrayList<>();

    protected String name;
    protected String surname;
    protected LocalDate dateOfBirth;
    protected String phoneNumber;
    private PersonType personType;

    private AnimalOwner owner;
    private Worker worker;

    protected Person(){

    }

    public Person(String name, String surname, PersonType personType){
        this.name = name;
        this.surname = surname;
        this.personType = personType;
        switch(personType){
            case Owner -> owner = new AnimalOwner(this);
            case Worker -> worker = new Worker(this);
            case OwnerWorker -> {
                owner = new AnimalOwner(this);
                worker = new Worker(this);
            }
        }

        addPerson(this);
    }

    private void addPerson(Person person){
        allPeople.add(person);
    }

    public int getAge(){
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return name + " " + surname + "(" + personType.toString() + ")";
    }
}
