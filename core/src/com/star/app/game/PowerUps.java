package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;

public class PowerUps implements Poolable {
    private GameController gc;
    private Texture texture;
    private Vector2 position;
    private boolean active;
    private Circle hitArea;
    private Type type;

    public Circle getHitArea() {
        return hitArea;
    }

    public Type getType() {
        return type;
    }

    public PowerUps(GameController gc) {
        this.gc = gc;
        this.position = new Vector2(0, 0);
        this.active = false;
        this.hitArea = new Circle(0, 0, 15);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 0, 0,
                30, 30);
    }

    public void update(float dt) {

    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void activate(float x, float y, Type type) {
        this.texture = new Texture(type.getPath());
        this.type = type;
        position.set(x, y);
        active = true;
        hitArea.setPosition(position);
    }

    public void deactivate() {
        active = false;
    }

    public enum Type {
        HEALTH(1, "images/heart.png"),
        MONEY(2, "images/dollar.png"),
        BULLET(3, "images/ammo.png");

        private int id;
        private String path;

        Type(int id, String path) {
            this.id = id;
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
