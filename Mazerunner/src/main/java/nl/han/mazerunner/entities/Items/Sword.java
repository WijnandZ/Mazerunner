package nl.han.mazerunner.entities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

public class Sword extends Item {
    public Sword(Coordinate2D location, Size size) {
        super("sprites/sword.png", location, size, new SoundClip("audio/sword_sound.mp3"));
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Player) {
            return;
        }
    }
}
