package Game;

import GUI.*;
import Input.KeyManager;
import Input.MouseManager;
import State.GameState;
import State.MenuState;
import State.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
// Class where game runs.

public class Game implements Runnable {
    private Thread thread;
    private boolean isRunning = false;
    private String title;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int width, height;
    private GameWindow gameWindow;
    private BufferStrategy bs;
    private Graphics g;

    //state
    public State gameState;
    public State menuState;

    // key input
    private KeyManager keyManager;
    // mouse input
    private MouseManager mouseManager;
    // game camera
    private GameCamera gameCamera;
    //handler
    private Handler handler;


    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();  //init key manaager, my own key listener logic e.g. WASD as up down left right.
        mouseManager = new MouseManager();
    }

    // init GUI detail here,  also init assets for later use.
    private void init() {
        gameWindow = new GameWindow(title, width, height);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
        gameWindow.getFrame().addKeyListener(keyManager);   //make key manager listening on game window
        gameWindow.getFrame().addMouseListener(mouseManager);
        gameWindow.getFrame().addMouseMotionListener(mouseManager);
        gameWindow.getCanvas().addMouseListener(mouseManager);
        gameWindow.getCanvas().addMouseMotionListener(mouseManager);
        // pass own object to GameSate, why? GameState has field player which need "game" (this) to be init.
        // -why GameState need to have player field? GameState need player.render() and player.tick();
        // ---why player need game object? want to know key input information from game object keyManager.

        gameState = new GameState(handler); //set game state
        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    @Override
    public void run() {
        init();  //init assets and gui properties
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();  //update
                render();  //draw and render on gui
                ticks++;
                delta--;
            }

            if(timer>= 1000000000){  //every 1 second, check how many time that tick() runs
                System.out.println("Ticks and Frames:" + ticks);
                ticks=0;
                timer=0;
            }
        }

        stop();
    }

    private void tick() {
        keyManager.tick();
        if(State.getState()!=null){
            State.getState().tick();
        }
    }

    private void render() {
        bs = gameWindow.getCanvas().getBufferStrategy();
        if (bs == null) {
            gameWindow.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);

        //Start Draw

        if(State.getState()!=null){
            State.getState().render(g);
        }

        //End Draw

        bs.show();
        g.dispose();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera(){return gameCamera;}

    //Set running state in case of game already start
    public synchronized void start() {
        if (isRunning) return;   //set running state to true; and then start thread
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) return;  // set running state to false; and then end thread
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
