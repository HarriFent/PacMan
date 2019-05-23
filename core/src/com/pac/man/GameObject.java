package com.pac.man;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected Sprite sprite;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(SpriteBatch batch) {

        Texture img = new Texture("badlogic.jpg");
        batch.draw(img, 0, 0);
    }

    public void update() {

    };

    public boolean hitTest(int x, int y) { return false; }

}
