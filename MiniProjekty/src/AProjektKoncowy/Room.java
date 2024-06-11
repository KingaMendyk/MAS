package AProjektKoncowy;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private int size;
    private List<String> eqipment = new ArrayList<>();
    private boolean isAvailable;
    private Hotel hotel;

    private List<AnimalInRoom> animalInRoom = new ArrayList<>();

    private Room(Hotel hotel, int number, int size){
        this.number = number;
        this.size = size;
        this.hotel = hotel;
    }

    public static Room createRoom(Hotel hotel, int id, int number, int size){
        if(hotel == null){
            System.out.println("Hotel does not exist!");
            return null;
        }

        Room room = new Room(hotel, number, size);
        hotel.addRoom(room);

        return room;
    }

    public void addAnimalInRoom(AnimalInRoom animalRoom){
        if(!animalInRoom.contains(animalRoom)) {
            animalInRoom.add(animalRoom);
        }
    }

    public void removeAnimalInRoom(AnimalInRoom animalRoom){
        if(animalInRoom.contains(animalRoom)) {
            animalInRoom.remove(animalRoom);
            animalRoom.removeRoom(this);
        }
    }

    public static List<Room> getAvailableRooms(LocalDate dateFrom, LocalDate dateTo, Hotel hotel){
        return null; //TODO
    }

    public int getRoomNumber() {
        return number;
    }

    public void setRoomNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getEqipment() {
        return eqipment;
    }

    public void addRoomEquipment(String equipmentPiece){
        eqipment.add(equipmentPiece);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Pokój numer: " + number + (isAvailable ? " dostępny" : " niedostępny");
    }
}
