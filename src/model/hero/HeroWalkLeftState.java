package model.hero;

import model.Entity;
import model.GameObject;
import model.State;
import model.StateEvent;

public class HeroWalkLeftState extends State {

    //Singleton
    private static HeroWalkLeftState instance = new HeroWalkLeftState();

    private HeroWalkLeftState() {}

    public static HeroWalkLeftState instance() {
        return instance;
    }

    @Override
    public State onEvent(StateEvent event) {
        switch (event) {
            case IDLE -> {
                return HeroIdleState.instance();
            }
            case WALK_LEFT -> {
                return instance();
            }
            case WALK_RIGHT -> {
                return HeroWalkRightState.instance();
            }
            case WALK_UP -> {
                return HeroWalkUpState.instance();
            }
            case WALK_DOWN -> {
                return HeroWalkDownState.instance();
            }
            default -> {
                return instance();
            }
        }
    }

    @Override
    public void onEnter(GameObject obj) {
        Entity entity = (Entity)obj;
        //hero.setCurrentImages(HeroAction.NO_ACTION);
    }

    @Override
    public void onExit(GameObject obj) {

    }

    @Override
    public void onUpdate(GameObject obj) {
        Entity entity = (Entity)obj;;
        //hero.setCurrentImage(hero.getCurrentImage());
    }
}