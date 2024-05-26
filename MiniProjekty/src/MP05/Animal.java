package MP05;


import javax.persistence.*;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Animal")
@Embeddable
public abstract class Animal implements Serializable {
    private static List<Animal> allAnimals = new ArrayList<>(); //Ekstensja

    private String name;
    private LocalDate birthDate; //Atr. złożony
    private Double weight;  //Atr. opcjonalny
    private Owner owner; //Atr. złożony //Asocjacja zwykła
    private static double minSeniorAge; //Atr. klasowy
    private List<AnimalRoom> animalInRoom = new ArrayList<>(); //Asocjacja z atrybutem

    private Room room;

    protected double foodAmount;
    @Id
    private Long id;

    public Animal() {

    }

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

    public abstract void feed();

    public double getFoodAmount() {
        return foodAmount;
    }

    private static void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }

    public void setOwner(Owner owner) {
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

    //Asocjacja z atrybutem
    public void addAnimalRoom(AnimalRoom animalRoom)
    {
        if(!animalInRoom.contains(animalRoom)) {
            animalInRoom.add(animalRoom);
        }
    }
    public void removeAnimalRoom(AnimalRoom animalRoom){
        if(animalInRoom.contains(animalRoom)) {
            animalInRoom.remove(animalRoom);
            animalRoom.remove(this);
        }
    }

    @ElementCollection
    public List<AnimalRoom> getAnimalInRoom(){
        return animalInRoom;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    @Transient
    public int getAge() { //Atr. pochodny
        int age = (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        return age;
    }

    @Transient
    public int getAge(String param){ //Przeciążenie
        switch (param) {
            case "months" -> {
                int months = (int) ChronoUnit.MONTHS.between(birthDate, LocalDate.now());
                return months;
            }
            case "days" -> {
                int days = (int) ChronoUnit.DAYS.between(birthDate, LocalDate.now());
                return days;
            }
            default -> {
                return getAge();
            }
        }
    }

    @Transient
    public boolean getIsSenior(){ //Atr. pochodny
        return getAge() >= minSeniorAge;
    }

    @ManyToOne
    public Owner getOwner() {
        return owner;
    }


    public void setBirthDate(String date) {
        birthDate = LocalDate.parse(date);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void setMinSeniorAge(double minAge){
        minSeniorAge = minAge;
    }

    public static List<Animal> getAllAnimals(){
        return allAnimals;
    }

    public static void showAnimals() {//Met. klasowa
        System.out.println("All animals: ");
        for(Animal animal : allAnimals) {
            System.out.println(animal);
        }
    }

    public static List<Animal> getSeniorAnimals() { //Met. klasowa
        List<Animal> seniors = new ArrayList<>();
        for(Animal animal : allAnimals) {
            if (animal.getIsSenior()) {
                seniors.add(animal);
            }
        }
        return seniors;
    }

    @Override
    public String toString() { //Przesłonięcie
        return name + " { age: " + getAge() + ", weight: " + (getWeight() == null ? "unknown" : weight)
                + ", senior: " + (getIsSenior() ? "yes" : "no" )+ ", owners: " + (owner == null ? "no owner" : owner.getName() + " " + owner.getSurname()) + " }";
    }

    //Ekst. - trwałość
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
            System.out.println("Error while saving to file");
        }
    }

    public static void readFromFile(String fileName){
        try {
            deserializeAll(new ObjectInputStream(new FileInputStream(fileName)));
        } catch(IOException ex) {
            System.out.println("Error while reading from file");
        } catch(ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
