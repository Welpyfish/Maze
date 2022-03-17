package model.StaticObject;

import model.GameObject;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class Wall extends GameObject {
    public Wall(double x, double y){
        super(x, y);
        ImageLoader imageLoader = new ImageLoader();
        //this.setImage((imageLoader.loadImage("/media/weilongwrm.png")));
        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(48, 144, 48, 48));
    }
}
