package nl.han.mazerunner.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.han.mazerunner.entities.map.tiles.Wall;

public class MoveableEnemy extends DynamicSpriteEntity implements Enemy {

    public MoveableEnemy(Coordinate2D location, Size size, String resource, int speed) {
        super(resource, location, size);
        setMotion(speed, Direction.RIGHT);

    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Wall) {
            if (getDirection() == 90) {
                setMotion(getSpeed(), Direction.LEFT);
            } else {
                setMotion(getSpeed(), Direction.RIGHT);
            }
        }
    }
}
