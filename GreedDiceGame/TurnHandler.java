/*
Ethan McCarthy
5/2/2022
Project: Greed
Description: Kinda just a crappy state machine/monitor thing atm, supposed to manage the players taking turn eventually
*/

package greed;

public class TurnHandler {
    
    /*public static class Monitor {
        static int currentTurn = 0;
        
        public void start() {
            allowTurn(0, Greed.getPlayerList()[0]);
        }
        
        //tell the player at "index" to take their turn
        void allowTurn(int index, Player player) {
            System.out.println("Player " + (index + 1) + "'s turn! Your score is " + player.getScore());

            player.startTurn();
            //turnToken = 0;
        }
        
        
        //move the turn pointer and call the method for the next turn
        void incrementTurn() {
            if (currentTurn < Greed.getPlayerList().length) {
                currentTurn++;
            }
            else {
                currentTurn = 0;
            }
            allowTurn(currentTurn, Greed.getPlayerList()[currentTurn]);
        }

        //this might be removed because of redundancy, if end of turn behaviour is added it won't be
        public void endTurn() {
            //turnToken = 1;
            incrementTurn();
        }
        
    }*/
    
    
    //Player[] playerList;
    private static int currentTurn = 0;
    private static int turnToken = 1;
    
    /*public TurnHandler(Player[] players) {
        playerList = players;
    }*/
    
    //send a message to a player to start their turn, then recieve said message to end it and move to next turn
    
    public static void start() {
        allowTurn(0);
    }
    
    //tell the player at "index" to take their turn
    private static void allowTurn(int index) {
        System.out.println("Player " + (index + 1) + "'s turn! Your score is " + Greed.getPlayerList()[index].getScore());
        
        Greed.getPlayerList()[index].startTurn();
    }
    
    //move the turn pointer and call the method for the next turn
    private static void incrementTurn() {
        if (currentTurn < Greed.getPlayerList().length) {
            currentTurn++;
        }
        else {
            currentTurn = 0;
        }
        allowTurn(currentTurn);
    }
    
    //this might be removed because of redundancy, if end of turn behaviour is added it won't be
    public static void endTurn() {
        incrementTurn();
    }
    
}