package model.hero;

public class HeroAction {
    public static byte NO_ACTION = 0b0000;
    public static byte MOVE_RIGHT = 0b0001;
    public static byte MOVE_LEFT = 0b0010;
    public static byte MOVE_UP = 0b0100;
    public static byte MOVE_DOWN = 0b1000;
    public static byte ATTACK = 0b1000000;
}