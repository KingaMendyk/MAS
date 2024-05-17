package MP04.AnimalTypes;

import MP04.Animal;
import MP04.Type;

public class LandAnimal extends Type {
    private int preferredRoomSize = 5;

    public LandAnimal(Animal animal) {
        super(animal);
    }

    public int getPreferredRoomSize() {
        return preferredRoomSize;
    }

    public void setPreferredRoomSize(int preferredRoomSize) {
        this.preferredRoomSize = preferredRoomSize;
    }

    @Override
    public int getRoomSize() {
        return preferredRoomSize;
    }
}
