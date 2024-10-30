package Game;

import Characters.Character;
import Utils.DebugMode;
import Views.ViewManager;
import World.World;

public class Handler {

    private Game game;
    private World world;
    private DebugMode debugMode;
    private Character character;
    private ViewManager viewManager;

    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeymanager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public DebugMode getDebugMode() {
        return debugMode;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }


    public ViewManager getViewManager() {
        return viewManager;
    }

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }
}
