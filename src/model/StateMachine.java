package model;

public class StateMachine {
    State state;
    GameObject owner;

    public StateMachine(State initialState, GameObject ownerObject)
    {
        state = initialState;
        owner = ownerObject;
        state.onEnter(owner);
    }

    public void onEvent(StateEvent event)
    {
        State newState = state.onEvent(event);
        if (newState != state)
        {
            state.onExit(owner);
            state = newState;
            state.onEnter(owner);
        }
    }

    public void update()
    {
        state.onUpdate(owner);
    }

    public State getState()
    {
        return state;
    }
}