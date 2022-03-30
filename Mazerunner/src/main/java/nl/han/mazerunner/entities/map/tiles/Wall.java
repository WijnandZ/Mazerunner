package nl.han.mazerunner.entities.map.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Wall extends SpriteEntity implements Collider {
    public Wall(final Coordinate2D location, final Size size, final String resource) {
        super(resource, location, size);
    }
}
