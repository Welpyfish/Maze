package model.hero;

import model.GameObject;
import view.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends GameObject {


    public Hero(double x, double y){
        super(x, y);

        ImageLoader imageLoader = new ImageLoader();

        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(48, 0, 48, 48));
        setDimension(48,48);
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




}
