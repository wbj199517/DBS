package Entity;

import Game.Game;
import Game.Handler;

import java.awt.*;

public abstract class Entity {
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(0, 0, width, height);
    }

    public Rectangle getRectangleBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public boolean checkEntityCollision(float xOffset, float yOffset) {

        for (Entity e : handler.getWorld().getEntityManager().getEntites()) {
            if (e.equals(this)) continue;
            if (e.getRectangleBounds(0f, 0f).intersects(getRectangleBounds(xOffset, yOffset))) {
                return true;
            }
        }
        return false;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
