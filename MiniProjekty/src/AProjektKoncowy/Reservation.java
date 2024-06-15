package AProjektKoncowy;

import AProjektKoncowy.Enums.ReservationState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int id;
    private List<Integer> allIds = new ArrayList<>();
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private ReservationState state;

    private AnimalOwner animalOwner;
    private Room room;


    public Reservation(){
        setId();
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
        this.id = allIds.get(allIds.size() - 1) + 1;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void changeState(ReservationState state){
        this.state = state;
    }

    public void save(){

    }

    public void delete(){

    }
}
