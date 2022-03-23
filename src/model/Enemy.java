package model;

import model.item.Weapon;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class Enemy extends Entity{

    public Enemy(double x, double y, Weapon weapon){
        super(x, y, weapon);
        this.setHp(50);

        ImageLoader imageLoader = new ImageLoader();

        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(48, 48, this.getDimension().width, this.getDimension().height));
    }
}
