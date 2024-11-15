package Game;

import Entities.Characters.*;

public class GameState {
    private final CharacterManager characters;

    private Handler handler;


    public GameState(Handler handler) {
        this.handler = handler;
        this.characters = new CharacterManager();
    }

    public void tick() {
        if (handler.getViewManager().isInGame()) {
            characters.tick();
        }
    }

    public CharacterManager getCharacterManger() {
        return this.characters;
    }
}
