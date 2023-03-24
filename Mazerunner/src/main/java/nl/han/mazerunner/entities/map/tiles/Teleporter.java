package nl.han.mazerunner.entities.map.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

import java.util.Random;

public class Teleporter extends SpriteEntity implements Collider, Collided {
    SoundClip sound;

    public Teleporter(final Coordinate2D location, final Size size, final String resource)  {
        super(resource, location, size);
        this.sound = new SoundClip("audio/teleport.mp3");
    }

    public double getTeleportX(){
        return (new Random().nextInt( 30)) * 60 +70;
    }

    public double getTeleportY(){
        return (new Random().nextInt(16)) * 60 + 70;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof Player) {
            ((Player) collidingObject).movePlayer(new Coordinate2D(getTeleportX(), getTeleportY()));
            sound.play();
        }
    }
}
