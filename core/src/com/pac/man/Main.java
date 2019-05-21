package com.pac.man;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.*;

public class Main extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	List<GameObject> objs = new ArrayList<GameObject>();
	Wall wall;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		wall = new Wall();
		wall.loadGameObjects(objs);
		objs.add(new PacMan(176,200));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		wall.render(batch);
		for (GameObject obj : objs) {
			obj.render(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		PacMan p = null;
		switch (keycode) {
			case Input.Keys.W:
			case Input.Keys.S:
			case Input.Keys.A:
			case Input.Keys.D:
				p = (PacMan) objs.get(0);
				break;
		}

		switch (keycode) {
			case Input.Keys.W:
				p.setDir(0);
				break;
			case Input.Keys.S:
				p.setDir(1);
				break;
			case Input.Keys.A:
				p.setDir(2);
				break;
			case Input.Keys.D:
				p.setDir(3);
				break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {return false;}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {return false;}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {	return false;}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {return false;}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {return false;}
	@Override
	public boolean scrolled(int amount) {return false;}
}
