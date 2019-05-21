package com.pac.man;

public class Moveable extends GameObject {

    // 0 = Up, 1 = Down, 2 = Left, 3 = Right
    private int dir;

    public Moveable(int x, int y) {
        super(x, y);
    }


    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
