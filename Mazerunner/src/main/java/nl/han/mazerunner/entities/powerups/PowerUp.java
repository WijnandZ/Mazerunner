package nl.han.mazerunner.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

import java.util.Random;

public class PowerUp extends SpriteEntity implements Collider, Collided {
    SoundClip sound;

    public PowerUp(String sprite, Size size, SoundClip sound) {
        super(sprite, new Coordinate2D(), size);
        this.sound = sound;
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

    public void pickUp(Player player){
        sound.play();
        remove();
    }
}
