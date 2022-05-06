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
        String rollString = rollToString(firstRoll);
        String answer;
        printRoll(firstRoll);
        while (isValidRoll(rollString)) {
            //prompt for continuing
            System.out.println("Continue Turn? (Y/N)");
            answer = sc.next();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                int intermediateScore = Roll.computeScore(firstRoll);
                if (rollString.contains("5") && (intermediateScore > 50) && (intermediateScore != 500)) {
                    System.out.println("Roll your extra five? (Y/N)");
                    answer = sc.next();
                    if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
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
    
    protected void printRoll(int [] roll) {
        String s = "Roll result: ";
        for (int i : roll) {
            s += i + " ";
        }
        s += "Score: " + Roll.computeScore(roll);
        System.out.println(s);
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
    
    //take a number of dice and roll them
    protected int[] roll(int diceToRoll) {
        int [] results = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            results[i] = dice[i].roll();
        }
        return results;
    }
    
    //Turns the int[] representation of a roll into an ordered string so its easier for other methods to manipulate
    protected String rollToString(int [] roll) {
        int [] temp = roll;
        Arrays.sort(temp);
        String s = "";
        for (int i = 0; i < temp.length; i++) {
            s += temp[i];
        }
        return s;
    }
    
    //boolean that determines if a string representaion of a roll is valid
    protected boolean isValidRoll(String roll) {
        //check for certain sequences to see if the roll is valid
        return (roll.contains("1") || roll.contains("5") || roll.contains("222") || roll.contains("333") || roll.contains("444")|| roll.contains("666"));
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
     
    //end the player's turn without adding to their total score
    protected void forceEndTurn() {
        turnScore = 0;
        TurnHandler.endTurn();
    }
    
    //end the player's turn while adding their turn score to their total score
    protected void endTurn() {
        addToScore();
        TurnHandler.endTurn();
    }
    
    @Override
    public String toString() {
        String s = "Human Player:\t\tScore = " + score;
        return s;
    }
}