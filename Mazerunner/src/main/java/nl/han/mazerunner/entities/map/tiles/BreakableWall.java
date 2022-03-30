package nl.han.mazerunner.entities.map.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BreakableWall extends Wall {
    public BreakableWall(Coordinate2D location, Size size, String resource) {
        super(location, size, resource);
    }
}
