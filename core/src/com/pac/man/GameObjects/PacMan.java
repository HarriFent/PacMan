package com.pac.man.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.pac.man.Moveable;

import java.util.ArrayList;
import java.util.List;

public class PacMan extends Moveable {

    boolean powered;

    private List<Animation> animations;
    private Animation currentAnimation;
    float stateTime = 0f;

    public PacMan(int x, int y) {
        super(x, y);

        dir = State.UP;

        animations = new ArrayList<Animation>(5);

        TextureRegion[] frames;
        for (int i = 0; i < 4; i++) {
            frames = new TextureRegion[4];
            frames[0] = tmp[i][0];
            frames[1] = tmp[i][1];
            frames[2] = tmp[i][2];
            frames[3] = tmp[i][1];
            animations.add(new Animation<TextureRegion>(0.25f, frames));
        }
        frames = new TextureRegion[10];
        for (int i = 0; i < 10;i++){
            frames[i] = tmp[3][i];
        }
        animations.add(new Animation<TextureRegion>(0.25f, frames));

    }

    @Override
    public void render(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animations.get(2).getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y, currentFrame.getRegionWidth()*2,currentFrame.getRegionHeight()*2);
    }

    public void update(float delta) {
        super.update();
    }

    @Override
    public boolean hitTest(int x, int y) {
        return super.hitTest(x, y);
    }

}
