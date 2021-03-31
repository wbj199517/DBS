package Entity.Creature;

import Entity.Entity;
import GUI.Animation;
import GUI.Assets;
import Game.Game;
import Game.Handler;
import Inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    private int go;
    private  Inventory inventory;
    //animation

    private Animation animationDown, animationUp, animationLeft, animationRight;
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    private Animation animationAttack;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
        //init animation
        animationDown = new Animation(300, Assets.PLAYER_DOWN);
        animationUp = new Animation(300, Assets.PLAYER_UP);
        animationLeft = new Animation(300, Assets.PLAYER_LEFT);
        animationRight = new Animation(300, Assets.PLAYER_RIGHT);

        inventory=new Inventory(handler);
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
        //attack
        checkAttacks();
        inventory.tick();
    }

    public void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) { //attack still in cooldown;
            return;
        }
        if(inventory.isActive())return;
        Rectangle cb = getRectangleBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }
        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntites()) {
            if (e.equals(this)) continue;
            if (e.getRectangleBounds(0, 0).intersects(ar)) {
                e.shake();
                e.hurt(3);
                return;
            }
        }

    }

    @Override
    public void shake() {

    }

    public void die() {
        System.out.println("YOU LOSE");
    }

    private void getInput() {

        xMove = 0;
        yMove = 0;
        if(inventory.isActive())return;
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
    public void postRender(Graphics g){
        inventory.render(g);
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        if (handler.getKeyManager().aUp) {
            Rectangle cb = getRectangleBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.ATTACK, (int) ((cb.x + cb.width/2 - arSize/2) - handler.getGameCamera().getxOffset()-5),(int) ((cb.y - arSize) - handler.getGameCamera().getyOffset()-40 + go), 30, 30, null);
            go -=1;
            if (go == -30) {
                go=0;
            }
        }else if (handler.getKeyManager().aDown) {
            Rectangle cb = getRectangleBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.ATTACK, (int) ((cb.x + cb.width/2 - arSize/2) - handler.getGameCamera().getxOffset()-5),(int) ((cb.y + cb.height) - handler.getGameCamera().getyOffset() + go), 30, 30, null);
            go +=1;
            if (go == 30) {
                go=0;
            }
        }else if (handler.getKeyManager().aLeft) {
            Rectangle cb = getRectangleBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.ATTACK, (int) ((cb.x - arSize) - handler.getGameCamera().getxOffset()+ go),(int) ((cb.y + cb.height/2 - arSize/2) - handler.getGameCamera().getyOffset()- 20), 30, 30, null);
            go -=1;
            if (go == -30) {
                go=0;
            }
        }else if (handler.getKeyManager().aRight) {
            Rectangle cb = getRectangleBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.ATTACK, (int) ((cb.x + cb.width) - handler.getGameCamera().getxOffset() + go),(int) ((cb.y + cb.height/2 - arSize/2) - handler.getGameCamera().getyOffset()-20), 30, 30, null);
            go +=1;
            if (go == 30) {
                go=0;
            }
        }

//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animationLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animationRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animationUp.getCurrentFrame();
        } else if (yMove > 0) {
            return animationDown.getCurrentFrame();
        } else {
            return Assets.MAIN_CHAR;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
