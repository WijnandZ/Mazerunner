package nl.han.mazerunner.entities.map.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Door extends Wall{
    public Door(Coordinate2D location, Size size, String resource) {
        super(location, size, resource);
    }
}
