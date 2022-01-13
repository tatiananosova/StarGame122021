package com.star.app.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;

public class GameOverScreen extends MenuScreen {

    private int score;

    public GameOverScreen(SpriteBatch batch) {
        super(batch);
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String screenText() {
        return "Game Over!!!";
    }

    @Override
    public String btn1Text() {
        return "Try Again";
    }

    @Override
    public String btn2Text() {
        return "Exit";
    }

    public void additionalData() {
        TextField.TextFieldStyle textStyle = new TextField.TextFieldStyle();
        textStyle.fontColor = Color.YELLOW;
        textStyle.font = font24;
        TextField textField = new TextField("SCORE: " + score, textStyle);
        textField.setAlignment(Align.center);
        textField.setPosition(480, 400);
        stage.addActor(textField);
    }
}
