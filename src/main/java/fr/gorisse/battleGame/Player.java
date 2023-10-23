package main.java.fr.gorisse.battleGame;

public class Player {
    private Deck deck;
    private String name;

    public Player(String name ){
        this.deck = Deck.getInstance();
        this.name = name;
    }
}
