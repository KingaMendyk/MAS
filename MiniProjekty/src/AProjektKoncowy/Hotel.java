package AProjektKoncowy;


import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private static List<Hotel> allHotels = new ArrayList<>();
    private String name;
    private String address;
    private List<Room> rooms = new ArrayList<>();
    private static Set<Room> allRooms = new HashSet<>(); //Kompozycja
    private Map<Integer, Worker> workers = new HashMap<>();

    public Hotel(String name){
        this.name = name;
        addHotel(this);
    }

    private void addHotel(Hotel hotel){
        allHotels.add(hotel);
    }

    public void addRoom(Room room){
        if(!rooms.contains(room)) {
            if (allRooms.contains(room)) {
                System.out.println("Room already exists in hotel " + room.getHotel().getName());
                return;
            }

            rooms.add(room);
            allRooms.add(room);
        }
    }

    public void removeRoom(Room room){
        if(rooms.contains(room)){
            rooms.remove(room);
            allRooms.remove(room);
        }
    }

    public void addWorker(Worker worker) {
        if(!workers.containsKey(worker.getId())) {
            workers.put(worker.getId(), worker);
            worker.addHotel(this);
        }
    }

    public void removeWorker(Worker worker){
        if(workers.containsKey(worker.getId())){
            workers.remove(worker.getId());
            worker.removeHotel();
        }
    }

    public static List<Hotel> getAllHotels() {
        return allHotels;
    }

    public List<Room> getAvailableRooms(LocalDate dateFrom, LocalDate dateTo){
        List<Room> result = new ArrayList<>();
        for(Room room : rooms){
            if(room.isAvailable(dateFrom, dateTo))
                result.add(room);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Map<Integer, Worker> getWorkers() {
        return workers;
    }

    @Override
    public String toString(){
        return "Hotel " + name + " adres: " + address + " liczba pokoi: " + rooms.size();
    }
}
