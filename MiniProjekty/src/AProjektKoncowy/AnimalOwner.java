package AProjektKoncowy;

import AProjektKoncowy.Enums.PersonType;

import java.util.ArrayList;
import java.util.List;

public class AnimalOwner extends Person {
    private List<Animal> animals = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private Person person;

    public AnimalOwner(String name, String surname){
        super(name, surname, PersonType.Owner);
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

    public void makeReservation(int roomId, Animal animal){
        //TODO
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

    public List<Animal> getAnimals(){
        return animals;
    }
}
