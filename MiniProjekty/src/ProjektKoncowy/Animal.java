package ProjektKoncowy;

import ProjektKoncowy.AnimalTypes.AnimalType;
import ProjektKoncowy.AnimalTypes.LandAnimal;
import ProjektKoncowy.AnimalTypes.WaterAnimal;
import ProjektKoncowy.AnimalTypes.WaterLandAnimal;
import ProjektKoncowy.Enums.AnimalTypeEnum;


import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable{
    private static List<Animal> allAnimals = new ArrayList<>();

    protected String name;
    protected LocalDate dateOfBirth;
    protected Double weight;
    protected static int minSeniorAge;

    private AnimalType animalType;

    private AnimalOwner owner;
    private List<AnimalInRoom> animalInRoom = new ArrayList<>();

    public Animal(String name, String dateOfBirth){
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        addAnimal(this);
    }

    public Animal(String name, String dateOfBirth, Double weight){
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.weight = weight;
        addAnimal(this);
    }

    public Animal(String name, AnimalTypeEnum animalType) {
        this.name = name;
        dateOfBirth = LocalDate.now();
        addAnimal(this);
        switch (animalType) {
            case Land -> this.animalType = new LandAnimal(this);
            case Water -> this.animalType = new WaterAnimal(this);
            case WaterLand -> this.animalType = new WaterLandAnimal(this);
            default -> this.animalType = null;
        }
    }

    private static void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }

    public void setOwner(AnimalOwner owner) {
        if(this.owner == null){
            this.owner = owner;
            owner.addAnimal(this);
        }
    }

    public void removeOwner(){
        if(owner != null){
            owner.removeAnimal(this);
            owner = null;
        }
    }

    public void addAnimalInRoom(AnimalInRoom animalRoom) {
        if(!animalInRoom.contains(animalRoom)) {
            animalInRoom.add(animalRoom);
        }
    }
    public void removeAnimalInRoom(AnimalInRoom animalRoom){
        if(animalInRoom.contains(animalRoom)) {
            animalInRoom.remove(animalRoom);
            animalRoom.removeAnimal(this);
        }
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static int getMinSeniorAge() {
        return minSeniorAge;
    }

    public static void setMinSeniorAge(int minSeniorAge) {
        Animal.minSeniorAge = minSeniorAge;
    }

    public boolean isSenior(){
        return getAge() >= minSeniorAge;
    }

    public AnimalOwner getOwner() {
        return owner;
    }

    public static List<Animal> getAllAnimals() {
        return allAnimals;
    }

    public String getInfo(){
        return this.toString();
    }

    @Override
    public String toString(){
        return name + " wiek: " + getAge() + " waga: " + (getWeight() == null ? "brak" : getWeight());
    }

    //Ekstensja i trwałość
    private static void serializeAll(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allAnimals);
    }

    private static void deserializeAll(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allAnimals = (ArrayList<Animal>) stream.readObject();
    }

    public static void saveToFile(String fileName){
        try {
            serializeAll(new ObjectOutputStream(new FileOutputStream(fileName)));
        } catch(IOException ex){
            System.out.println("Błąd podczas zapisywania pliku\n");
            ex.printStackTrace();
        }
    }

    public static void readFromFile(String fileName){
        try {
            deserializeAll(new ObjectInputStream(new FileInputStream(fileName)));
        } catch(IOException ex) {
            System.out.println("Błąd podczas wczytywania pliku\n");
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            System.out.println("Klasa nie znaleziona\n");
            ex.printStackTrace();
        }
    }
}
