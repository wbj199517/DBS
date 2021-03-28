package Tile;

import GUI.Assets;

import java.awt.image.BufferedImage;

public class WallTile extends Tile{
    public WallTile( int id) {
        super(Assets.TILE_WALL, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
