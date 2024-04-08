package MP01;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Miauczur");
        Animal animal2 = new Animal("Burek", "2019-03-10");
        Animal animal3 = new Animal("Tofi", "2020-02-06", 15);
        Animal animal4 = new Animal("Mruczek", "2014-01-07", 10);

        System.out.println("Seniors:");
        for(Animal animal : Animal.getSeniorAnimals())
        {
            System.out.println(animal);
        }
        System.out.println();;

        animal1.setBirthDate("2020-05-12");
        animal1.setWeight(12);
        Animal.showAnimals();

        Owner owner = new Owner("Adam", "Adamski");
        animal2.addOwner(owner);
        System.out.println("\nOwners for animal " + animal2.getName());
        for(Owner o : animal2.getOwners())
        {
            System.out.println(o);
        }

        System.out.println("\nBefore Serialization:");
        Animal.showAnimals();

        Animal.saveToFile("animals.dat");
        Animal.readFromFile("animals.dat");

        System.out.println("\nAfter serialization:");
        Animal.showAnimals();
    }
}