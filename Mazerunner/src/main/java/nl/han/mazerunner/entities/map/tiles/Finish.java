package nl.han.mazerunner.entities.map.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

public class Finish extends SpriteEntity implements Collider, Collided {
    SoundClip sound;

    public Finish(final Coordinate2D location, final Size size, final String resource) {
        super(resource, location, size);
        this.sound = new SoundClip("audio/finish.mp3");
    }


    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof Player) {
            sound.play();
        }
    }
}
