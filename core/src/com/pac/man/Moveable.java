package com.pac.man;

import com.pac.man.GameObjects.PacMan;

public abstract class Moveable extends GameObject {

    // 0 = Up, 1 = Down, 2 = Left, 3 = Right
    public enum State { UP, DOWN, LEFT, RIGHT, DEAD, IDLE};
    protected State dir;

    public Moveable(int x, int y) {
        super(x, y);
    }


    public State getDir() {
        return dir;
    }

    public void setDir(State dir) {
        this.dir = dir;
    }
}
