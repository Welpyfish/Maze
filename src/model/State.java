package model;

public abstract class State {
    public abstract State onEvent(StateEvent event); // handle events
    public abstract void onEnter(GameObject obj);  // perform action when entering
    public abstract void onExit(GameObject obj);   // perform action when active
    public abstract void onUpdate(GameObject obj); // perform action when exiting
}