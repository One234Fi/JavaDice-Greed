/*
Ethan McCarthy
5/2/2022
Project: Greed
Description: Kinda just a crappy state machine/monitor thing atm, supposed to manage the players taking turn eventually
*/

public class TurnHandler {
    private static int currentTurn = 0;
    
    public static void start() {
        allowTurn(0);
    }
    
    public static void exitGame() {
        System.out.println("Game finished");
    }
    
    public static void claimWin(Player p) {
        if (p.score == 10000) {
            int index = 0;
            for (int i = 0; i < Greed.getPlayerList().length; i++) {
                if (Greed.getPlayerList()[i].score == 10000) {
                    index = i;
                }
            }
            System.out.println("Player " + index + " wins!");
            exitGame();
        }
    }
    
    //tell the player at "index" to take their turn
    private static void allowTurn(int index) {
        System.out.println("Player " + (index + 1) + "'s turn! Your score is " + Greed.getPlayerList()[index].getScore());
        
        Greed.getPlayerList()[index].startTurn();
    }
    
    //move the turn pointer and call the method for the next turn
    private static void incrementTurn() {
        if (currentTurn < Greed.getPlayerList().length-1) {
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