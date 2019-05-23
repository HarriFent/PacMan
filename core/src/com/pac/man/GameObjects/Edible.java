package com.pac.man.GameObjects;

import com.pac.man.GameObject;

public class Edible extends GameObject {

    private boolean isEdible = true;
    private int eatenScore = 0;

    public Edible(int x, int y) {
        super(x,y);
    }

    public void onEaten() {

    }

    public void setEdible(boolean isEdible) {
        this.isEdible = isEdible;
    }

    protected void setEatenScore(int score) {
        this.eatenScore = score;
    }

    protected int getEatenScore() {
        return eatenScore;
    }
}
