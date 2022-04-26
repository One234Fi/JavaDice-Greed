/*
Ethan McCarthy
4/26/2022
Project: Greed
Description: Player will have a "hand" of six dice, a score, and some functions
*/

class Player {
    private int score = 0;
    private Die[] dice;
    
    public Player (int handSize) {
        dice = new Die[handSize];
        for (int i = 0; i < handSize; i++) {
            dice[i] = new Die(6);
        }
        
    }
    
    void addToScore (int val) {
        score += val;
    }
}