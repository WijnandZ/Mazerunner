package nl.han.mazerunner.entities.boobytraps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

public class LandMine extends BoobyTrap{
    public LandMine(Coordinate2D location, Size size, String resource) {
        super(location, size, resource, new SoundClip("audio/boom.mp3"));
    }

    @Override
    public void trap(Player player) {
        sound.play();
        player.takeLife(1);
        player.teleportBackToSpawn();
        remove();
    }
}
