package model.item;
import model.GameObject;
import model.State;
import model.StateEvent;

public class MeleeAttackState extends State {

    //Singleton
    private static MeleeAttackState instance = new MeleeAttackState();
    private int counter;

    private MeleeAttackState() {}

    public static MeleeAttackState instance() {
        return instance;
    }

    @Override
    public State onEvent(StateEvent event) {
        switch (event) {
            case IDLE -> {
                return MeleeIdleState.instance();
            }
            case ATTACK -> {
                return instance();
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
        counter = 0;
        //hero.setCurrentImages(HeroAction.NO_ACTION);
    }

    @Override
    public void onExit(GameObject obj) {

    }

    @Override
    public void onUpdate(GameObject obj) {
        Melee melee = (Melee)obj;
        counter++;

        //hero.setCurrentImage(hero.getCurrentImage());
    }
}