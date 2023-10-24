package main.java.fr.gorisse.battleGame.view;

import main.java.fr.gorisse.battleGame.model.Card;

import java.util.ArrayList;

public interface IView {
    void displaySomething();
    void displayStartGame();
    void displayGreetings();
    void displayPlayerToPlay(String playerName);
    void displayPlayerCards(ArrayList<Card> cards);
    String getPlayerNames(String playerName);
    int getPlayerCardToPlay();

}
