package Views.Battle;

import Entities.Characters.Character;
import Entities.Characters.CharacterManager;
import Entities.Enemies.Enemy;
import Entities.Enemies.EnemyManager;
import Game.Handler;
import Utils.Timer;
import Views.enums.Turn;
import Views.enums.Views;

import java.util.ArrayList;

public class BattleManager {
    private final CharacterManager characterManager;
    private EnemyManager enemyManager;

    private boolean isBattleActive = true;
    private Turn turn = Turn.PLAYER;

    private Handler handler;

    private int seconds = 0;
    private Timer timer = new Timer();

    public BattleManager(Handler handler) {
        this.handler = handler;
        characterManager = handler.getGameState().getCharacterManger();

        timer = new Timer();
    }

    public void newBattle(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
        handler.getViewManager().setView(Views.BATTLE);
        isBattleActive = true;
    }

    public void updateTurnState() {
        if (turn == Turn.PLAYER) {
            turn = Turn.ENEMY;
        } else {
            turn = Turn.PLAYER;
        }
        System.out.println("Turn State: " + turn);
        enemyManager.setAutoSelectEnemy(true);

        if(turn == Turn.ENEMY) {
            timer.start().setDelay(1).setAction(() -> {
                enemyManager.getCurrentEnemy().attack(characterManager.getPlayer());
                System.out.println("Timer 1 Action");
                turn = Turn.PLAYER;
                timer.reset();
            });
        }
        characterManager.updateTurns();
    }
    public Turn getTurnState() {
        return turn;
    }

    public void tick() {

        timer.update();
//        if (turn == Turn.PLAYER) {
//
//        } else {
//            timer.update();
//        }
    }

    public Character getPlayer() {
        return characterManager.getPlayer();
    }

    public ArrayList<Character> getCharacters() {
        return characterManager.getCharacters();
    }

    public void attackCurrentEnemy() {
        // Get the current player
    }

    public void attackLowestEnemy() {
        // Get the current player
    }

    public void attackAllEnemies() {
        // Get the current player
    }

    public boolean isBattleActive() {
        return isBattleActive;
    }

    public boolean isPlayersTurn() {
        return turn == Turn.PLAYER;
    }

    public CharacterManager getCharacterManager() {
        return characterManager;
    }

    public EnemyManager getEnemyManager() {
        return enemyManager;
    }

    public Enemy getCurrentEnemy() {
        return enemyManager.getCurrentEnemy();
    }
}
