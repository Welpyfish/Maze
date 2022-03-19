package manager;
import model.Enemy;
import model.GameObject;
import model.Map;
import model.StaticObject.Wall;
import model.hero.Hero;

import java.awt.event.KeyEvent;
import java.util.Hashtable;

public class MapManager {
    public Map map;
    private boolean pressedLeft;
    private boolean pressedRight;
    private boolean pressedUp;
    private boolean pressedDown;

    public MapManager(Map map){
        this.map = map;
    }

    public void updateMap(){
        updateHero(map.hero);
    }

    public void updateHero(Hero hero)
    {
        hero.updateMoveDirection(
                (pressedLeft && !pressedRight) ? ButtonAction.MOVE_LEFT :
                        ((pressedRight && !pressedLeft) ? ButtonAction.MOVE_RIGHT : ButtonAction.NO_ACTION),
                (pressedUp && !pressedDown) ? ButtonAction.MOVE_UP:
                        ((pressedDown && !pressedUp) ? ButtonAction.MOVE_DOWN : ButtonAction.NO_ACTION)
        );
        hero.updateX();
        for(Wall wall : map.walls) {
            hero.horizontalCollision(wall);
        }
        for(Enemy enemy : map.enemies) {
            boolean collide = hero.horizontalCollision(enemy);
            if(collide){
                hero.takeDamage(1);
            }
        }
        hero.updateY();
        for(Wall wall : map.walls) {
            hero.verticalCollision(wall);
        }
        for(Enemy enemy : map.enemies) {
            boolean collide = hero.verticalCollision(enemy);
            if(collide){
                hero.takeDamage(1);
            }
        }
    }

    public void manageInput(int keycode, boolean press){
        switch (keycode)
        {
            case KeyEvent.VK_LEFT:
                pressedLeft = press;
                break;
            case KeyEvent.VK_RIGHT:
                pressedRight = press;
                break;
            case KeyEvent.VK_UP:
                pressedUp = press;
                break;
            case KeyEvent.VK_DOWN:
                pressedDown = press;
                break;
        }
    }
}
