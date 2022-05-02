/*
Ethan McCarthy
4/26/2022
Project: Greed
Description: Player will have a "hand" of six dice, a score, and some functions
*/
import java.util.*;

class Player {
    private int score = 0;
    private Die[] dice;
    Scanner sc;
    
    public Player (int handSize, Scanner sc) {
        dice = new Die[handSize];
        for (int i = 0; i < handSize; i++) {
            dice[i] = new Die(6);
        }
        this.sc = sc;
    }
    
    void addToScore (int val) {
        score += val;
    }
    
    //Prompt the user to take an action
    public void startTurn() {
        System.out.println("Type Roll or Pass...");
        parseAction(sc.next());
    }
    
    //a list of actions to take
    void parseAction(String s) {
        
        switch (s.toLowerCase()) {
            case "pass": pass(); break;
            case "roll": roll(); break;
            
            
            default:    System.out.println("Invalid command!");
                        startTurn();
        }
    }
    
    //roll all the dice and print the results
    void roll() {
        int [] results = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            results[i] = dice[i].roll();
        }
        System.out.print("Result of roll: ");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + ", ");
        }
        System.out.println("");
    }
}