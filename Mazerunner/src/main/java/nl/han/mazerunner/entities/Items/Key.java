package nl.han.mazerunner.entities.Items;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import java.util.Random;

public class Key extends Item{
    public Key(Size size) {
        super(new Coordinate2D(), size, "sprites/key.png");
        if(new Random().nextInt(10) > 5){
            super.setAnchorLocation(new Coordinate2D(490, 730));
        } else {
            super.setAnchorLocation(new Coordinate2D(970, 970));
        }

    }

    @Override
    public void setAnchorPoint(AnchorPoint anchorPoint) {

        super.setAnchorPoint(anchorPoint);
    }
}
