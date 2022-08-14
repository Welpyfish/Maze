package model.item;
import model.GameObject;
import model.State;
import model.StateEvent;

public class MeleeIdleState extends State {

    //Singleton
    private static MeleeIdleState instance = new MeleeIdleState();

    private MeleeIdleState() {}

    public static MeleeIdleState instance() {
        return instance;
    }

    @Override
    public State onEvent(StateEvent event) {
        switch (event) {
            case IDLE -> {
                return instance();
            }
            case ATTACK -> {
                return MeleeAttackState.instance();
            }
            case COOLDOWN -> {
                return MeleeCooldownState.instance();
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