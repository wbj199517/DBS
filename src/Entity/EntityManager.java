package Entity;

import Entity.Creature.Player;
import Game.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entites;

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entites = new ArrayList<Entity>();

    }
    public void tick(){
        for(int i=0;i<entites.size();i++){
            Entity e = entites.get(i);
            e.tick();
        }
        player.tick();
    }
    public void render(Graphics g){
        for(Entity e: entites){
            e.render(g);
        }
        player.render(g);
    }
    public void addEntity(Entity e){
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
