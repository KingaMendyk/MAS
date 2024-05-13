package MP03.AnimalTypes;

import MP03.Type;

public class LandAnimal extends Type {
    private int preferredRoomSize;

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
