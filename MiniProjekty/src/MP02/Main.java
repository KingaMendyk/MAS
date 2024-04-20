package MP02;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Mruczek", "2014-01-07", 7);
        Animal animal2 = new Animal("Burek", "2018-03-15", 10);
        Animal animal3 = new Animal("Robal", "2020-07-21", 5);

        Owner owner1 = new Owner("Adam", "Adamski");
        Owner owner2 = new Owner("Beata", "Beatska");

        //Asocjacja zwykła
        animal1.setOwner(owner1);
        animal2.setOwner(owner2);
        owner2.addAnimal(animal3);

        System.out.println("Animals for owner " + owner1);
        for(Animal animal : owner1.getAnimals()){
            System.out.println(animal);
        }

        System.out.println("\nAnimals for owner " + owner2);
        for(Animal animal : owner2.getAnimals()){
            System.out.println(animal);
        }

        //Asocjacja z atrybutem


        //Asocjacja kwalifikowana


        //Kompozycja

    }
}