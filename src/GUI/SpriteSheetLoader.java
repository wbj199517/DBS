package GUI;

import java.awt.image.BufferedImage;
// A helper class simply load sprite sheet, and provide a helper function to crop it.

public class SpriteSheetLoader {
    private BufferedImage sheet;
    public SpriteSheetLoader(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x,int y, int width, int height) {
        return sheet.getSubimage(x,y,width,height);
    }
}
