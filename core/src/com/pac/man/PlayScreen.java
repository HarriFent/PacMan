package com.pac.man;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pac.man.GameObjects.PacMan;
import com.pac.man.GameObjects.Wall;

import java.util.ArrayList;
import java.util.List;

public class PlayScreen implements Screen {
    //Reference to our Game, used to set Screens
    private Main game;
    private TextureAtlas atlas;

    //basic playscreen variables
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    private List<GameObject> objs = new ArrayList<GameObject>();
    private PacMan pacman;
    private Wall wall;

    public PlayScreen(Main game){
        atlas = new TextureAtlas("SpriteSheet.pack");

        this.game = game;
        //create cam used to follow mario through cam world
        gamecam = new OrthographicCamera();

        //create a FitViewport to maintain virtual aspect ratio despite screen size
        gamePort = new FitViewport(Main.WIDTH / Main.PPM, Main.HEIGHT / Main.PPM, gamecam);

        //initially set our gamcam to be centered correctly at the start of of map
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        wall = new Wall();
        wall.loadGameObjects(objs);
        pacman = new PacMan(176,200);
    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
        //control our player using immediate impulses
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP))
            pacman.setDir(PacMan.State.UP);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            pacman.setDir(PacMan.State.DOWN);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            pacman.setDir(PacMan.State.LEFT);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            pacman.setDir(PacMan.State.RIGHT);
    }

    private void update(float delta) {
        handleInput(delta);
        PacMan.update(delta);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        wall.render(game.batch);
        for (GameObject obj : objs) {
            obj.render(game.batch);
        }
        pacman.render(game.batch);
        game.batch.end();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
