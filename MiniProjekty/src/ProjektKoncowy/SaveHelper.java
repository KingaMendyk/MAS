package ProjektKoncowy;

public class SaveHelper {

    public static void saveSession(){
        Animal.saveToFile("files/animals.dat");
        Person.saveToFile("files/people.dat");
        Hotel.saveToFile("files/hotels.dat");
    }

    public static  void readSession(){
        Animal.readFromFile("files/animals.dat");
        Person.readFromFile("files/people.dat");
        Hotel.readFromFile("files/hotels.dat");
    }
}
