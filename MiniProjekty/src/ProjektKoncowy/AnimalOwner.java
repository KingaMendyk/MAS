package ProjektKoncowy;

import ProjektKoncowy.Enums.PersonType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalOwner extends Person {
    private List<Animal> animals = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private Person person;

    public AnimalOwner(String name, String surname){
        super(name, surname, PersonType.Owner);
        setOwner(this);
    }

    protected AnimalOwner(Person person){
        this.person = person;
    }

    public void addAnimal(Animal animal){
        if(!animals.contains(animal)){
            animals.add(animal);
            animal.setOwner(this);
        }
    }

    public void removeAnimal(Animal animal){
        if(animals.contains(animal)){
            animals.remove(animal);
            animal.removeOwner();
        }
    }

    public void makeReservation(Room room, String dateFrom, String dateTo){
        Reservation reservation = new Reservation(room, LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
        reservation.addOwner(this);
    }

    public void addReservation(Reservation reservation){
        if(reservations.contains(reservation))
            return;
        reservations.add(reservation);
        reservation.addOwner(this);
    }

    public void removeReservation(Reservation reservation){
        if(!reservations.contains(reservation))
            return;
        reservations.remove(reservation);
        reservation.removeOwner(this);
    }

    public Reservation getLatestReservation(){
        return reservations.get(reservations.size() - 1);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
