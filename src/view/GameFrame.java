package view;

import javax.swing.*;

public class GameFrame extends JFrame
{
    public GameFrame(UIManager uiManager)
    {
        JFrame frame = new JFrame();
        frame.add(uiManager);
        //frame.addKeyListener(inputManager);
        //frame.addMouseListener(inputManager);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
