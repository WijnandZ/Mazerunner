package nl.han.mazerunner.entities.Items;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Items.Item;
import nl.han.mazerunner.entities.Player;

public class Life extends Item {
    public Life(Size size) {
        super("sprites/leven.png", size, new SoundClip("audio/life.mp3"));
    }

    @Override
    public void pickUp(Player player) {
        sound.play();
        player.giveLife();
        remove();
    }
}
