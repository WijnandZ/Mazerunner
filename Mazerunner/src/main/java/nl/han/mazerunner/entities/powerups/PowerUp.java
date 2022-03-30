package nl.han.mazerunner.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import java.util.Random;

public abstract class PowerUp extends SpriteEntity implements Collider, Collided {

    public PowerUp(String sprite, Size size) {
        super(sprite, new Coordinate2D(), size);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof DynamicSpriteEntity) {
            return;
        }
        setAnchorLocation(getRandomLocation());
    }

    private Coordinate2D getRandomLocation(){
        return new Coordinate2D(new Random().nextInt(((int) getSceneWidth()) - 120) + 120, new Random().nextInt(((int) getSceneHeight()) - 120) + 120);
    }
}
