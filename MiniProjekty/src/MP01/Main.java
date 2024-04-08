package MP01;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Miauczur");
        Animal animal2 = new Animal("Burek", "06-02-2010");
        Animal animal3 = new Animal("Tofi", "10-12-2016", 15);
        Animal animal4 = new Animal("Mruczek", "07-08-2020", 10);

        System.out.println("Seniors:");
        for(Animal animal : Animal.getSeniorAnimals())
        {
            System.out.println(animal);
        }
        System.out.println();;

        animal1.setBirthDate("12.05.2020");
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
        Animal.serializeAll("animals.dat");
        System.out.println("\nAfter serialization:");
        Animal.deserializeAll("animals.dat");
        Animal.showAnimals();
    }
}