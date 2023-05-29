package com.spacetravel.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.spacetravel.SpaceTravel;

public class GameScreen implements Screen {

    final SpaceTravel game;
    Stage stage;
    OrthographicCamera camera;

    Skin skin;

    Texture gameScreen;
    Sprite gameSprite;


    public GameScreen(final SpaceTravel game) {
        this.game = game;
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal(game.stylePath));
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        gameScreen = new Texture(Gdx.files.internal("screen/space.png"));
        gameSprite = new Sprite(gameScreen);
        gameSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        gameSprite.draw(game.batch);

        game.batch.end();

        stage.draw();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        camera.update();

        game.batch.begin();

        gameSprite.draw(game.batch, 1f);

        game.batch.end();

        stage.draw();
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
        stage.dispose();
        skin.dispose();
        gameScreen.dispose();
    }
}
