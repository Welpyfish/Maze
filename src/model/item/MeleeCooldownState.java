package model.item;
import model.GameObject;
import model.State;
import model.StateEvent;

public class MeleeCooldownState extends State {

    //Singleton
    private static MeleeCooldownState instance = new MeleeCooldownState();

    private MeleeCooldownState() {}

    public static MeleeCooldownState instance() {
        return instance;
    }

    @Override
    public State onEvent(StateEvent event) {
        switch (event) {
            case IDLE -> {
                return MeleeIdleState.instance();
            }
            case ATTACK -> {
                return MeleeAttackState.instance();
            }
            case COOLDOWN -> {
                return instance();
            }
            default -> {
                return instance();
            }
        }
    }

    @Override
    public void onEnter(GameObject obj) {
        Melee melee = (Melee)obj;
        //hero.setCurrentImages(HeroAction.NO_ACTION);
    }

    @Override
    public void onExit(GameObject obj) {

    }

    @Override
    public void onUpdate(GameObject obj) {
        Melee melee = (Melee)obj;
        //hero.setCurrentImage(hero.getCurrentImage());
    }
}