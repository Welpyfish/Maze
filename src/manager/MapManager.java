package manager;

import model.Map;
import model.hero.Hero;
import model.hero.HeroAction;

import java.awt.event.KeyEvent;

public class MapManager {
    public Map map;
    private byte action;

    public MapManager(Map map) {
        this.map = map;
        action = HeroAction.NO_ACTION;
    }

    public void updateMap() {
        updateHero(map.hero);
    }

    private void updateHero(Hero hero) {
        hero.updateLocation(action, map);
        hero.updateAction(action, map);
    }

    public void manageInput(int keycode, boolean press) {
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                action = (byte) (press ? action | HeroAction.MOVE_LEFT : action ^ HeroAction.MOVE_LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                action = (byte) (press ? action | HeroAction.MOVE_RIGHT : action ^ HeroAction.MOVE_RIGHT);
                break;
            case KeyEvent.VK_UP:
                action = (byte) (press ? action | HeroAction.MOVE_UP : action ^ HeroAction.MOVE_UP);
                break;
            case KeyEvent.VK_DOWN:
                action = (byte) (press ? action | HeroAction.MOVE_DOWN : action ^ HeroAction.MOVE_DOWN);
                break;
            case KeyEvent.VK_SPACE:
                action = (byte) (press ? action | HeroAction.ATTACK : action ^ HeroAction.ATTACK);
                break;
        }
    }
}
