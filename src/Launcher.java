import GUI.GameWindow;
import Game.Game;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("DBS", 640,480);  // init game
        game.start();  //start game
    }
}
