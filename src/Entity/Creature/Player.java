package Entity.Creature;

import GUI.Animation;
import GUI.Assets;
import Game.Game;
import Game.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    //animation
    private Animation animationDown,animationUp,animationLeft,animationRight;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
        //init animation
        animationDown = new Animation(300,Assets.PLAYER_DOWN);
        animationUp = new Animation(300,Assets.PLAYER_UP);
        animationLeft = new Animation(300,Assets.PLAYER_LEFT);
        animationRight = new Animation(300,Assets.PLAYER_RIGHT);
    }

    @Override
    public void tick() {
        //animation
        animationDown.tick();
        animationUp.tick();
        animationLeft.tick();
        animationRight.tick();
        //move
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
         g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove<0){
            return animationLeft.getCurrentFrame();
        }else if(xMove>0){
            return animationRight.getCurrentFrame();
        }else if(yMove<0){
            return  animationUp.getCurrentFrame();
        }else if(yMove>0){
            return animationDown.getCurrentFrame();
        }else{
            return Assets.MAIN_CHAR;
        }
    }
}
