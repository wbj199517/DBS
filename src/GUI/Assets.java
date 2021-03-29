package GUI;

import java.awt.image.BufferedImage;
//Load sprite sheet and crop it and assign icon to variables.

public class Assets {
    private static final int WIDTH=32,HEIGHT=32;
    public static BufferedImage TILE_GRASS,TILE_ROCK,TILE_DIRT,TILE_WALL;
    public static BufferedImage HERO_AXE,HERO_AM,HERO_CM;
    public static BufferedImage MAIN_CHAR;
    public static void init(){
        MAIN_CHAR = ImageLoader.loadImage("/textures/Shitty_Wizard.png");

        SpriteSheetLoader hero_sheet = new SpriteSheetLoader(ImageLoader.loadImage("/textures/hero_sheet.png"));

        HERO_AXE = hero_sheet.crop(0,0,WIDTH,HEIGHT);
        HERO_AM = hero_sheet.crop(WIDTH,0,WIDTH,HEIGHT);
        HERO_CM = hero_sheet.crop(2*WIDTH,0,WIDTH,HEIGHT);

        SpriteSheetLoader tile_sheet = new SpriteSheetLoader(ImageLoader.loadImage("/textures/tile_sprite.png"));
        TILE_GRASS = tile_sheet.crop(0,0,WIDTH,HEIGHT);
        TILE_ROCK =  tile_sheet.crop(5*WIDTH,0,WIDTH,HEIGHT);
        TILE_DIRT = tile_sheet.crop(WIDTH,3*HEIGHT,WIDTH,HEIGHT);
        TILE_WALL = tile_sheet.crop(13*WIDTH,6*HEIGHT,WIDTH,HEIGHT);
    }
}
