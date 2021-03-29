package State;

import Entity.Creature.Player;
import GUI.Assets;
import Game.Game;
import Tile.Tile;
import World.World;

import java.awt.*;
import Game.Handler;
public class GameState extends State {
    private Player player;
    private World world;
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"resource/world/world1.txt");
        handler.setWorld(world);
        player = new Player(handler,100,100);

    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
