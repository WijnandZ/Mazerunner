package nl.han.mazerunner.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.entities.map.tiles.Wall;

public class Enemy extends DynamicSpriteEntity implements Collider, Collided {
    SoundClip sound;
    int speed;

    protected Enemy(String resource, Coordinate2D location, Size size, int speed, SoundClip sound) {
        super(resource, location, size);
        this.sound = sound;
        this.speed = speed;
    }

    public void move() {
        setMotion(speed, Direction.RIGHT);
    }

    public void attack(Player player){
        sound.play();
    }

    public void changeDirection() {
        if (getDirection() == 90) {
            setMotion(getSpeed(), Direction.LEFT);
        } else {
            setMotion(getSpeed(), Direction.RIGHT);
        }
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
