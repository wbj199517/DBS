package GUI;

import java.awt.image.BufferedImage;
//Load sprite sheet and crop it and assign icon to variables.

public class Assets {
    private static final int WIDTH=32,HEIGHT=32;
    public static BufferedImage HERO_AXE,HERO_AM,HERO_CM;

    public static void init(){
        SpriteSheetLoader sheet = new SpriteSheetLoader(ImageLoader.loadImage("/textures/hero_sheet.png"));

        HERO_AXE = sheet.crop(0,0,WIDTH,HEIGHT);
        HERO_AM = sheet.crop(WIDTH,0,WIDTH,HEIGHT);
        HERO_CM = sheet.crop(2*WIDTH,0,WIDTH,HEIGHT);
    }
}
