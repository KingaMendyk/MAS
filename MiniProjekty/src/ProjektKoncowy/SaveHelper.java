package ProjektKoncowy;

public class SaveHelper {

    public static void saveSession(){
        Animal.saveToFile("animals.dat");
        Person.saveToFile("people.dat");
        Hotel.saveToFile("hotels.dat");
    }

    public static  void readSession(){
        Animal.readFromFile("animals.dat");
        Person.readFromFile("people.dat");
        Hotel.readFromFile("hotels.dat");
    }
}
