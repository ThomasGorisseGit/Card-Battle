package main.java.fr.gorisse.battleGame.model;

import java.util.ArrayList;

public class Player implements Playable{
    private ArrayList<Card> deck;
    private String name;

    public Player(String name ){
        this.deck = new ArrayList<>();
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public Card getCard(int index){
        return this.deck.get(index);
    }
    public void addToDeck(Card c){
        this.deck.add(c);
    }
    public void removeFromDeck(Card c){
        this.deck.remove(c);
    }
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
}
