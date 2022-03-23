package model.item;

import model.Enemy;
import model.Entity;
import model.Map;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class Melee extends Weapon{

    public Melee(){
        super();
        setAttackState(0);

        ImageLoader imageLoader = new ImageLoader();
        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(0, 0, 20, 40));

    }

    @Override
    public void attack(Entity entity, Map map) {
        if(getAttackState() < 20) {
            setAttackState(getAttackState() + 1);
            setX(entity.getX() + getAttackState()*3);
            setY(entity.getY() - getAttackState()*3);

            for (Enemy enemy : map.enemies) {
                if (checkOverlap(enemy) && !enemy.isHit()) {
                    enemy.changeHp(-getDamage());
                    enemy.setHit(true);
                }
            }
        } else if(getAttackState() < 60) {
            setAttackState(getAttackState() + 1);
        }else{
            setAttackState(0);
            for (Enemy enemy : map.enemies) {
                enemy.setHit(false);
            }
        }
    }

}
