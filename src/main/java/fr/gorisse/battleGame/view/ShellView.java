package main.java.fr.gorisse.battleGame.view;

import main.java.fr.gorisse.battleGame.controller.GameController;
import main.java.fr.gorisse.battleGame.model.Card;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShellView implements IView {
    private final GameController controller;
    private final Scanner input;
    public ShellView(GameController controller){
        this.controller = controller;
        this.input = new Scanner(System.in);
    }
    @Override
    public void displayNextState() {
        System.out.println("-------THE GAME IS ABOUT TO START-------");
    }



    @Override
    public void displayGreetings() {
        System.out.println("----------------------------------");
        System.out.println("--------------WELCOME-------------");
        System.out.println("----------------------------------");

    }

    @Override
    public void displayPlayerToPlay(String playerName) {
        System.out.println("\n");
        System.out.println("------IT'S "+playerName+"'s TURN TO PLAY-------");
    }

    @Override
    public String getPlayerNames(String playerName) {
        System.out.println("Please enter "+playerName+" name");
        return this.input.nextLine();
    }

    @Override
    public int getPlayerCardToPlay() {
        return Integer.parseInt(this.input.nextLine());
    }

    @Override
    public void displayPlayerCards(ArrayList<Card> cards) {
        System.out.println("Choose a Card by writing the index of the card !");
        System.out.println(cards);
    }

    @Override
    public void displayACard(Card c, String playerName) {
        System.out.println(playerName+ " played the card "+ c.getScore()+"\n\n");
    }

    @Override
    public void displayDuel(Card c1, Card c2) {
        System.out.println("----------DUEL---------");
        System.out.println(c1.getScore() +" +->-=-<-+ "+ c2.getScore());
    }

    @Override
    public void displayRoundWinner(String winnerName) {
        System.out.println(winnerName + " won the round !");
    }

    @Override
    public void displayEndGame(String gameWinner) {
        System.out.println("------ END ------");
        System.out.println(gameWinner+" won the game ! ");
        System.out.println("-----------------");
    }

    @Override
    public void displayOutOfRange() {
        System.out.println("Your card index is out of range !");
    }

    @Override
    public void handleNewGame() {
        System.out.println("To restart the game, press R");
        System.out.println("To quit the game, press Q");
        System.out.println("To start a new game, press P");
        String input = this.input.nextLine();
        if(Objects.equals(input, "q") || Objects.equals(input, "Q")) {
            this.controller.gameRun = false;
        }
        else if(Objects.equals(input, "r") || Objects.equals(input, "R")){
            this.controller.gameState = GameController.GameState.GameStart;
        }
        else {
            this.controller.gameState = GameController.GameState.InitGameValues;
        }
    }

    @Override
    public void displayScores(String player1Name, int player1Score, String player2Name, int player2Score) {

    }
}
