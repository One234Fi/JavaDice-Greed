/*
Ethan McCarthy
4/26/2022
Project: Greed
Description: Player will have a "hand" of six dice, a score, and some functions
*/

package greed;

import java.util.*;

class Player {
    protected int score = 0;
    protected int turnScore = 0;
    protected Die[] dice;
    //more flexibility in your rolling is available once you get on the board by scoring 1000 points 
    protected boolean onTheBoard = false;
    
    Scanner sc = new Scanner(System.in);
    
    public Player (int handSize) {
        dice = new Die[handSize];
        for (int i = 0; i < handSize; i++) {
            dice[i] = new Die(6);
        }
    }
    
    protected void addToScore () {
        score += turnScore;
        turnScore = 0;
    }
    
    public int getScore() {
        return score;
    }
    
    //Prompt the user to take an action
    public void startTurn() {
        //System.out.println("Turn start! Your score is: " + score);
        if (!onTheBoard) {
            System.out.println("Type \"Roll\" to take your turn...");
            parseAction(sc.next());
        }
        else {
            System.out.println("Type \"Roll\" to begin rolling or \"Pass\" to skip your turn...");
            parseAction(sc.next());
        }
    }
    
    //a list of actions to take
    protected void parseAction(String s) {
        
        switch (s.toLowerCase()) {
            case "pass": endTurn(); break;
            case "roll": beginRoll(); break;
            case "demoroll": roll(); break;
            
            
            default:    System.out.println("Invalid command!");
                        startTurn();
        }
    }
    
    protected void beginRoll() {
        int[] firstRoll = roll(6);
        while (isValidRoll(firstRoll)) {
            printRoll(firstRoll);
            //prompt for continuing
            if (keepGoing) {
                if (firstRollcontains5) {
                    System.out.println("Roll your extra five?");
                    if (yes) {
                        turnScore -= 50;
                        roll (numAvail + 1);
                    }
                    else {
                        roll (numAvail)
                    }
                    
                } 
                else {
                    roll(numAvail)
                }
                 
            }
            else {
                endTurn();
            }
        }
        
        //loop has stopped, invalid roll
        printRoll(firstRoll);
        forceEndTurn();
    }
    
    //roll all the dice and print the results
    protected void roll() {
        int [] results = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            results[i] = dice[i].roll();
        }
        System.out.print("Result of roll: ");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + ", ");
        }
        System.out.println("");
        startTurn();
    }
    
    protected int[] roll(int diceToRoll) {
        int [] results = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            results[i] = dice[i].roll();
        }
        return results;
    }
    
    protected boolean isValidRoll(int[] roll) {
        int [] temp = roll;
        Arrays.sort(temp);
        String s = "";
        for (int i = 0; i < temp.length; i++) {
            s += temp[i];
        }
        
        //check for certain sequences to see if the roll is valid
        if (s.contains("123456")) {
            return true;
        }
        if (s.contains("222") || s.contains("333") || s.contains("444")|| s.contains("666")) {
            return true;
        }
        
        return s.contains("1") || s.contains("5");
    }
    
    //get an integer from the user to indicate which dice to select for rolling
    protected int dieSelection() {
        System.out.println("Please indicate which dice to select by inputting a sequence of 1s and 0s, "
                + "\n1s for selected dice and 0s for not selected dice. Example: 101100 to select the 1st, 3rd, and 4th dice");
        String attemptedSelection = sc.next();
        boolean validSelection = false;
        while (!validSelection) {
            if (attemptedSelection.length() > 6 && attemptedSelection.matches("[0-1]+")) {
                validSelection = true;
                int selection = Integer.parseInt(attemptedSelection);
                return selection;
            }
            else {
                System.out.println("Invalid selection, please make sure your selection is 6 digits long and only contains 1s and 0s...");
                attemptedSelection = sc.next();
            }
        }
        
        return -1;
    }
    
    int calculateScore(int[] rollResult) {
        int[] temp = rollResult;
        Arrays.sort(temp);
        String s = "";
        for (int i = 0; i < temp.length; i++) {
            s += temp[i];
        }
        int placeHolder = 0;
        
        if (s.contains("123456")) {
            return 1200;
        }
        if (s.contains("666")) {
            s = s.replace("666", "");
            placeHolder = 600;
            for (int i = 0; i < 3; i++) {
                
            }
            return 4800;
        }
        if (s.contains("555555")) {
            return 4000;
        }
        if (s.contains()) {
            return
        }
        
        
        return 0;
    }
    
    protected void forceEndTurn() {
        turnScore = 0;
        TurnHandler.endTurn();
    }
    
    protected void endTurn() {
        addToScore();
        TurnHandler.endTurn();
    }
    
    String[] validResults = {"1", "5", "222", "333", "444", "666", "123456"};
    
    
    @Override
    public String toString() {
        String s = "Human Player:\t\tScore = " + score;
        return s;
    }
}