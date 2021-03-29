package State;

import Game.Game;

import java.awt.*;
import Game.Handler;
public abstract class State {
    private static State CURRENT_STATE = null;

    public static void setState(State state){
        CURRENT_STATE=state;
    }
    public static State getState(){
        return CURRENT_STATE;
    }

    //class

    protected Handler handler;
    public State(Handler handler){
        this.handler = handler;
    }
    public abstract void tick();
    public abstract void render(Graphics g);


}
