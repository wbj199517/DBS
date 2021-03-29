package State;

import GUI.Assets;
import Game.Game;

import java.awt.*;
import Game.Handler;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;

public class MenuState extends State {
    private UIManager uiManager;
    public MenuState(Handler handler){
        super(handler);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.BUTTON_START, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);

            }
        }));

    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

    }
}
