package GUI;

import java.awt.image.BufferedImage;
//Load sprite sheet and crop it and assign icon to variables.

public class Assets {
    private static final int WIDTH = 32, HEIGHT = 32;
    public static BufferedImage TILE_GRASS, TILE_ROCK, TILE_DIRT, TILE_WALL,TILE_TREE;
    public static BufferedImage HERO_AXE, HERO_AM, HERO_CM;
    public static BufferedImage MAIN_CHAR;
    public static BufferedImage ATTACK;
    public static BufferedImage[] PLAYER_DOWN, PLAYER_UP, PLAYER_LEFT, PLAYER_RIGHT;
    public static BufferedImage[] BUTTON_START;
    public static void init() {
        ATTACK = ImageLoader.loadImage("/textures/attack.gif");
        MAIN_CHAR = ImageLoader.loadImage("/textures/Shitty_Wizard.png");
        BUTTON_START = new BufferedImage[2];
        BUTTON_START[0] = ImageLoader.loadImage("/textures/start_button_0.jpeg");
        BUTTON_START[1] = ImageLoader.loadImage("/textures/start_button_1.jpeg");
        //animation assets
        PLAYER_DOWN = new BufferedImage[2];
        PLAYER_DOWN[0] = ImageLoader.loadImage("/textures/Shitty_Wizard_Down_0.png");
        PLAYER_DOWN[1] = ImageLoader.loadImage("/textures/Shitty_Wizard_Down_1.png");

        PLAYER_UP = new BufferedImage[2];
        PLAYER_UP[0] = ImageLoader.loadImage("/textures/Shitty_Wizard_Up_0.png");
        PLAYER_UP[1] = ImageLoader.loadImage("/textures/Shitty_Wizard_Up_1.png");

        PLAYER_LEFT = new BufferedImage[2];
        PLAYER_LEFT[0] = ImageLoader.loadImage("/textures/Shitty_Wizard_Left_0.png");
        PLAYER_LEFT[1] = ImageLoader.loadImage("/textures/Shitty_Wizard_Left_1.png");

        PLAYER_RIGHT = new BufferedImage[2];
        PLAYER_RIGHT[0] = ImageLoader.loadImage("/textures/Shitty_Wizard_Right_0.png");
        PLAYER_RIGHT[1] = ImageLoader.loadImage("/textures/Shitty_Wizard_Right_1.png");
        //animation ends

        SpriteSheetLoader hero_sheet = new SpriteSheetLoader(ImageLoader.loadImage("/textures/hero_sheet.png"));
        HERO_AXE = hero_sheet.crop(0, 0, WIDTH, HEIGHT);
        HERO_AM = hero_sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        HERO_CM = hero_sheet.crop(2 * WIDTH, 0, WIDTH, HEIGHT);

        SpriteSheetLoader tile_sheet = new SpriteSheetLoader(ImageLoader.loadImage("/textures/tile_sprite.png"));
        TILE_GRASS = tile_sheet.crop(0, 0, WIDTH, HEIGHT);
        TILE_ROCK = tile_sheet.crop(5 * WIDTH, 0, WIDTH, HEIGHT);
        TILE_DIRT = tile_sheet.crop(WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
        TILE_WALL = tile_sheet.crop(13 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);


        TILE_TREE = ImageLoader.loadImage("/textures/tree.png");
    }
}
