package MP01;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable {
    private static List<Animal> allAnimals = new ArrayList<Animal>(); //Ekstensja

    private String name;
    private LocalDate birthDate; //Atr. złożony
    private double weight; //Atr. opcjonalny
    private List<Owner> owners = new ArrayList<Owner>(); //Atr. powt. //Atr. złożony
    private int age;/* { //Atr. pochodny
        get {
        DateTime today = DateTime.Today;
        int age = today.Year - birthDate.Year;
        if (birthDate.AddYears(age) > today)
            age--;
        return age;
        }
    }
    */
    private static int minSeniorAge = 10; //Atr. klasowy
    private boolean IsSenior; // => age >= _minSeniorAge;

    public Animal(String name) {
        this.name = name;
        birthDate = LocalDate.now();
        addAnimal(this);
    }

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        addAnimal(this);
    }
    public Animal(String name, String birthDate, double weight) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        this.weight = weight;
        addAnimal(this);
    }

    public Animal(String name, double weight) {
        this.name = name;
        birthDate = LocalDate.now();
        this.weight = weight;
        addAnimal(this);
    }

    private static void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(String date) {
        birthDate = LocalDate.parse(date);
    }

    public void setWeight(double value) {
        weight = value;
    }

    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public static void showAnimals() {//Met. klasowa
        System.out.println("All animals: ");
        for(Animal animal : allAnimals) {
            System.out.println(animal);
        }
    }

    public static List<Animal> getSeniorAnimals() { //Met. klasowa
        List<Animal> seniors = new ArrayList<Animal>();
        for(Animal animal : allAnimals) {
            if (animal.IsSenior) {
                seniors.add(animal);
            }
        }
        return seniors;
    }

    @Override
    public String toString() { //Przesłonięcie
        StringBuilder ownersString = new StringBuilder();
        for(Owner owner : owners) {
            ownersString.append(owner.toString());
        }
        return name + " { age: " + age + ", weight: " + (weight == 0 ? "unknown" : weight)
                + ", senior: " + (IsSenior ? "yes" : "no" )+ ", owners: " + ownersString + " }";
    }

    //Ekst. - trwałość
    public static void serializeAll(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allAnimals);
    }

    public static void deserializeAll(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allAnimals = (ArrayList<Animal>) stream.readObject();
    }

    public static void saveToFile(String fileName){
        try {
            serializeAll(new ObjectOutputStream(new FileOutputStream(fileName)));
        } catch(IOException ex){
            System.out.println("No such file or directory");
        }
    }

    public static void readFromFile(String fileName){
        try {
            deserializeAll(new ObjectInputStream(new FileInputStream(fileName)));
        } catch(IOException ex) {
            System.out.println("No such file or directory");
        } catch(ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
    }
}
