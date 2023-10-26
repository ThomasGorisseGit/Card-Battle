package main.java.fr.gorisse.battleGame.controller;

import main.java.fr.gorisse.battleGame.model.Card;
import main.java.fr.gorisse.battleGame.model.CardList;
import main.java.fr.gorisse.battleGame.model.Playable;
import main.java.fr.gorisse.battleGame.model.Player;
import main.java.fr.gorisse.battleGame.view.IView;
import main.java.fr.gorisse.battleGame.view.ShellView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameController {
    public enum GameState{
        InitGameValues,
        GameStart,
        EndGame
    }
    public GameState gameState = GameState.InitGameValues;
    private ArrayList<Card> listOfCards;
    private Playable player1;
    private Playable player2;
    private IView view;
    private Playable playerToPlay;

    public GameController(){
        this.listOfCards = CardList.getInstance();
        this.player1 = new Player("");
        this.player2 = new Player("");
        this.view = new ShellView(this);
        this.startGame();
    }



    private void startGame(){
        while(true){
            switch (this.gameState){
                case InitGameValues -> {
                    this.view.displayGreetings(); // Display Game start
                    this.player1.setName(this.view.getPlayerNames("player1"));
                    this.player2.setName(this.view.getPlayerNames("player2"));
                    this.view.displayNextState(); // Display next state
                    this.gameState = GameState.GameStart;
                }
                case GameStart -> {
                    this.setDecks();
                    this.player1.resetScore();
                    this.player2.resetScore();
                    while(!this.player1.getDeck().isEmpty() && !this.player2.getDeck().isEmpty())
                    {
                        this.setPlayerToPlay();
                        Playable roundWinner = this.playerToPlay;
                        Card c1 = this.playerPlays();
                        this.switchPlayers(); // Changing the player order
                        //TODO : Between each round, set the playerToPlay at the winner of the last round
                        Card c2 = this.playerPlays();
                        this.view.displayDuel(c1,c2);
                        if(this.evaluateWinner(c1,c2) == c2) roundWinner = this.playerToPlay;
                        this.view.displayRoundWinner(roundWinner.getName());
                        roundWinner.increaseScore();
                        this.view.displayScores(this.player1.getName(),this.player1.getScore(),this.player2.getName(),this.player2.getScore());
                    }

                    this.gameState = GameState.EndGame;
                }
                case EndGame -> {
                    Playable gameWinner;
                    if(this.player1.getScore()>this.player2.getScore())
                        gameWinner= this.player1;
                    else gameWinner = this.player2;
                    this.view.displayEndGame(gameWinner.getName());
                    this.view.handleNewGame();
                }

            }
        }


    }
    private Card evaluateWinner(Card c1, Card c2){

        if(c1.getScore()>c2.getScore()) return c1;
        return c2;
    }
    private Card playerPlays(){
        this.view.displayPlayerToPlay(this.playerToPlay.getName());
        this.view.displayPlayerCards(this.playerToPlay.getDeck());
        int cardIndex = this.view.getPlayerCardToPlay();
        Card card = this.playerToPlay.getCard(cardIndex);
        this.view.displayACard(card,this.playerToPlay.getName());
        this.playerToPlay.removeFromDeck(card);
        return card;
    }

    private void switchPlayers(){
        if(playerToPlay == player1) playerToPlay = player2;
        else playerToPlay = player1;
    }
    private void setPlayerToPlay(){
        // if there is no player to play than init randomly one, else switch the player

        if(new Random().nextInt(0,1 )== 0 ) playerToPlay = player1;
        else playerToPlay = player2;



    }
    private void setDecks(){
        Collections.shuffle(this.listOfCards);
        int y = this.listOfCards.size()/2;
        for(int i =0;i<this.listOfCards.size()/2;i++){
            this.player1.addToDeck(this.listOfCards.get(i));
            this.player2.addToDeck(this.listOfCards.get(y));
            y++;
        }

        System.out.println("Player 1 : "+this.player1.getDeck() +"()");
        System.out.println("Player 2 : "+this.player2.getDeck());
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
    }


}
