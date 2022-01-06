package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.star.app.game.helpers.ObjectPool;

public class PowerUpsController extends ObjectPool<PowerUps> {
    private GameController gc;

    @Override
    protected PowerUps newObject() {
        return new PowerUps(gc);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            PowerUps a = activeList.get(i);
            a.render(batch);
        }
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }

    public void setup(float x, float y, PowerUps.Type type){
        getActiveElement().activate(x, y, type);
    }
}
