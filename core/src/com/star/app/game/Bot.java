package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class Bot extends Ship implements Poolable {

    private Vector2 tempVec;
    private boolean active;

    public void setPause(boolean pause) {
        gc.setPause(pause);
    }

    public Bot(GameController gc) {
        super(gc, 100, 500);
        this.position = new Vector2(ScreenManager.SCREEN_WIDTH / 2, ScreenManager.SCREEN_HEIGHT / 2);
        this.velocity = new Vector2(0, 0);
        this.texture = Assets.getInstance().getAtlas().findRegion("ship");
        this.hitArea = new Circle(position, 29);
        this.active = false;
        this.tempVec = new Vector2();
    }

    public void render(SpriteBatch batch) {
        super.render(batch);
    }

    public void deactivate() {
        active = false;
    }

    public void update(float dt) {
        super.update(dt);
        tempVec.set(gc.getHero().getPosition()).sub(position).nor();
        velocity.mulAdd(tempVec, 5);
    }

    public void activate(float x, float y, float vx, float vy, float scale) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
        hpMax = (int) (8 * scale + gc.getLevel() * 2);
        hp = hpMax;
        angle = MathUtils.random(0.0f, 360.0f);
        hitArea.setPosition(position);
        hitArea.setRadius(32 * scale * 0.9f);
    }

    @Override
    public boolean isActive() {
        return active;
    }
}
