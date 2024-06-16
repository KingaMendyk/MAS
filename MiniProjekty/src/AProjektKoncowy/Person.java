package AProjektKoncowy;

import AProjektKoncowy.Enums.PersonType;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Serializable {
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
        addPerson(this);
    }

    public void becomeOwner(){
        if(!isOwner()) {
            this.owner = new AnimalOwner(this);
            if(personType == PersonType.Worker)
                personType = PersonType.OwnerWorker;
            else{
                personType = PersonType.Owner;
            }
        }
    }
    public void stopBeingOwner(){
        if(isOwner()) {
            this.owner.setPerson(null);
            this.owner = null;
            if(personType == PersonType.OwnerWorker)
                personType = PersonType.Worker;
            else{
                personType = null;
            }
        }
    }
    public void becomeWorker(){
        if(!isWorker()) {
            this.worker = new StaffWorker(this);
            if(personType == PersonType.Owner)
                personType = PersonType.OwnerWorker;
            else{
                personType = PersonType.Worker;
            }
        }
    }
    public void stopBeingWorker(){
        if(isWorker()){
            this.worker.setPerson(null);
            this.worker = null;
            if(personType == PersonType.OwnerWorker)
                personType = PersonType.Owner;
            else{
                personType = null;
            }
        }
    }
    public boolean isOwner(){
        return this.owner != null;
    }
    public boolean isWorker(){
        return this.worker != null;
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

    public AnimalOwner getOwner() {
        return owner;
    }

    public void setOwner(AnimalOwner owner) {
        this.owner = owner;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public static List<Person> getAllPeople() {
        return allPeople;
    }

    public static List<AnimalOwner> getAllOwners(){
        List<AnimalOwner> result = new ArrayList<>();
        for(Person p : allPeople){
            if(p.isOwner())
                result.add((AnimalOwner) p);
        }
        return result;
    }

    public static List<Worker> getAllWorkers(){
        List<Worker> result = new ArrayList<>();
        for(Person p : allPeople){
            if(p.isWorker())
                result.add((Worker)p);
        }

        return result;
    }

    @Override
    public String toString(){
        String basicString = name + " " + surname + " ("  + ")";
        String ownerString = "";
        String staffWorkerString = "";
        String managerString = "";

        switch(personType){
            case Owner -> ownerString = ", liczba zwierząt: " + owner.getAnimals().size();
            case Worker ->{
                switch(worker.getWorkerType()){
                    case StaffWorker -> staffWorkerString = ", liczba przypisanych pokoi: " + worker.getStaffWorker().getRoomCount();
                    case Manager -> managerString = ", kierownik hotelu " + worker.getHotel();
                }
            }
            case OwnerWorker ->{
                ownerString = ", liczba zwierząt: " + owner.getAnimals().size();
                switch(worker.getWorkerType()){
                    case StaffWorker -> staffWorkerString = ", liczba przypisanych pokoi: " + worker.getStaffWorker().getRoomCount();
                    case Manager -> managerString = ", kierownik hotelu " + worker.getHotel();
                }
            }
        }
        return basicString + ownerString + staffWorkerString + managerString;
    }

    //Ekstensja i trwałość
    private static void serializeAll(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allPeople);
    }

    private static void deserializeAll(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allPeople = (ArrayList<Person>) stream.readObject();
    }

    public static void saveToFile(String fileName){
        try {
            serializeAll(new ObjectOutputStream(new FileOutputStream(fileName)));
        } catch(IOException ex){
            System.out.println("Błąd podczas zapisywania pliku");
        }
    }

    public static void readFromFile(String fileName){
        try {
            deserializeAll(new ObjectInputStream(new FileInputStream(fileName)));
        } catch(IOException ex) {
            System.out.println("Błąd podczas wczytywania pliku");
        } catch(ClassNotFoundException ex) {
            System.out.println("Klasa nie znaleziona");
        }
    }
}
