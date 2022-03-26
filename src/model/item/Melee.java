package model.item;

import model.*;
import model.hero.HeroAction;
import model.hero.HeroIdleState;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class Melee extends Weapon{
    private StateMachine actionStates;

    public Melee(){
        super();
        setAttackState(0);

        ImageLoader imageLoader = new ImageLoader();
        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(0, 0, 10, 30));
        //actionStates = new StateMachine(HeroIdleState.instance(), this);

    }

//    public void update(byte action){
//        updateMovementState(action);
//    }
//
//    private void updateMovementState(byte action) {
//        //Change current state based on events and perform actions based on current state
//        if (action == HeroAction.NO_ACTION) {
//            actionStates.onEvent(StateEvent.IDLE);
//        }
//        if ((action & HeroAction.MOVE_LEFT) != 0) {
//            actionStates.onEvent(StateEvent.WALK_LEFT);
//        }
//        if ((action & HeroAction.MOVE_RIGHT) != 0) {
//            actionStates.onEvent(StateEvent.WALK_RIGHT);
//        }
//        if ((action & HeroAction.MOVE_UP) != 0) {
//            actionStates.onEvent(StateEvent.WALK_UP);
//        }
//        if ((action & HeroAction.MOVE_DOWN) != 0) {
//            actionStates.onEvent(StateEvent.WALK_DOWN);
//        }
//
//        actionStates.update();
//    }
    @Override
    public void attack(Entity entity, Map map){
        if(getAttackState() == 0 || getAttackState() > 31) {
            setAttackState(1);
        }
    }

    @Override
    public void update(Entity entity, Map map) {
        if(getAttackState() == 0) {
            setX(entity.getX());
            setY(entity.getY());
        } else
        if(getAttackState() <= 10) {
            setAttackState(getAttackState() + 1);
            setX(entity.getX() + getAttackState()*2);
            setY(entity.getY() - getAttackState()*2);

            for (Enemy enemy : map.enemies) {
                if (checkOverlap(enemy) && !enemy.isHit()) {
                    enemy.changeHp(-getDamage());
                    enemy.setHit(true);
                }
            }
        } else if(getAttackState() <= 20) {
            setAttackState(getAttackState() + 1);
            setX(entity.getX() + 40 - getAttackState() * 2);
            setY(entity.getY() - 40 + getAttackState() * 2);
        } else if(getAttackState() <= 30){
            setAttackState(getAttackState() + 1);
            setX(entity.getX());
            setY(entity.getY());
        }else{
            setAttackState(0);
            for (Enemy enemy : map.enemies) {
                enemy.setHit(false);
            }
        }
    }

}
