package main.java.fr.gorisse.battleGame.view;

import main.java.fr.gorisse.battleGame.controller.GameController;
import main.java.fr.gorisse.battleGame.model.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class ShellView implements IView {
    private GameController controller;
    private Scanner input;
    public ShellView(){
        controller = new GameController();
        this.input = new Scanner(System.in);
    }
    @Override
    public void displaySomething() {
        System.out.println("display something");
    }

    @Override
    public void displayStartGame() {
        System.out.println("----------------------------------");
        System.out.println("------------GAME START------------");
        System.out.println("----------------------------------");
    }

    @Override
    public void displayGreetings() {
        System.out.println("----------------------------------");
        System.out.println("--------------WELCOME-------------");
        System.out.println("----------------------------------");

    }

    @Override
    public void displayPlayerToPlay(String playerName) {
        System.out.println("------IT'S"+playerName+" TO PLAY-------");
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

    }

    @Override
    public void displayDuel(Card c1, Card c2) {

    }
}
