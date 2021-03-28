package World;

import Tile.Tile;
import Utils.Utils;

import java.awt.*;

public class World {
    private int width,height;
    private int spawnX, spawnY;
    private int[][] tiles_position;

    public World(String path){
        loadWorld(path);
    }
    public void tick(){

    }
    public void render(Graphics g){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                getTile(x,y).render(g,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
            }
        }
    }
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles_position[x][y]];
        if(t==null){
            return Tile.dirtTile;
        }
        return t;
    }
    private void loadWorld(String path){
       String file = Utils.loadFileAsString(path);
       String[] tokens = file.split("\\s+");
       width = Utils.parseInt(tokens[0]);
       height = Utils.parseInt(tokens[1]);
       spawnX = Utils.parseInt(tokens[2]);
       spawnY = Utils.parseInt(tokens[3]);

       tiles_position =new int[width][height];
       for(int y=0;y<height;y++){
           for(int x=0;x<width;x++){
               tiles_position[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
           }
       }
    };
}
