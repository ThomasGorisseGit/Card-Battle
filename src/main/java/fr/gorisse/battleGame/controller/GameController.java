package main.java.fr.gorisse.battleGame.controller;

import main.java.fr.gorisse.battleGame.model.Card;
import main.java.fr.gorisse.battleGame.model.CardList;
import main.java.fr.gorisse.battleGame.model.Player;
import main.java.fr.gorisse.battleGame.view.IView;
import main.java.fr.gorisse.battleGame.view.ShellView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameController {
    enum GameState{
        InitGameValues,
        GameStart,
        EndGame
    }
    private GameState gameState = GameState.InitGameValues;
    private ArrayList<Card> listOfCards;
    private Player player1;
    private Player player2;
    private IView view;
    private Player playerToPlay;

    public GameController(){
        this.listOfCards = CardList.getInstance();
        this.player1 = new Player("");
        this.player2 = new Player("");
        this.view = new ShellView();
        this.startGame();
    }



    private void startGame(){

        switch (this.gameState){
            case InitGameValues -> {
                this.view.displayGreetings(); // Display Game start
                this.player1.setName(this.view.getPlayerNames("player1"));
                this.player2.setName(this.view.getPlayerNames("player2"));
                this.view.displaySomething(); // Display next state
            }
            case GameStart -> {
                this.setPlayerToPlay();
                this.view.displayPlayerToPlay(this.playerToPlay.getName());
                this.view.displayPlayerCards(this.playerToPlay.getDeck());
                int cardIndex = this.view.getPlayerCardToPlay();
                this.playerToPlay.getCard(cardIndex);

            }


        }

    }

    private void setPlayerToPlay(){
        // if there is no player to play than init randomly one, else switch the player
        if(playerToPlay == null){
            if(new Random().nextInt(0,1 )== 0 ) playerToPlay = player1;
            else playerToPlay = player2;
        }
        else{
            if(playerToPlay == player1) playerToPlay = player2;
            else playerToPlay = player1;
        }
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


}
