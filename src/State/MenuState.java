package State;

import Game.Game;

import java.awt.*;
import Game.Handler;
public class MenuState extends State {

    public MenuState(Handler handler){
        super(handler);

    }

    @Override
    public void tick() {
        if(handler.getMouseManager().isLeftPressed()){
            State.setState(handler.getGame().gameState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),8,8);
    }
}
