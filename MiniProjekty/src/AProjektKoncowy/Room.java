package AProjektKoncowy;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private int size;
    private List<String> eqipment = new ArrayList<>();
    private Hotel hotel;

    private List<AnimalInRoom> animalInRoom = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<StaffWorker> assignedWorkers;

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

    public boolean isAvailable(LocalDate dateFrom, LocalDate dateTo){
        boolean available = true;
        for(Reservation reservation : getReservations()){
            LocalDate resDateFrom = reservation.getDateFrom();
            LocalDate resDateTo = reservation.getDateTo();

            if (dateFrom.isBefore(resDateFrom) || dateTo.isAfter(resDateTo)) {
                available = false;
                break;
            }
        }
        return available;
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

    public void assignWorker(StaffWorker worker){
        if(assignedWorkers.contains(worker))
            return;
        assignedWorkers.add(worker);
        worker.assignToRoom(this);
    }

    public void removeWorker(StaffWorker worker){
        if(!assignedWorkers.contains(worker))
            return;
        assignedWorkers.remove(worker);
        worker.removeFromRoom(this);
    }

    public void addReservation(Reservation reservation){
        if(reservations.contains(reservation))
            return;
        reservations.add(reservation);
        reservation.addRoom(this);
    }

    public void removeReservation(Reservation reservation){
        if(!reservations.contains(reservation))
            return;
        reservations.remove(reservation);
        reservation.removeRoom(this);
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


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<StaffWorker> getAssignedWorkers() {
        return assignedWorkers;
    }

    @Override
    public String toString() {
        return "Pokój numer: " + number ;
    }
}
