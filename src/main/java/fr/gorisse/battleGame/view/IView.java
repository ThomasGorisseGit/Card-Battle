package main.java.fr.gorisse.battleGame.view;

import main.java.fr.gorisse.battleGame.model.Card;
import main.java.fr.gorisse.battleGame.model.Playable;

import java.util.ArrayList;

public interface IView {
    void displayNextState();
    void displayStartGame();
    void displayGreetings();
    void displayPlayerToPlay(String playerName);
    void displayPlayerCards(ArrayList<Card> cards);
    void displayACard(Card c, String playerName);
    void displayDuel(Card c1, Card c2);
    void displayWinner(String winnerName);
    void displayEndGame();
    void handleNewGame();
    String getPlayerNames(String playerName);
    int getPlayerCardToPlay();


}
