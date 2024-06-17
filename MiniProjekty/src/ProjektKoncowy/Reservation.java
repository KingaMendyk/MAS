package ProjektKoncowy;

import ProjektKoncowy.Enums.ReservationState;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation implements Serializable {
    private int id;
    private static List<Integer> allIds = new ArrayList<>();
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private ReservationState state;

    private AnimalOwner animalOwner;
    private Animal animal;
    private AnimalInRoom animalInRoom;
    private Room room;


    public Reservation(Room room, LocalDate dateFrom, LocalDate dateTo){
        setId();
        addRoom(room);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        changeState(ReservationState.InProgress);
    }

    public void addOwner(AnimalOwner owner){
        if(this.animalOwner != null)
            return;
        animalOwner = owner;
        animalOwner.addReservation(this);
    }

    public void addRoom(Room room){
        if(this.room != null)
            return;
        this.room = room;
        room.addReservation(this);
    }

    public void removeOwner(AnimalOwner owner){
        if(this.animalOwner == null)
            return;
        this.animalOwner = null;
        owner.removeReservation(this);
    }

    public void removeRoom(Room room){
        if(this.room == null)
            return;
        this.room = null;
        room.removeReservation(this);
    }

    private void setId(){
        if(allIds.isEmpty())
            this.id = 0;
        else
            this.id = allIds.get(allIds.size() - 1) + 1;
        allIds.add(id);
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        animalInRoom = new AnimalInRoom(animal, room);
        animal.addAnimalInRoom(animalInRoom);
        room.addAnimalInRoom(animalInRoom);
    }

    public void removeAnimal(Animal animal){
        this.animal = null;
        animal.removeAnimalInRoom(animalInRoom);
        room.removeAnimalInRoom(animalInRoom);
    }

    public ReservationState getState() {
        return state;
    }

    public AnimalOwner getAnimalOwner() {
        return animalOwner;
    }

    public Room getRoom() {
        return room;
    }

    public void changeState(ReservationState state){
        this.state = state;
    }

    public void save(){
        changeState(ReservationState.Accepted);
    }

    public void delete(){
        removeOwner(animalOwner);
        removeRoom(room);
        removeAnimal(animal);
        changeState(ReservationState.Cancelled);
    }

    @Override
    public String toString() {
        return "Rezerwacja " + id + " od: " + dateFrom + " do: " + dateTo
                + " hotel: " + getRoom().getHotel().getName()
                + " pokój: " + room.getRoomNumber()
                + " zwierzę: " + animal.getName()
                + " status: " + state;
    }
}
