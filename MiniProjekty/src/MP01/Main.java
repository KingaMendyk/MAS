package MP01;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Miauczur");
        Animal animal2 = new Animal("Burek", "2019-03-10");
        Animal animal3 = new Animal("Tofi", "2020-02-06", 15);
        Animal animal4 = new Animal("Mruczek", "2014-01-07", 10);

        Owner owner1 = new Owner("Adam", "Adamski");
        Owner owner2 = new Owner("Beata", "Beatska");

        //Nadanie wartości atrybutom data urodzenia i waga
        animal1.setBirthDate("2020-05-12");
        animal1.setWeight(12); //Atr. opcjonalny
        Animal.showAnimals();

        //Dodanie właścicieli
        animal2.addOwner(owner1); //Atr. powt. //Atr. złożony
        System.out.println("\nOwners for animal " + animal2.getName() +":");
        for(Owner o : animal2.getOwners())
        {
            System.out.println(o);
        }

        animal3.addOwner(owner1); //Atr. powt. //Atr. złożony
        animal3.addOwner(owner2); //Atr. powt. //Atr. złożony
        System.out.println("\nOwners for animal " + animal3.getName() + ":");
        for(Owner o : animal3.getOwners())
        {
            System.out.println(o);
        }

        Animal.setMinSeniorAge(10); //Atr. klasowy
        System.out.println("\nSeniors:");
        for(Animal animal : Animal.getSeniorAnimals()) //Met. klasowa
        {
            System.out.println(animal);
        }

        Animal.setMinSeniorAge(5); //Atr. klasowy
        System.out.println("\nSeniors after changing minimal senior age:");
        for(Animal animal : Animal.getSeniorAnimals()) //Met. klasowa
        {
            System.out.println(animal);
        }

        //Serializacja
        System.out.println("\nBefore Serialization:");
        Animal.showAnimals();

        Animal.saveToFile("animals.dat");
        Animal.readFromFile("animals.dat");

        System.out.println("\nAfter serialization:");
        Animal.showAnimals();
    }
}