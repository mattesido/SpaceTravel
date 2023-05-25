package com.spacetravel.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import com.spacetravel.SpaceTravel;

public class PlanetScreen implements Screen {
    Button exitButton;
    Button helpButton;
    TextField propellent;
    TextField oxygen;
    TextField velocity;
    Button checkButton;
    final SpaceTravel game;
    Stage stage;
    OrthographicCamera camera;

    Skin skin;

    Texture planetScreen;
    Sprite planetSprite;

    public PlanetScreen(final SpaceTravel game, String planetName) {
        this.game = game;
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal(game.stylePath));
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        planetScreen = new Texture(Gdx.files.internal("planets/" + planetName.toUpperCase() + ".jpeg"));
        planetSprite = new Sprite(planetScreen);
        planetSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        propellent = new TextField("fluid", game.texFieldStyle);
        propellent.setPosition((float) (Gdx.graphics.getWidth()*4/5), (float) (Gdx.graphics.getHeight() * 4/10));

        oxygen = new TextField("oxygen", game.texFieldStyle);
        oxygen.setPosition((float) (Gdx.graphics.getWidth()* 4/5), (float) (Gdx.graphics.getHeight() * 3.5/10));

        velocity = new TextField("velocity", game.texFieldStyle);
        velocity.setPosition((float) (Gdx.graphics.getWidth() *4/5), (float) (Gdx.graphics.getHeight() * 3/10));

       checkButton = new TextButton("Check", game.textButtonStyle);
       checkButton.setPosition((float) (Gdx.graphics.getWidth()*7/10), (float) (Gdx.graphics.getHeight() * 2/10));


        helpButton = new TextButton("Help", game.textButtonStyle);
        helpButton.setPosition((float) (Gdx.graphics.getWidth()* 2/3), (float) (Gdx.graphics.getHeight() * 8.6/10));



        stage.addActor(exitButton);
        stage.addActor(propellent);
        stage.addActor(velocity);
        stage.addActor(oxygen);
        stage.addActor(checkButton);
        stage.addActor(helpButton);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        planetSprite.draw(game.batch);

        game.batch.end();

        stage.draw();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        camera.update();

        game.batch.begin();

        planetSprite.draw(game.batch, 1f);

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
        planetScreen.dispose();
    }
}
