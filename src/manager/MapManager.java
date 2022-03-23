package manager;

import model.Map;
import model.hero.Hero;
import model.hero.HeroAction;

import java.awt.event.KeyEvent;

public class MapManager {
    public Map map;
    private byte movement;
    private byte action;

    public MapManager(Map map) {
        this.map = map;
        action = HeroAction.NO_ACTION;
        movement = HeroAction.NO_ACTION;
    }

    public void updateMap() {
        updateHero(map.hero);
    }

    private void updateHero(Hero hero) {
        hero.updateLocation(movement, map);
        hero.updateAction(action, map);
    }

    public void manageInput(int keycode, boolean press) {
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                movement = (byte) (press ? movement | HeroAction.MOVE_LEFT : movement ^ HeroAction.MOVE_LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                movement = (byte) (press ? movement | HeroAction.MOVE_RIGHT : movement ^ HeroAction.MOVE_RIGHT);
                break;
            case KeyEvent.VK_UP:
                movement = (byte) (press ? movement | HeroAction.MOVE_UP : movement ^ HeroAction.MOVE_UP);
                break;
            case KeyEvent.VK_DOWN:
                movement = (byte) (press ? movement | HeroAction.MOVE_DOWN : movement ^ HeroAction.MOVE_DOWN);
                break;
            case KeyEvent.VK_SPACE:
                action = (byte) (press ? action | HeroAction.ATTACK : action ^ HeroAction.ATTACK);
                System.out.println("attack");
                break;
        }
    }
}
