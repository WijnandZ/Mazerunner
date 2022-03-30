package nl.han.mazerunner.entities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import nl.han.mazerunner.entities.Player;

import java.util.Random;

public class Pickaxe extends Item implements Collided {
    public Pickaxe(Size size) {
        super(new Coordinate2D(), size, "sprites/pickaxe.png");
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Player) {
            return;
        }
        setAnchorLocation(getRandomLocation());
    }

    private Coordinate2D getRandomLocation(){
        return new Coordinate2D(new Random().nextInt((int) getSceneWidth() / 4) + ((getSceneWidth() / 4) * 3), new Random().nextInt((int) getSceneHeight() / 4) + ((getSceneHeight() / 4) * 3));
    }
}
