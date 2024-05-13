package MP03.AnimalTypes;

import MP03.Type;

public class WaterAnimal extends Type implements ISwimming {
    private int aquariumSize;

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
