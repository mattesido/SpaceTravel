package com.spacetravel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.spacetravel.screen.WelcomeScreen;

public class SpaceTravel extends Game {
    public Skin skin;
    public Skin skin1;
    public Batch batch;
    public TextButton.TextButtonStyle textButtonStyle;
    public BitmapFont bigFont;
    public final String stylePath = "style/star-soldier-ui.json";
    public SelectBox.SelectBoxStyle selectBoxStyle;
    public TextField.TextFieldStyle texFieldStyle;

    @Override
    public void create() {
        this.skin = new Skin(Gdx.files.internal(stylePath));
        this.skin1 = new Skin(Gdx.files.internal(stylePath));
        batch = new SpriteBatch();
        bigFont = new BitmapFont(Gdx.files.internal("style/font-title-export.fnt"));
        textButtonStyle = skin.get("default", TextButton.TextButtonStyle.class);
        textButtonStyle.font = this.bigFont;
        selectBoxStyle = skin1.get("default", SelectBox.SelectBoxStyle.class);
        selectBoxStyle.font = bigFont;
        texFieldStyle = skin.get("default", TextField.TextFieldStyle.class);
        this.setScreen(new WelcomeScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        skin.dispose();
    }
}


