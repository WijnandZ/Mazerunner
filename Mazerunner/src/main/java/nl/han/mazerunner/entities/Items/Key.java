package nl.han.mazerunner.entities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.Random;

public class Key extends Item{
    public Key(Size size) {
        super("sprites/key.png", size, new SoundClip("audio/keys.mp3"));
        determineLocation();
    }

    private void determineLocation(){
        if(new Random().nextInt(10) > 5){
            super.setAnchorLocation(new Coordinate2D(490, 730));
        } else {
            super.setAnchorLocation(new Coordinate2D(970, 970));
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        return;
    }
}
