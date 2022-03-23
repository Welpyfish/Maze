package model.hero;

import manager.ButtonAction;
import model.Entity;
import model.GameObject;
import model.item.Weapon;
import view.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.WeakHashMap;

public class Hero extends Entity {
    private ButtonAction actionX;
    private ButtonAction actionY;

    public Hero(double x, double y, Weapon weapon){
        super(x, y, weapon);
        this.setHp(50);

        ImageLoader imageLoader = new ImageLoader();

        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(48, 0, this.getDimension().width, this.getDimension().height));
        //remainingLives = 3;
        //points = 0;
        //coins = 0;
        //invincibilityTimer = 0;

        //BufferedImage[] leftFrames = imageLoader.getLeftFrames(MarioForm.SMALL);
        //BufferedImage[] rightFrames = imageLoader.getRightFrames(MarioForm.SMALL);

        //Animation animation = new Animation(leftFrames, rightFrames);
        //marioForm = new MarioForm(animation, false, false);
        //setStyle(marioForm.getCurrentStyle(toRight, false, false));
    }

    @Override
    public void updateX()
    {
        if (actionX != ButtonAction.NO_ACTION) {
            super.updateX();
        }
    }

    @Override
    public void updateY()
    {
        if (actionY != ButtonAction.NO_ACTION) {
            super.updateY();
        }
    }
}
