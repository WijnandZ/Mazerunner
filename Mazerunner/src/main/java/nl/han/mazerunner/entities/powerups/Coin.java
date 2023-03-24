package nl.han.mazerunner.entities.powerups;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.mazerunner.entities.Player;

public class Coin extends PowerUp {
    public Coin(Size size) {
        super("sprites/munt.png", size, new SoundClip("audio/coin_sound.mp3"));
    }

    @Override
    public void pickUp(Player player) {
        sound.play();
        player.giveCoin();
        remove();
    }
}
