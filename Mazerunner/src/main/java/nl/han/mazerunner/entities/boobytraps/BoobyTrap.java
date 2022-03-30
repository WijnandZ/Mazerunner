package nl.han.mazerunner.entities.boobytraps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class BoobyTrap extends SpriteEntity implements Collider {
    public BoobyTrap(Coordinate2D location, Size size, String resource) {
        super(resource, location, size);
    }
}
