package ProjektKoncowy.AnimalTypes;

import ProjektKoncowy.Animal;
import ProjektKoncowy.Enums.ShelterType;

public class LandAnimal extends AnimalType{
    private double walkSpeed;
    private ShelterType shelterType;

    public LandAnimal(Animal animal) {
        super(animal);
    }

    public double getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(double walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public ShelterType getShelterType() {
        return shelterType;
    }

    public void setShelterType(ShelterType shelterType) {
        this.shelterType = shelterType;
    }
}
