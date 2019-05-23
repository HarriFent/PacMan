package com.pac.man.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dot extends Edible {

    public Dot(int x, int y) {
        super(x,y);
        this.setEatenScore(100);
        Texture img2 = new Texture("sprites.jpg");
        sprite = new Sprite(img2,48,32,8,8);
        sprite.setSize(16,16);
        sprite.setPosition(x*16,(30 - y)*16);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
