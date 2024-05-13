package MP03.AnimalTypes;

import MP03.Animal;
import MP03.Type;

public class FlyingAnimal extends Type {
    private float flightDuration;
    private float flightHeight;
    private int cageSize;

    public FlyingAnimal(Animal animal) {
        super(animal);
    }

    public float getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(float flightDuration) {
        this.flightDuration = flightDuration;
    }

    public float getFlightHeight() {
        return flightHeight;
    }

    public void setFlightHeight(float flightHeight) {
        this.flightHeight = flightHeight;
    }

    public int getCageSize() {
        return cageSize;
    }

    public void setCageSize(int cageSize) {
        this.cageSize = cageSize;
    }

    @Override
    public int getRoomSize() {
        return getCageSize();
    }
}
