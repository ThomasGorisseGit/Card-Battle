package main.java.fr.gorisse.battleGame;

import java.util.ArrayList;

public class Deck extends ArrayList<Cards>{
    private static Deck deck=null;
    private Deck(){

    }
    public static Deck getInstance(){
        if(deck == null){
            deck = new Deck();
        }
        return deck;
    }


}
