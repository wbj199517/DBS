package Entity;

import Entity.Creature.Player;
import Game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entites;
    private Comparator<Entity> renderSort = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entites = new ArrayList<Entity>();
        entites.add(player);
    }

    public void tick() {
        for (int i = 0; i < entites.size(); i++) {
            Entity e = entites.get(i);
            e.tick();
        }
        entites.sort(renderSort);
    }

    public void render(Graphics g) {
        for (Entity e : entites) {
            e.render(g);
        }

    }

    public void addEntity(Entity e) {
        entites.add(e);
    }

    //getter  and setter
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntites() {
        return entites;
    }

    public void setEntites(ArrayList<Entity> entites) {
        this.entites = entites;
    }
}
