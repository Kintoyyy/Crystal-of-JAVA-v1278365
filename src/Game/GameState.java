package Game;

import Characters.*;
import Characters.Character;
import World.World;
import Item.Item;

import java.util.ArrayList;

public class GameState {
    private ArrayList<Character> characters = new ArrayList<>(4);
    private int currentCharacterIndex = 0;
    private World world;
    private ArrayList<Item> items = new ArrayList<>(10);


    public GameState() {
        //initialize available characters
        this.characters.add(new Kent());
        this.characters.add(new Cedi());
        this.characters.add(new Nathan());
        this.characters.add(new Ambot());
    }

    public Character getPlayer() {
        return this.characters.get(currentCharacterIndex);
    }

    public void setPlayer(int index) {
        this.currentCharacterIndex = index;
    }

    public ArrayList<Character> getCharacters() {
        return this.characters;
    }
}