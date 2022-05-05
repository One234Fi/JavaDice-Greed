/*
Ethan McCarthy
5/2/2022
Project: Greed
Description: An implementation of player that performs actions autonomously
*/

package greed;

class ComputerPlayer extends Player {
    //private int score = 0;
    //private Die[] dice;
    //more flexibility in your rolling is available once you get on the board by scoring 1000 points
    //private boolean onTheBoard = false;
    
    //inheritss the Player constructor
    public ComputerPlayer(int handSize) {
        super(handSize);
    }
    
    //TODO: Implement all the behaviour
    public void takeTurn() {
        
    }
    
    public void startTurn() {
        System.out.println("AI's turn!!" + score);
    }
    
    public String toString() {
        String s = "Computer Player:\tScore = " + score;
        return s;
    }
}