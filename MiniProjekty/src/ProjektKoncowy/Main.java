package ProjektKoncowy;

import ProjektKoncowy.AnimalSpecies.Cat;
import ProjektKoncowy.AnimalSpecies.Dog;
import ProjektKoncowy.GUI.GUI;

import javax.swing.*;
import java.io.File;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        if(new File("animals.dat").isFile()){
            SaveHelper.readSession();
            SwingUtilities.invokeLater(() -> {new GUI(Person.getAllOwners().get(0));});
        }

        else {
            //Zwierzęta
            Cat cat1 = new Cat("Mruczek", "2020-03-01");
            Cat cat2 = new Cat("Bonifacy", "2008-10-15");
            Cat cat3 = new Cat("Śnieżka", "2021-02-05");
            Cat cat4 = new Cat("Klakier", "2009-10-15");
            Dog dog1 = new Dog("Azor", "2018-09-08");
            Dog dog2 = new Dog("Burek", "2010-10-10");
            Dog dog3 = new Dog("Kieł", "2009-09-08");
            Dog dog4 = new Dog("Burek", "2019-10-10");

            //Właściciele zwierząt
            AnimalOwner owner1 = new AnimalOwner("Adam", "Adamski");
            AnimalOwner owner2 = new AnimalOwner("Beata", "Beatska");
            AnimalOwner owner3 = new AnimalOwner("Cecylia", "Cecylska");

            //Pracownicy hotelu
            HotelManager manager1 = new HotelManager(0, "Daniel", "Danielski");
            HotelManager manager2 = new HotelManager(1, "Ewa", "Ewska");
            HotelManager manager3 = new HotelManager(2, "Felicja", "Feliksińska");
            StaffWorker worker1 = new StaffWorker(3, "Gaweł", "Gawski");
            StaffWorker worker2 = new StaffWorker(4, "Helena", "Heleńska");
            StaffWorker worker3 = new StaffWorker(5, "Ilona", "Ilońska");
            StaffWorker worker4 = new StaffWorker(6, "Jan", "Janek");
            StaffWorker worker5 = new StaffWorker(7, "Karol", "Karolowski");
            StaffWorker worker6 = new StaffWorker(8, "Lucy", "Lipska");
            StaffWorker worker7 = new StaffWorker(7, "Monika", "Monikska");
            StaffWorker worker8 = new StaffWorker(8, "Natan", "Natański");
            owner3.becomeWorker();


            //Hotele
            Hotel hotel1 = new Hotel("Zwierzakowo Warszawa", "Aleje Jerozolimskie 10, Warszawa");
            Hotel hotel2 = new Hotel("Zwierzakowo Lublin", "Jana Sawy 8, Lublin");
            Hotel hotel3 = new Hotel("Zwierzakowo Wrocław", "Krasnalska 17, Wrocław");

            //Pokoje
            Random random = new Random();
            String[] equipment = {"drapak", "leżak", "poduszki", "akwarium", "terrarium"};

            for (int i = 0; i < 4; i++) {
                Room room = Room.createRoom(hotel1, i + 1, random.nextInt(3) + 1);
                room.addRoomEquipment(equipment[random.nextInt(equipment.length)]);
            }

            for (int i = 0; i < 3; i++) {
                Room room = Room.createRoom(hotel2, i + 1, random.nextInt(3) + 1);
                room.addRoomEquipment(equipment[random.nextInt(equipment.length)]);
            }

            for (int i = 0; i < 5; i++) {
                Room room = Room.createRoom(hotel3, i + 1, random.nextInt(3) + 1);
                room.addRoomEquipment(equipment[random.nextInt(equipment.length)]);
            }

            //Przypisania
            //Właściciel-zwierzę
            owner1.addAnimal(cat1);
            owner1.addAnimal(cat2);
            owner1.addAnimal(dog2);

            owner2.addAnimal(cat3);
            owner2.addAnimal(cat4);

            owner3.addAnimal(dog1);
            owner3.addAnimal(dog3);
            owner3.addAnimal(dog4);

            //Pracownik-hotel
            hotel1.addWorker(manager1);
            hotel2.addWorker(manager2);
            hotel3.addWorker(manager3);

            hotel1.addWorker(worker1);
            hotel1.addWorker(worker2);
            hotel1.addWorker(worker3);
            hotel1.addWorker(worker4);

            hotel2.addWorker(worker5);
            hotel2.addWorker(worker6);

            hotel3.addWorker(worker7);
            hotel3.addWorker(worker8);

            //Pracownik - pokój
            worker1.assignToRoom(hotel1.getRooms().get(0));
            worker1.assignToRoom(hotel1.getRooms().get(1));
            worker1.assignToRoom(hotel1.getRooms().get(2));
            worker1.assignToRoom(hotel1.getRooms().get(3));

            SwingUtilities.invokeLater(() -> {new GUI(owner1);});
        }
    }
}
