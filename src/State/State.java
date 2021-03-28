package State;

import Game.Game;

import java.awt.*;

public abstract class State {
    private static State CURRENT_STATE = null;

    public static void setState(State state){
        CURRENT_STATE=state;
    }
    public static State getState(){
        return CURRENT_STATE;
    }

    //class

    protected Game game;
    public State(Game game){
        this.game = game;
    }
    public abstract void tick();
    public abstract void render(Graphics g);


}
