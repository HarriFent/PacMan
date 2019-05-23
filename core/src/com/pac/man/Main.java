package com.pac.man;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pac.man.GameObjects.PacMan;
import com.pac.man.GameObjects.Wall;

import java.util.*;

public class Main extends Game {

	public static final int WIDTH = 384;
	public static final int HEIGHT = 560;
	public static final float PPM = 100;
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
