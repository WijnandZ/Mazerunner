package nl.han.mazerunner.entities.boobytraps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class LandMine extends BoobyTrap{
    public LandMine(Coordinate2D location, Size size, String resource) {
        super(location, size, resource);
    }
}
