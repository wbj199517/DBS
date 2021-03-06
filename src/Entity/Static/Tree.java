package Entity.Static;

import GUI.Assets;
import Game.Handler;
import Item.Item;
import Tile.Tile;

import java.awt.*;

public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y){
        super(handler,x,y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT*2);
        bounds.x =10;
        bounds.y = (int) (height/1.5);
        bounds.width = width-20;
        bounds.height = (int)(height-height/1.5f);
    }

    @Override
    public void tick() {

    }
    public void die(){
        System.out.println("You cut a Tree!");
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));
    }
    public void shake(){
        System.out.println("Tree is shaking");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.TILE_TREE,(int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
