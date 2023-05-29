package com.spacetravel.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.spacetravel.SpaceTravel;

public class AsteroidScreen implements Screen {

        final SpaceTravel game;
        Stage stage;
        OrthographicCamera camera;
        TextButton startButton;
        Skin skin;

        Texture asteroidGameScreen;
        Sprite asteroidGameSprite;


        public AsteroidScreen(final SpaceTravel game) {
                this.game = game;
                this.stage = new Stage();
                Gdx.input.setInputProcessor(stage);

                this.skin = new Skin(Gdx.files.internal(game.stylePath));
                this.camera = new OrthographicCamera();
                camera.setToOrtho(false, 1920, 1080);
                asteroidGameScreen = new Texture(Gdx.files.internal("screen/JUPITER.jpeg"));
               asteroidGameSprite = new Sprite(asteroidGameScreen);
               asteroidGameSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

                startButton = new TextButton(" START ", game.textButtonStyle);
                startButton.setPosition((float) (Gdx.graphics.getWidth() / 2.7 ), (float) (Gdx.graphics.getHeight() / 4.5));
                startButton.addListener(new ChangeListener() {
                        @Override
                        public void changed(ChangeEvent event, Actor actor) {
                                game.setScreen(new GameScreen(game));
                        }
                });

                stage.addActor(startButton);
        }

        @Override
        public void show() {

        }

        @Override
        public void render(float delta) {
                game.batch.begin();
                asteroidGameSprite.draw(game.batch);

                game.batch.end();

                stage.draw();
                stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

                camera.update();

                game.batch.begin();

                asteroidGameSprite.draw(game.batch, 1f);

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
                asteroidGameScreen.dispose();
        }
}
