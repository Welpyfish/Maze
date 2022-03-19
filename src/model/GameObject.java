package model;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class GameObject {
    private double x, y;
    private Dimension dimension;
    private BufferedImage image;

    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
        this.dimension = new Dimension(48, 48);
    }



    public boolean checkOverlap(GameObject gameObject){
        boolean result = true;

        if(this.getX() > gameObject.getX() + gameObject.dimension.width){
            result = false;
        } else if(this.getX() + this.dimension.width < gameObject.getX()){
            result = false;
        } else if(this.getY() > gameObject.getY() + gameObject.dimension.height){
            result = false;
        } else if(this.getY() + this.dimension.height < gameObject.getY()){
            result = false;
        }

        return result;
    }

    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dimension getDimension(){
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setDimension(int width, int height){ this.dimension =  new Dimension(width, height); }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

//    public Rectangle getTopBounds(){
//        return new Rectangle((int)x+dimension.width/6, (int)y, 2*dimension.width/3, dimension.height/2);
//    }
//
//    public Rectangle getBottomBounds(){
//        return new Rectangle((int)x+dimension.width/6, (int)y + dimension.height/2, 2*dimension.width/3, dimension.height/2);
//    }
//
//    public Rectangle getLeftBounds(){
//        return new Rectangle((int)x, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
//    }
//
//    public Rectangle getRightBounds(){
//        return new Rectangle((int)x + 3*dimension.width/4, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
//    }
//
//    public Rectangle getBounds(){
//        return new Rectangle((int)x, (int)y, dimension.width, dimension.height);
//    }
}
