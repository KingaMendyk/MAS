package MP05;


import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private int number;
    private int size;
    private Hotel hotel; //Kompozycja
    private List<AnimalRoom> animalInRoom = new ArrayList<>(); //Asocjacja z atrybutem

    private Room(Hotel hotel, int id, int number, int size){
        this.id = id;
        this.number = number;
        this.size = size;
        this.hotel = hotel;
    }

    //Kompozycja
    public static Room createRoom(Hotel hotel, int id, int number, int size){
        if(hotel == null){
            System.out.println("Hotel does not exist!");
            return null;
        }

        Room room = new Room(hotel, id, number, size);
        hotel.addRoom(room);

        return room;
    }

    //Asocjacja z atrybutem
    public void addAnimalRoom(AnimalRoom animalRoom){
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

    public List<AnimalRoom> getAnimalInRoom(){
        return animalInRoom;
    }

    public Hotel getHotel(){
        return hotel;
    }

    @Override
    public String toString() {
        return "Room { " + "id: " + id + ", number: " + number + ", size: " + size + " }";
    }
}
