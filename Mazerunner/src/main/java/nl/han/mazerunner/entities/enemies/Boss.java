package nl.han.mazerunner.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

public class Boss extends Enemy {
    public Boss(Coordinate2D location, Size size, String resource) {
        super(resource, location, size, new SoundClip("audio/boss_sound.mp3"));
    }

    @Override
    public void attack(Player player) {
        sound.play();
        if(player.getSword() == false){
            player.takeLifes(3);
            player.teleportBackToSpawn();
        }
    }
}
