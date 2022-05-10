/*
Ethan McCarthy
5/2/2022
Project: Greed
Description: An implementation of player that performs actions autonomously
*/

class ComputerPlayer extends Player {
    //private int score = 0;
    //private Die[] dice;
    //more flexibility in your rolling is available once you get on the board by scoring 1000 points
    //private boolean onTheBoard = false;
    final private static String [] AI_Types = {"Random"};
    String type;
    
    //inheritss the Player constructor
    public ComputerPlayer(int handSize) {
        super(handSize);
        int t = (int) (Math.random() * AI_Types.length);
        this.type = AI_Types[t];
    }
    
    //TODO: Implement all the behaviour
    public int choiceType() {
        int choice = 0;
        switch(type) {
            case "Random": choice = randomChoice(); break;
            default: System.out.println("Error, AI is of an unimplemented type");
        }
        return choice;
    }
    
    
    /****************************************************
     * Random AI basically just flips a coin to make all of its decisions,
     * its funny and easy to implement
     * Methods: randomChoice()
     */
    
    int randomChoice() {
        return (int) (Math.random() * 2);
    }
    
    
    /***************************************************
     * Roll method from Player modified to make decisions based on the AI type
     */
    
    private void beginRoll() {
        int[] firstRoll = roll(6);
        String rollString;
        int answer;
        boolean turnContinue = true;
        
        while (isValidRoll(rollToString(firstRoll)) && turnContinue) {
            rollString = rollToString(firstRoll);
            printRoll(firstRoll);
            
            //prompt for continuing
            int numAvail = Roll.numDiceAvail(rollString);
            if (numAvail == 0) {
                numAvail = 6;
            }
            System.out.printf("Continue Turn by rolling your remaining %d dice? (Y/N)\n", numAvail);
            answer = choiceType();
            int intermediateScore = Roll.computeScore(firstRoll);
            if (answer == 1) {
                if (rollString.contains("5") && (intermediateScore > 50) && (numAvail != 6)) {
                    System.out.println("Roll your extra five? (Y/N)");
                    answer = choiceType();
                    if (answer == 1) {
                        rollString = rollString.replaceFirst("5", "");
                        intermediateScore = Roll.calculate(rollString);
                        turnScore += intermediateScore;
                        firstRoll = roll(numAvail + 1);
                    }
                    else {
                        firstRoll = roll(numAvail);
                        turnScore += intermediateScore;
                    }
                } 
                else {
                    firstRoll = roll(numAvail);
                    turnScore += intermediateScore;
                }
            }
            else {
                //choosing to stop
                turnScore += intermediateScore;
                System.out.printf("Turn end with score %d added to total score of: %d\n", turnScore, score);
                turnContinue = false;
                endTurn();
            }
        }
        
        //loop has stopped, invalid roll
        if (!isValidRoll(rollToString(firstRoll))) {
            printRoll(firstRoll);
            System.out.println("INVALID ROLL!! Turn ended.");
            forceEndTurn();
        }
    }
    
    private void beginFirstRoll() {
        int[] firstRoll = roll(6);
        String rollString;
        int answer;
        boolean turnContinue = true;
        
        while (isValidRoll(rollToString(firstRoll)) && turnContinue) {
            rollString = rollToString(firstRoll);
            printRoll(firstRoll);
            
            //prompt for continuing
            int numAvail = Roll.numDiceAvail(rollString);
            if (numAvail == 0) {
                numAvail = 6;
            }
            int intermediateScore = Roll.computeScore(firstRoll);
            turnScore += intermediateScore;
            if (turnScore < 1000) {
                System.out.printf("Until you are on the board you must continue rolling until you are on the board with 1000 points or forfeit your turn\n");
                System.out.println();
                System.out.println("Progress: " + turnScore + " Num Dice available: " + numAvail);
                answer = choiceType();
                if (answer == 1) {
                    forceEndTurn();
                }
                
                //int intermediateScore = Roll.computeScore(firstRoll);
                firstRoll = roll(numAvail);
                //turnScore += intermediateScore;
            }
            else {
                System.out.println("You're on the board! Continue rolling or end turn? \n Score: " + turnScore + " NumDice: " + numAvail);
                answer = choiceType();
                //intermediateScore = Roll.computeScore(firstRoll);
                if (answer == 1) {
                    if (rollString.contains("5") && (intermediateScore > 50) && (numAvail != 6)) {
                            firstRoll = roll(numAvail);
                            //turnScore += intermediateScore;
                    } 
                    else {
                        firstRoll = roll(numAvail);
                        //turnScore += intermediateScore;
                    }
                }
                else {
                    //choosing to stop
                    //turnScore += intermediateScore;
                    System.out.printf("Turn end with score %d added to total score of: %d\n", turnScore, score);
                    turnContinue = false;
                    endTurn();
                }
            }
        }
        
        //loop has stopped, invalid roll
        if (!isValidRoll(rollToString(firstRoll))) {
            printRoll(firstRoll);
            System.out.println("INVALID ROLL!! Turn ended.");
            forceEndTurn();
        }
    }
    
    //Print a message then start the turn
    public void startTurn() {
        System.out.println(type + " AI Score: " + score + (onTheBoard ? " is on the board!" : " is not on the board."));
        if (onTheBoard) {
            beginRoll();
        } 
        else {
            beginFirstRoll();
        }
    }
    
    public String toString() {
        String s = "Computer Player:\tScore = " + score;
        return s;
    }
}