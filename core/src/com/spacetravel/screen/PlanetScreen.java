package com.spacetravel.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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
    Dialog help;
    Skin skin;

    Texture planetScreen;
    Sprite planetSprite;

    public PlanetScreen(final SpaceTravel game, final String planetName) {
        this.game = game;
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal(game.stylePath));
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        planetScreen = new Texture(Gdx.files.internal("planets/" + planetName.toUpperCase() + ".jpeg"));
        planetSprite = new Sprite(planetScreen);
        planetSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        oxygen = new TextField("oxygen", game.texFieldStyle);
        oxygen.setPosition((float) (Gdx.graphics.getWidth()*4/5), (float) (Gdx.graphics.getHeight() * 4/10));

        propellent = new TextField("fluid", game.texFieldStyle);
        propellent.setPosition((float) (Gdx.graphics.getWidth()* 4/5), (float) (Gdx.graphics.getHeight() * 3.5/10));

        velocity = new TextField("velocity", game.texFieldStyle);
        velocity.setPosition((float) (Gdx.graphics.getWidth() *4/5), (float) (Gdx.graphics.getHeight() * 3/10));

        exitButton = new TextButton("Exit", game.textButtonStyle);
        exitButton.setPosition((float) (Gdx.graphics.getWidth()/18), (float) (Gdx.graphics.getHeight() * 8.4/10));
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.exit(0);
            }
        });

       checkButton = new TextButton("Check", game.textButtonStyle);
       checkButton.setPosition((float) (Gdx.graphics.getWidth()*7/10), (float) (Gdx.graphics.getHeight() * 2/10));
        checkButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            switch(planetName){

                case "Mercury":
                    if (Integer.parseInt(oxygen.getText()) == 90 && Integer.parseInt(propellent.getText()) == 180 && Integer.parseInt(velocity.getText()) == 70){
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

                case "Venus":
                    if (Integer.parseInt(oxygen.getText()) == 80 && Integer.parseInt(propellent.getText()) == 170 && Integer.parseInt(velocity.getText()) == 40){
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

                case "Moon":
                    if (Integer.parseInt(oxygen.getText()) == 0 && Integer.parseInt(propellent.getText()) == 0 && Integer.parseInt(velocity.getText()) == 0) {
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new AsteroidScreen(game));
                    break;

                case "Mars":
                    if(Integer.parseInt(oxygen.getText()) == 30 && Integer.parseInt(propellent.getText()) == 80 && Integer.parseInt(velocity.getText()) == 40){
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

                case "Jupiter":
                    if (Integer.parseInt(oxygen.getText()) == 130 && Integer.parseInt(propellent.getText()) == 230 && Integer.parseInt(velocity.getText()) == 70){
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

                case "Saturn":
                    if (Integer.parseInt(oxygen.getText()) == 180 && Integer.parseInt(propellent.getText()) == 280 && Integer.parseInt(velocity.getText()) == 90) {
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

                case "Uranus":
                    if ((Integer.parseInt(oxygen.getText()) == 230) && (Integer.parseInt(propellent.getText()) == 330) && (Integer.parseInt(velocity.getText()) == 110)){
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

                case "Neptune":
                    if (Integer.parseInt(oxygen.getText()) == 240 && Integer.parseInt(propellent.getText()) == 340 && Integer.parseInt(velocity.getText()) == 130){
                        game.setScreen(new AsteroidScreen(game));
                    }
                    game.setScreen(new ExplosionScreen(game,planetName));
                    break;

            }
                }



        });

        helpButton = new TextButton("Help", game.textButtonStyle);
        helpButton.setPosition((float) (Gdx.graphics.getWidth()* 2/3), (float) (Gdx.graphics.getHeight() * 8.6/10));
        helpButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Dialog help = new Dialog("Set Up Spaceship",skin);
                switch(planetName){

                    case "Mercury":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Mercury : 80 < propellent < 100, 150 < velocity < 200 and 50 < oxygen < 70");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(100, 100);
                        break;
                    case "Venus":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Venus : 70 < propellent < 90, 150 < velocity < 200 and 40 < oxygen < 50");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;

                    case "Moon":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Moon :  20 < propellent < 40, 60 < velocity < 100 and 20 < oxygen < 40");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;

                    case "Mars":

                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Mars : 50 < propellent < 60, 90 < velocity < 150 and 40 < oxygen < 50");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;
                    case "Jupiter":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Jupiter : 100 < propellent < 150, 200 < velocity < 250 and 60 < oxygen < 80");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;

                    case "Saturn":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Saturn : 150 < propellent < 200, 250 < velocity < 300 and 80 < oxygen < 100");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;
                    case "Uranus":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Uranus : 200 < propellent < 250, 300 < velocity < 350 and 100 < oxygen < 120");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;

                    case "Neptune":
                        help.setResizable(false);
                        help.text(" PLANETS : HOW TO CORRECTLY SET UP THE SHIP\n");
                        help.text(" Neptune : 250 < propellent < 300, 350 < velocity < 400 and 120 < oxygen < 140");
                        help.button("Ok!", true, game.textButtonStyle);
                        help.setPosition(0, 0);
                        break;

                }
            }
        });


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
