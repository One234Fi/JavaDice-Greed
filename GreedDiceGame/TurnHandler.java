/*
Ethan McCarthy
5/2/2022
Project: Greed
Description: Kinda just a crappy state machine/monitor thing atm, supposed to manage the players taking turn eventually
*/

public class TurnHandler {
    Object[] playerList;
    int currentTurn = 0;
    //int turnToken = 1;
    
    public TurnHandler(Object[] players) {
        playerList = players;
        
    }
    
    //send a message to a player to start their turn, then recieve said message to end it and move to next turn
    
    //tell the player at "index" to take their turn
    void allowTurn(int index) {
        System.out.println("Player " + index + "'s turn!");
        
        playerList[index].startTurn();
    }
    
    //move the turn pointer and call the method for the next turn
    void incrementTurn() {
        if (currentTurn < playerList.length) {
            currentTurn++;
        }
        else {
            currentTurn = 0;
        }
        allowTurn(currentTurn);
    }
    
    //this might be removed because of redundancy, if end of turn behaviour is added it won't be
    public void endTurn() {
        incrementTurn();
    }
    
}