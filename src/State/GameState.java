package State;

import Entity.Creature.Player;
import Entity.Static.Tree;
import GUI.Assets;
import Game.Game;
import Tile.Tile;
import World.World;

import java.awt.*;
import Game.Handler;
public class GameState extends State {
    private Player player;
    private World world;
    private Tree tree;
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"resource/world/world1.txt");
        handler.setWorld(world);

    }

    @Override
    public void tick() {
        world.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);

    }
}
