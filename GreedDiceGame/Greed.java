/*
Ethan McCarthy
4/26/2022
Project: Greed
Description: Class to hold the main method, will probably handle some Menuing and I/O
*/

import java.util.*;

public class Greed {
    private static Player[] players;
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many humans are going to play?...");
        int numPlayers = sc.nextInt();
        System.out.println("How many computer players are going to play?...");
        int numCPUs = sc.nextInt();
        
        players = initializePlayers(numPlayers, numCPUs);
        
        System.out.println(gameState());
        
        
        TurnHandler.start();
    }
    
    //a string representing the current game state by calling each player's toString method, which contains all their scores
    public static String gameState() {
        String s = "";
        for (int i = 0; i < players.length; i++) {
            s += "Player " + (i+1) + " " + players[i].toString() + "\n";
        }
        return s;
    }
    
    //initialize the player array with a specified number of human and computer players
    private static Player[] initializePlayers(int numPlayers, int numCPUs) {
        //create a temp array and make it at least 2 long or as long as the total number of players
        Player[] temp;
        int totalPlayers = numPlayers + numCPUs;
        
        if (totalPlayers < 2) {
            temp = new Player[2];
        }
        else {
            temp = new Player[totalPlayers];
        }
        
        //fill the first portion of the array with human players, then fill the rest with computers
        
        //humans
        int progress = 0;
        for (int i = 0; i < numPlayers; i++) {
            temp[i] = new Player(6);
            progress ++;
        }
        
        //computers
        for (int i = progress; i < temp.length; i++) {
            temp[i] = new ComputerPlayer(6);
        }
        
        return temp;
    }
    
    public static Player[] getPlayerList() {
        return players;
    }
}