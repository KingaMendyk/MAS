package MP04;

import java.io.Serializable;
import java.util.*;

public class Hotel implements Serializable {
    private static List<Hotel> allHotels = new ArrayList<>();

    private String name;
    private List<Room> rooms = new ArrayList<>();
    private static Set<Room> allRooms = new HashSet<>(); //Kompozycja
    private Map<Integer, Worker> workers = new TreeMap<>(); //Asocjacja kwalifikowana

    public Hotel(String name){
        this.name = name;
        addHotel(this);
    }

    private void addHotel(Hotel hotel){
        allHotels.add(hotel);
    }

    //Kompozycja
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

    //Asocjacja kwalifikowana
    public void addWorker(Worker worker) {
        if(!workers.containsKey(worker.getId())) {
            workers.put(worker.getId(), worker);
            worker.addHotel(this);
        }
    }

    public Worker findWorker(int id) {
        if(!workers.containsKey(id)) {
            System.out.println("Can't find worker with id: " + id + " in hotel " + name);
            return null;
        }
        return workers.get(id);
    }

    public void removeWorker(Worker worker){
        if(workers.containsKey(worker.getId())){
            workers.remove(worker.getId());
            worker.removeHotel();
        }
    }

    public Map<Integer, Worker> getWorkers(){
        return workers;
    }


    public String getName(){
        return name;
    }

    public List<Room> getRooms(){
        return rooms;
    }

    @Override
    public String toString(){
        StringBuilder roomString = new StringBuilder();
        if(!rooms.isEmpty()){
            for(Room room : rooms){
                roomString.append(room).append("\n");
            }
        }

        return "Hotel " + name + "\nRooms:\n" + roomString;
    }
}
