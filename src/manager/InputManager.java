package manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Dictionary;
import java.util.Hashtable;

public class InputManager implements KeyListener, MouseListener{
    private GameEngine engine;
    private Hashtable<Integer, Boolean> inputs;

    InputManager(GameEngine engine)
    {
        this.engine = engine;
        inputs = new Hashtable<Integer, Boolean>();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                if(!inputs.containsKey(keyCode)) {
                    notifyInput(keyCode, true);
                    this.inputs.put(keyCode, true);
                }
                break;
            default:
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                if(inputs.containsKey(keyCode)) {
                    notifyInput(keyCode, false);
                    this.inputs.remove(keyCode);
                }
                break;
            default:
        }
    }

    private void notifyInput(int keycode, boolean type) {
        engine.receiveInput(keycode, type);
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
