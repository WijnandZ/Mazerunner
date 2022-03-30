package nl.han.mazerunner.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.han.mazerunner.entities.map.tiles.Wall;

public class MoveableEnemy extends DynamicSpriteEntity implements Collider, Collided {

    public MoveableEnemy(Coordinate2D location, Size size, String resource) {
        super(resource, location, size);
        setMotion(4, Direction.RIGHT);

    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Wall) {
            System.out.println(getAnchorLocation());
            if (getDirection() == 90) {
                setMotion(getSpeed(), Direction.LEFT);
            } else {
                setMotion(getSpeed(), Direction.RIGHT);
            }
        }
    }
}
