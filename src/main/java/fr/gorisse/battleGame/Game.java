package main.java.fr.gorisse.battleGame;

import java.util.ArrayList;

public class Game {
    private ArrayList<Cards> listOfCards;
    private Player player1;
    private Player player2;

    public Game(){
        this.listOfCards = new ArrayList<>();
        listOfCards.add(Cards.ONE);
        listOfCards.add(Cards.TWO);
        listOfCards.add(Cards.THREE);
        listOfCards.add(Cards.FOUR);
        listOfCards.add(Cards.FIVE);
        listOfCards.add(Cards.SIX);
        listOfCards.add(Cards.SEVEN);
        listOfCards.add(Cards.EIGHT);
        listOfCards.add(Cards.NINE);
        listOfCards.add(Cards.TEN);
        listOfCards.add(Cards.JACK);
        listOfCards.add(Cards.QUEEN);
        listOfCards.add(Cards.KING);

        this.player1 = new Player("");
        this.player2 = new Player("");


    }
}
