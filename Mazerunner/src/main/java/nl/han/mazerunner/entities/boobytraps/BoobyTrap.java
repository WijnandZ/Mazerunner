package nl.han.mazerunner.entities.boobytraps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

public class BoobyTrap extends SpriteEntity implements Collider, Collided {
    SoundClip sound;

    public BoobyTrap(Coordinate2D location, Size size, String resource, SoundClip sound) {
        super(resource, location, size);
        this.sound = sound;
    }

    public void trap(Player player) {
        sound.play();
        remove();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof Player){
            trap((Player) collidingObject);
        }
    }
}
