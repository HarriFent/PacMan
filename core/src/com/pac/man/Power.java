package com.pac.man;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Power extends Edible {

    public Power(int x, int y) {
        super(x, y);
        this.setEatenScore(500);
        Texture img2 = new Texture("sprites.jpg");
        sprite = new Sprite(img2, 56, 32, 8, 8);
        sprite.setSize(16,16);
        sprite.setPosition(x * 16, (30 - y) * 16);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void onEaten() {

    }
}