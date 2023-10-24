package main.java.fr.gorisse.battleGame.model;

import java.util.ArrayList;

public class CardList extends ArrayList<Card>{
    private static CardList cardList = null;
    private CardList(){
        add(Card.ONE);
        add(Card.TWO);
        add(Card.THREE);
        add(Card.FOUR);
        add(Card.FIVE);
        add(Card.SIX);
        add(Card.SEVEN);
        add(Card.EIGHT);
        add(Card.NINE);
        add(Card.TEN);
        add(Card.JACK);
        add(Card.QUEEN);
        add(Card.KING);
        add(Card.JOKER);
    }
    public static CardList getInstance(){
        if(cardList == null){
            cardList = new CardList();
        }
        return cardList;
    }


}
