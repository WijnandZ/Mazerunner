package nl.han.mazerunner.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.entities.map.tiles.Wall;

public class Knight extends Enemy {
    public Knight(Coordinate2D enemy1Location, Size defaultSize, String s, int speed) {
        super(s, enemy1Location, defaultSize, speed, new SoundClip("audio/sword_sound.mp3"));
    }

    @Override
    public void attack(Player player) {
        sound.play();
        player.takeLife();
        player.teleportBackToSpawn();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof Player) {
            attack((Player) collidingObject);
        }
        if (collidingObject instanceof Wall) {
            changeDirection();
        }
    }
}
