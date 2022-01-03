package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.screen.utils.Assets;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;
    private BitmapFont font32;
    private StringBuilder scoreSB;
    private StringBuilder hpSB;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf", BitmapFont.class);
        this.scoreSB = new StringBuilder();
        this.hpSB = new StringBuilder();
    }

    public void render() {
        ScreenUtils.clear(0.0f, 0.1f, 0.5f, 1);
        batch.begin();
        gc.getBackground().render(batch);
        gc.getAsteroidController().render(batch);
        gc.getBulletController().render(batch);
        gc.getHero().render(batch);
        scoreSB.setLength(0);
        scoreSB.append("SCORE: ").append(gc.getHero().getScoreView());
        hpSB.setLength(0);
        hpSB.append("HP: ").append(gc.getHero().getHp());
        font32.draw(batch, scoreSB, 20, 700);
        font32.draw(batch, hpSB, 20, 670);
        batch.end();
    }
}
