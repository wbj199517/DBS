package State;

import Entity.Creature.Player;
import GUI.Assets;
import Game.Game;
import Tile.Tile;
import World.World;

import java.awt.*;

public class GameState extends State {
    private Player player;
    private World world;
    public GameState(Game game){
        super(game);
        player = new Player(game,100,100);
        world = new World(game,"resource/world/world1.txt");
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
