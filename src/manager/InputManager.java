package manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputManager implements KeyListener, MouseListener{
    private GameEngine engine;

    InputManager(GameEngine engine)
    {
        this.engine = engine;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        ButtonAction currentAction = ButtonAction.NO_ACTION;

        if (keyCode == KeyEvent.VK_UP) {
            currentAction = ButtonAction.MOVE_UP;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            currentAction = ButtonAction.MOVE_DOWN;
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            currentAction = ButtonAction.MOVE_RIGHT;
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
            currentAction = ButtonAction.MOVE_LEFT;
        }

        notifyInput(currentAction);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }

    private void notifyInput(ButtonAction action) {
        if(action != ButtonAction.NO_ACTION) {
            engine.recieveInput(action);
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
