package MP03.AnimalTypes;

import MP03.Animal;
import MP03.Type;

public class WaterAnimal extends Type implements ISwimming {
    private int aquariumSize;

    public WaterAnimal(Animal animal) {
        super(animal);
    }

    @Override
    public int getAquariumSize() {
        return aquariumSize;
    }

    @Override
    public void setAquariumSize(int aquariumSize) {
        this.aquariumSize = aquariumSize;
    }

    @Override
    public int getRoomSize() {
        return getAquariumSize();
    }
}
