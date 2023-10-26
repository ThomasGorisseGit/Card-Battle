package main.java.fr.gorisse.battleGame.model;

import java.util.Random;

public enum Card {
    JOKER(new Random().nextInt(5,14)),
    KING (13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1);
    private final int score;
    Card(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }



    @Override
    public String toString() {
        return super.toString()+"("+ this.score+")";
    }


}
