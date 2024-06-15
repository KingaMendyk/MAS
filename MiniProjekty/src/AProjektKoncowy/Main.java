package AProjektKoncowy;

import AProjektKoncowy.AnimalSpecies.Cat;
import AProjektKoncowy.AnimalSpecies.Dog;

public class Main {
    public static void main(String[] args) {
        //Zwierzęta
        Cat cat1 = new Cat("Mruczek", "2020-03-01");
        Cat cat2 = new Cat("Bonifacy", "2008-10-15");
        Dog dog1 = new Dog("Azor", "2018-09-08");
        Dog dog2 = new Dog("Burek", "2010-10-10");

        //Właściciele zwierząt
        AnimalOwner owner1 = new AnimalOwner("Adam", "Adamski");
        AnimalOwner owner2 = new AnimalOwner("Beata", "Beatska");
        AnimalOwner owner3 = new AnimalOwner("Cecylia", "Cecylska");

        //Pracownicy hotelu
        StaffWorker worker1 = new StaffWorker(0, "Daniel", "Danielski");
        StaffWorker worker2 = new StaffWorker(0, "Ewa", "Ewska");
        System.out.println(worker2);


        //Hotele
        Hotel hotel1 = new Hotel("Zwierzakowo Warszawa");
        Hotel hotel2 = new Hotel("Zwierzakowo Lublin");
        Hotel hotel3 = new Hotel("Zwierzakowo Wrocław");
    }
}
