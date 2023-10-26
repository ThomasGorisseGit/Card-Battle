package main.java.fr.gorisse.battleGame.model;

import java.util.ArrayList;

public interface Playable {
    void setName(String name);
    void addToDeck(Card c);
    void removeFromDeck(Card c);
    void increaseScore();
    int getScore();
    ArrayList<Card> getDeck();
    String getName();
    Card getCard(int index);

}
