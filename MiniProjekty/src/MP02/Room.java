package MP02;

public class Room {
    private int id;
    private int number;
    private int size;
    private Hotel hotel;

    private Room(Hotel hotel, int id, int number, int size){
        this.id = id;
        this.number = number;
        this.size = size;
        this.hotel = hotel;
    }

    public static Room createRoom(Hotel hotel, int id, int number, int size){
        if(hotel == null){
            System.out.println("Hotel does not exist!");
        }

        Room room = new Room(hotel, id, number, size);
        hotel.addRoom(room);

        return room;
    }

    @Override
    public String toString() {
        return "Room { " + "id: " + id + ", number: " + number + ", size: " + size + " }";
    }
}
